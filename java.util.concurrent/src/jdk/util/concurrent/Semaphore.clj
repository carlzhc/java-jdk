(ns jdk.util.concurrent.Semaphore
  "A counting semaphore.  Conceptually, a semaphore maintains a set of
  permits.  Each acquire() blocks if necessary until a permit is
  available, and then takes it.  Each release() adds a permit,
  potentially releasing a blocking acquirer.
  However, no actual permit objects are used; the Semaphore just
  keeps a count of the number available and acts accordingly.

  Semaphores are often used to restrict the number of threads than can
  access some (physical or logical) resource. For example, here is
  a class that uses a semaphore to control access to a pool of items:


  class Pool {
    private static final int MAX_AVAILABLE = 100;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    public Object getItem() throws InterruptedException {
      available.acquire();
      return getNextAvailableItem();
    }

    public void putItem(Object x) {
      if (markAsUnused(x))
        available.release();
    }

    // Not a particularly efficient data structure; just for demo

    protected Object[] items = ... whatever kinds of items being managed
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {
      for (int i = 0; i < MAX_AVAILABLE; +i) {
        if (!used[i]) {
           used[i] = true;
           return items[i];
        }
      }
      return null; // not reached
    }

    protected synchronized boolean markAsUnused(Object item) {
      for (int i = 0; i < MAX_AVAILABLE; +i) {
        if (item == items[i]) {
           if (used[i]) {
             used[i] = false;
             return true;
           } else
             return false;
        }
      }
      return false;
    }
  }

  Before obtaining an item each thread must acquire a permit from
  the semaphore, guaranteeing that an item is available for use. When
  the thread has finished with the item it is returned back to the
  pool and a permit is returned to the semaphore, allowing another
  thread to acquire that item.  Note that no synchronization lock is
  held when acquire() is called as that would prevent an item
  from being returned to the pool.  The semaphore encapsulates the
  synchronization needed to restrict access to the pool, separately
  from any synchronization needed to maintain the consistency of the
  pool itself.

  A semaphore initialized to one, and which is used such that it
  only has at most one permit available, can serve as a mutual
  exclusion lock.  This is more commonly known as a binary
  semaphore, because it only has two states: one permit
  available, or zero permits available.  When used in this way, the
  binary semaphore has the property (unlike many Lock
  implementations), that the `lock` can be released by a
  thread other than the owner (as semaphores have no notion of
  ownership).  This can be useful in some specialized contexts, such
  as deadlock recovery.

   The constructor for this class optionally accepts a
  fairness parameter. When set false, this class makes no
  guarantees about the order in which threads acquire permits. In
  particular, barging is permitted, that is, a thread
  invoking acquire() can be allocated a permit ahead of a
  thread that has been waiting - logically the new thread places itself at
  the head of the queue of waiting threads. When fairness is set true, the
  semaphore guarantees that threads invoking any of the acquire methods are selected to obtain permits in the order in
  which their invocation of those methods was processed
  (first-in-first-out; FIFO). Note that FIFO ordering necessarily
  applies to specific internal points of execution within these
  methods.  So, it is possible for one thread to invoke
  acquire before another, but reach the ordering point after
  the other, and similarly upon return from the method.
  Also note that the untimed tryAcquire methods do not
  honor the fairness setting, but will take any permits that are
  available.

  Generally, semaphores used to control resource access should be
  initialized as fair, to ensure that no thread is starved out from
  accessing a resource. When using semaphores for other kinds of
  synchronization control, the throughput advantages of non-fair
  ordering often outweigh fairness considerations.

  This class also provides convenience methods to acquire and release multiple
  permits at a time.  Beware of the increased risk of indefinite
  postponement when these methods are used without fairness set true.

  Memory consistency effects: Actions in a thread prior to calling
  a `release` method such as release()
  happen-before
  actions following a successful `acquire` method such as acquire()
  in another thread."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent Semaphore]))

(defn ->semaphore
  "Constructor.

  Creates a Semaphore with the given number of
   permits and the given fairness setting.

  permits - the initial number of permits available. This value may be negative, in which case releases must occur before any acquires will be granted. - `int`
  fair - true if this semaphore will guarantee first-in first-out granting of permits under contention, else false - `boolean`"
  (^Semaphore [^Integer permits ^Boolean fair]
    (new Semaphore permits fair))
  (^Semaphore [^Integer permits]
    (new Semaphore permits)))

(defn release
  "Releases the given number of permits, returning them to the semaphore.

   Releases the given number of permits, increasing the number of
   available permits by that amount.
   If any threads are trying to acquire permits, then one
   is selected and given the permits that were just released.
   If the number of available permits satisfies that thread's request
   then that thread is (re)enabled for thread scheduling purposes;
   otherwise the thread will wait until sufficient permits are available.
   If there are still permits available
   after this thread's request has been satisfied, then those permits
   are assigned in turn to other threads trying to acquire permits.

   There is no requirement that a thread that releases a permit must
   have acquired that permit by calling acquire.
   Correct usage of a semaphore is established by programming convention
   in the application.

  permits - the number of permits to release - `int`

  throws: java.lang.IllegalArgumentException - if permits is negative"
  ([^Semaphore this ^Integer permits]
    (-> this (.release permits)))
  ([^Semaphore this]
    (-> this (.release))))

(defn drain-permits
  "Acquires and returns all permits that are immediately available.

  returns: the number of permits acquired - `int`"
  (^Integer [^Semaphore this]
    (-> this (.drainPermits))))

(defn fair?
  "Returns true if this semaphore has fairness set true.

  returns: true if this semaphore has fairness set true - `boolean`"
  (^Boolean [^Semaphore this]
    (-> this (.isFair))))

(defn get-queue-length
  "Returns an estimate of the number of threads waiting to acquire.
   The value is only an estimate because the number of threads may
   change dynamically while this method traverses internal data
   structures.  This method is designed for use in monitoring of the
   system state, not for synchronization control.

  returns: the estimated number of threads waiting for this lock - `int`"
  (^Integer [^Semaphore this]
    (-> this (.getQueueLength))))

(defn acquire-uninterruptibly
  "Acquires the given number of permits from this semaphore,
   blocking until all are available.

   Acquires the given number of permits, if they are available,
   and returns immediately, reducing the number of available permits
   by the given amount.

   If insufficient permits are available then the current thread becomes
   disabled for thread scheduling purposes and lies dormant until
   some other thread invokes one of the release
   methods for this semaphore, the current thread is next to be assigned
   permits and the number of available permits satisfies this request.

   If the current thread is interrupted
   while waiting for permits then it will continue to wait and its
   position in the queue is not affected.  When the thread does return
   from this method its interrupt status will be set.

  permits - the number of permits to acquire - `int`

  throws: java.lang.IllegalArgumentException - if permits is negative"
  ([^Semaphore this ^Integer permits]
    (-> this (.acquireUninterruptibly permits)))
  ([^Semaphore this]
    (-> this (.acquireUninterruptibly))))

(defn to-string
  "Returns a string identifying this semaphore, as well as its state.
   The state, in brackets, includes the String `Permits =`
   followed by the number of permits.

  returns: a string identifying this semaphore, as well as its state - `java.lang.String`"
  (^java.lang.String [^Semaphore this]
    (-> this (.toString))))

(defn has-queued-threads?
  "Queries whether any threads are waiting to acquire. Note that
   because cancellations may occur at any time, a true
   return does not guarantee that any other thread will ever
   acquire.  This method is designed primarily for use in
   monitoring of the system state.

  returns: true if there may be other threads waiting to
           acquire the lock - `boolean`"
  (^Boolean [^Semaphore this]
    (-> this (.hasQueuedThreads))))

(defn try-acquire
  "Acquires the given number of permits from this semaphore, if all
   become available within the given waiting time and the current
   thread has not been interrupted.

   Acquires the given number of permits, if they are available and
   returns immediately, with the value true,
   reducing the number of available permits by the given amount.

   If insufficient permits are available then
   the current thread becomes disabled for thread scheduling
   purposes and lies dormant until one of three things happens:

   Some other thread invokes one of the release
   methods for this semaphore, the current thread is next to be assigned
   permits and the number of available permits satisfies this request; or
   Some other thread interrupts
   the current thread; or
   The specified waiting time elapses.


   If the permits are acquired then the value true is returned.

   If the current thread:

   has its interrupted status set on entry to this method; or
   is interrupted while waiting
   to acquire the permits,

   then InterruptedException is thrown and the current thread's
   interrupted status is cleared.
   Any permits that were to be assigned to this thread, are instead
   assigned to other threads trying to acquire permits, as if
   the permits had been made available by a call to release().

   If the specified waiting time elapses then the value false
   is returned.  If the time is less than or equal to zero, the method
   will not wait at all.  Any permits that were to be assigned to this
   thread, are instead assigned to other threads trying to acquire
   permits, as if the permits had been made available by a call to
   release().

  permits - the number of permits to acquire - `int`
  timeout - the maximum time to wait for the permits - `long`
  unit - the time unit of the timeout argument - `java.util.concurrent.TimeUnit`

  returns: true if all permits were acquired and false
           if the waiting time elapsed before all permits were acquired - `boolean`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  (^Boolean [^Semaphore this ^Integer permits ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.tryAcquire permits timeout unit)))
  (^Boolean [^Semaphore this ^Long timeout ^java.util.concurrent.TimeUnit unit]
    (-> this (.tryAcquire timeout unit)))
  (^Boolean [^Semaphore this ^Integer permits]
    (-> this (.tryAcquire permits)))
  (^Boolean [^Semaphore this]
    (-> this (.tryAcquire))))

(defn available-permits
  "Returns the current number of permits available in this semaphore.

   This method is typically used for debugging and testing purposes.

  returns: the number of permits available in this semaphore - `int`"
  (^Integer [^Semaphore this]
    (-> this (.availablePermits))))

(defn acquire
  "Acquires the given number of permits from this semaphore,
   blocking until all are available,
   or the thread is interrupted.

   Acquires the given number of permits, if they are available,
   and returns immediately, reducing the number of available permits
   by the given amount.

   If insufficient permits are available then the current thread becomes
   disabled for thread scheduling purposes and lies dormant until
   one of two things happens:

   Some other thread invokes one of the release
   methods for this semaphore, the current thread is next to be assigned
   permits and the number of available permits satisfies this request; or
   Some other thread interrupts
   the current thread.


   If the current thread:

   has its interrupted status set on entry to this method; or
   is interrupted while waiting
   for a permit,

   then InterruptedException is thrown and the current thread's
   interrupted status is cleared.
   Any permits that were to be assigned to this thread are instead
   assigned to other threads trying to acquire permits, as if
   permits had been made available by a call to release().

  permits - the number of permits to acquire - `int`

  throws: java.lang.InterruptedException - if the current thread is interrupted"
  ([^Semaphore this ^Integer permits]
    (-> this (.acquire permits)))
  ([^Semaphore this]
    (-> this (.acquire))))

