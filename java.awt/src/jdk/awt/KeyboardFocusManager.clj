(ns jdk.awt.KeyboardFocusManager
  "The KeyboardFocusManager is responsible for managing the active and focused
  Windows, and the current focus owner. The focus owner is defined as the
  Component in an application that will typically receive all KeyEvents
  generated by the user. The focused Window is the Window that is, or
  contains, the focus owner. Only a Frame or a Dialog can be the active
  Window. The native windowing system may denote the active Window or its
  children with special decorations, such as a highlighted title bar. The
  active Window is always either the focused Window, or the first Frame or
  Dialog that is an owner of the focused Window.

  The KeyboardFocusManager is both a centralized location for client code to
  query for the focus owner and initiate focus changes, and an event
  dispatcher for all FocusEvents, WindowEvents related to focus, and
  KeyEvents.

  Some browsers partition applets in different code bases into separate
  contexts, and establish walls between these contexts. In such a scenario,
  there will be one KeyboardFocusManager per context. Other browsers place all
  applets into the same context, implying that there will be only a single,
  global KeyboardFocusManager for all applets. This behavior is
  implementation-dependent. Consult your browser's documentation for more
  information. No matter how many contexts there may be, however, there can
  never be more than one focus owner, focused Window, or active Window, per
  ClassLoader.

  Please see

  How to Use the Focus Subsystem,
  a section in The Java Tutorial, and the
  Focus Specification
  for more information."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt KeyboardFocusManager]))

(defn ->keyboard-focus-manager
  "Constructor.

  Initializes a KeyboardFocusManager."
  (^KeyboardFocusManager []
    (new KeyboardFocusManager )))

(def *-forward-traversal-keys
  "Static Constant.

  The identifier for the Forward focus traversal keys.

  type: int"
  KeyboardFocusManager/FORWARD_TRAVERSAL_KEYS)

(def *-backward-traversal-keys
  "Static Constant.

  The identifier for the Backward focus traversal keys.

  type: int"
  KeyboardFocusManager/BACKWARD_TRAVERSAL_KEYS)

(def *-up-cycle-traversal-keys
  "Static Constant.

  The identifier for the Up Cycle focus traversal keys.

  type: int"
  KeyboardFocusManager/UP_CYCLE_TRAVERSAL_KEYS)

(def *-down-cycle-traversal-keys
  "Static Constant.

  The identifier for the Down Cycle focus traversal keys.

  type: int"
  KeyboardFocusManager/DOWN_CYCLE_TRAVERSAL_KEYS)

(defn *get-current-keyboard-focus-manager
  "Returns the current KeyboardFocusManager instance for the calling
   thread's context.

  returns: this thread's context's KeyboardFocusManager - `java.awt.KeyboardFocusManager`"
  (^java.awt.KeyboardFocusManager []
    (KeyboardFocusManager/getCurrentKeyboardFocusManager )))

(defn *set-current-keyboard-focus-manager
  "Sets the current KeyboardFocusManager instance for the calling thread's
   context. If null is specified, then the current KeyboardFocusManager
   is replaced with a new instance of DefaultKeyboardFocusManager.

   If a SecurityManager is installed, the calling thread must be granted
   the AWTPermission `replaceKeyboardFocusManager` in order to replace the
   the current KeyboardFocusManager. If this permission is not granted,
   this method will throw a SecurityException, and the current
   KeyboardFocusManager will be unchanged.

  new-manager - the new KeyboardFocusManager for this thread's context - `java.awt.KeyboardFocusManager`

  throws: java.lang.SecurityException - if the calling thread does not have permission to replace the current KeyboardFocusManager"
  ([^java.awt.KeyboardFocusManager new-manager]
    (KeyboardFocusManager/setCurrentKeyboardFocusManager new-manager)))

(defn get-permanent-focus-owner
  "Returns the permanent focus owner, if the permanent focus owner is in
   the same context as the calling thread. The permanent focus owner is
   defined as the last Component in an application to receive a permanent
   FOCUS_GAINED event. The focus owner and permanent focus owner are
   equivalent unless a temporary focus change is currently in effect. In
   such a situation, the permanent focus owner will again be the focus
   owner when the temporary focus change ends.

  returns: the permanent focus owner, or null if the permanent focus owner
           is not a member of the calling thread's context - `java.awt.Component`"
  (^java.awt.Component [^KeyboardFocusManager this]
    (-> this (.getPermanentFocusOwner))))

(defn clear-focus-owner
  "Clears the focus owner at both the Java and native levels if the
   focus owner exists and resides in the same context as the calling thread,
   otherwise the method returns silently.

   The focus owner component will receive a permanent FOCUS_LOST event.
   After this operation completes, the native windowing system will discard
   all user-generated KeyEvents until the user selects a new Component to
   receive focus, or a Component is given focus explicitly via a call to
   requestFocus(). This operation does not change the focused or
   active Windows."
  ([^KeyboardFocusManager this]
    (-> this (.clearFocusOwner))))

(defn remove-key-event-dispatcher
  "Removes a KeyEventDispatcher which was previously added to this
   KeyboardFocusManager's dispatcher chain. This KeyboardFocusManager
   cannot itself be removed, unless it was explicitly re-registered via a
   call to addKeyEventDispatcher.

   If a null dispatcher is specified, if the specified dispatcher is not
   in the dispatcher chain, or if this KeyboardFocusManager is specified
   without having been explicitly re-registered, no action is taken and no
   exception is thrown.

   In a multithreaded application, KeyEventDispatcher behaves
   the same as other AWT listeners.  See
   AWT Threading Issues for more details.

  dispatcher - the KeyEventDispatcher to remove from the dispatcher chain - `java.awt.KeyEventDispatcher`"
  ([^KeyboardFocusManager this ^java.awt.KeyEventDispatcher dispatcher]
    (-> this (.removeKeyEventDispatcher dispatcher))))

(defn get-default-focus-traversal-keys
  "Returns a Set of default focus traversal keys for a given traversal
   operation. This traversal key Set will be in effect on all Windows that
   have no such Set of their own explicitly defined. This Set will also be
   inherited, recursively, by any child Component of those Windows that has
   no such Set of its own explicitly defined. (See
   setDefaultFocusTraversalKeys for a full description of each
   operation.)

  id - one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS - `int`

  returns: the Set of AWTKeyStrokes
           for the specified operation; the Set
           will be unmodifiable, and may be empty; null
           will never be returned - `java.util.Set<java.awt.AWTKeyStroke>`

  throws: java.lang.IllegalArgumentException - if id is not one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS"
  (^java.util.Set [^KeyboardFocusManager this ^Integer id]
    (-> this (.getDefaultFocusTraversalKeys id))))

(defn get-current-focus-cycle-root
  "Returns the current focus cycle root, if the current focus cycle root is
   in the same context as the calling thread. If the focus owner is itself
   a focus cycle root, then it may be ambiguous as to which Components
   represent the next and previous Components to focus during normal focus
   traversal. In that case, the current focus cycle root is used to
   differentiate among the possibilities.

   This method is intended to be used only by KeyboardFocusManagers and
   focus implementations. It is not for general client use.

  returns: the current focus cycle root, or null if the current focus cycle
           root is not a member of the calling thread's context - `java.awt.Container`"
  (^java.awt.Container [^KeyboardFocusManager this]
    (-> this (.getCurrentFocusCycleRoot))))

(defn focus-next-component
  "Focuses the Component after aComponent, typically based on a
   FocusTraversalPolicy.

  a-component - the Component that is the basis for the focus traversal operation - `java.awt.Component`"
  ([^KeyboardFocusManager this ^java.awt.Component a-component]
    (-> this (.focusNextComponent a-component)))
  ([^KeyboardFocusManager this]
    (-> this (.focusNextComponent))))

(defn get-active-window
  "Returns the active Window, if the active Window is in the same context
   as the calling thread. Only a Frame or a Dialog can be the active
   Window. The native windowing system may denote the active Window or its
   children with special decorations, such as a highlighted title bar.
   The active Window is always either the focused Window, or the first
   Frame or Dialog that is an owner of the focused Window.

  returns: the active Window, or null if the active Window is not a member
           of the calling thread's context - `java.awt.Window`"
  (^java.awt.Window [^KeyboardFocusManager this]
    (-> this (.getActiveWindow))))

(defn get-focus-owner
  "Returns the focus owner, if the focus owner is in the same context as
   the calling thread. The focus owner is defined as the Component in an
   application that will typically receive all KeyEvents generated by the
   user. KeyEvents which map to the focus owner's focus traversal keys will
   not be delivered if focus traversal keys are enabled for the focus
   owner. In addition, KeyEventDispatchers may retarget or consume
   KeyEvents before they reach the focus owner.

  returns: the focus owner, or null if the focus owner is not a member of
           the calling thread's context - `java.awt.Component`"
  (^java.awt.Component [^KeyboardFocusManager this]
    (-> this (.getFocusOwner))))

(defn get-focused-window
  "Returns the focused Window, if the focused Window is in the same context
   as the calling thread. The focused Window is the Window that is or
   contains the focus owner.

  returns: the focused Window, or null if the focused Window is not a
           member of the calling thread's context - `java.awt.Window`"
  (^java.awt.Window [^KeyboardFocusManager this]
    (-> this (.getFocusedWindow))))

(defn down-focus-cycle
  "Moves the focus down one focus traversal cycle. Typically, if
   aContainer is a focus cycle root, then the focus owner is set to
   aContainer's default Component to focus, and the current focus cycle
   root is set to aContainer. If aContainer is not a focus cycle root, then
   no focus traversal operation occurs.

  a-container - the Container that is the basis for the focus traversal operation - `java.awt.Container`"
  ([^KeyboardFocusManager this ^java.awt.Container a-container]
    (-> this (.downFocusCycle a-container)))
  ([^KeyboardFocusManager this]
    (-> this (.downFocusCycle))))

(defn remove-key-event-post-processor
  "Removes a previously added KeyEventPostProcessor from this
   KeyboardFocusManager's post-processor chain. This KeyboardFocusManager
   cannot itself be entirely removed from the chain. Only additional
   references added via addKeyEventPostProcessor can be
   removed.

   If a null post-processor is specified, if the specified post-processor
   is not in the post-processor chain, or if this KeyboardFocusManager is
   specified without having been explicitly added, no action is taken and
   no exception is thrown.

   In a multithreaded application, KeyEventPostProcessor behaves
   the same as other AWT listeners.  See
   AWT Threading Issues for more details.

  processor - the KeyEventPostProcessor to remove from the post- processor chain - `java.awt.KeyEventPostProcessor`"
  ([^KeyboardFocusManager this ^java.awt.KeyEventPostProcessor processor]
    (-> this (.removeKeyEventPostProcessor processor))))

(defn remove-property-change-listener
  "Removes a PropertyChangeListener from the listener list for a specific
   property. This method should be used to remove PropertyChangeListeners
   that were registered for a specific bound property.

   If listener is null, no exception is thrown and no action is performed.

  property-name - a valid property name - `java.lang.String`
  listener - the PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([^KeyboardFocusManager this ^java.lang.String property-name ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener property-name listener)))
  ([^KeyboardFocusManager this ^java.beans.PropertyChangeListener listener]
    (-> this (.removePropertyChangeListener listener))))

(defn add-key-event-dispatcher
  "Adds a KeyEventDispatcher to this KeyboardFocusManager's dispatcher
   chain. This KeyboardFocusManager will request that each
   KeyEventDispatcher dispatch KeyEvents generated by the user before
   finally dispatching the KeyEvent itself. KeyEventDispatchers will be
   notified in the order in which they were added. Notifications will halt
   as soon as one KeyEventDispatcher returns true from its
   dispatchKeyEvent method. There is no limit to the total
   number of KeyEventDispatchers which can be added, nor to the number of
   times which a particular KeyEventDispatcher instance can be added.

   If a null dispatcher is specified, no action is taken and no exception
   is thrown.

   In a multithreaded application, KeyEventDispatcher behaves
   the same as other AWT listeners.  See
   AWT Threading Issues for more details.

  dispatcher - the KeyEventDispatcher to add to the dispatcher chain - `java.awt.KeyEventDispatcher`"
  ([^KeyboardFocusManager this ^java.awt.KeyEventDispatcher dispatcher]
    (-> this (.addKeyEventDispatcher dispatcher))))

(defn get-default-focus-traversal-policy
  "Returns the default FocusTraversalPolicy. Top-level components
   use this value on their creation to initialize their own focus traversal
   policy by explicit call to Container.setFocusTraversalPolicy.

  returns: the default FocusTraversalPolicy. null will never be returned. - `java.awt.FocusTraversalPolicy`"
  (^java.awt.FocusTraversalPolicy [^KeyboardFocusManager this]
    (-> this (.getDefaultFocusTraversalPolicy))))

(defn dispatch-key-event
  "Typically this method will be called by dispatchEvent if no
   other KeyEventDispatcher in the dispatcher chain dispatched the
   KeyEvent, or if no other KeyEventDispatchers are registered. If an
   implementation of this method returns false,
   dispatchEvent may try to dispatch the KeyEvent itself, or
   may simply return false. If true is returned,
   dispatchEvent should return true as well.

  e - the KeyEvent which the current KeyboardFocusManager has requested that this KeyEventDispatcher dispatch - `java.awt.event.KeyEvent`

  returns: true if the KeyEvent was dispatched;
           false otherwise - `boolean`"
  (^Boolean [^KeyboardFocusManager this ^java.awt.event.KeyEvent e]
    (-> this (.dispatchKeyEvent e))))

(defn clear-global-focus-owner
  "Clears the global focus owner at both the Java and native levels. If
   there exists a focus owner, that Component will receive a permanent
   FOCUS_LOST event. After this operation completes, the native windowing
   system will discard all user-generated KeyEvents until the user selects
   a new Component to receive focus, or a Component is given focus
   explicitly via a call to requestFocus(). This operation
   does not change the focused or active Windows.

   If a SecurityManager is installed, the calling thread must be granted
   the `replaceKeyboardFocusManager` AWTPermission. If this permission is
   not granted, this method will throw a SecurityException, and the current
   focus owner will not be cleared.

   This method is intended to be used only by KeyboardFocusManager set as
   current KeyboardFocusManager for the calling thread's context. It is not
   for general client use.

  throws: java.lang.SecurityException - if the calling thread does not have `replaceKeyboardFocusManager` permission"
  ([^KeyboardFocusManager this]
    (-> this (.clearGlobalFocusOwner))))

(defn get-property-change-listeners
  "Returns an array of all the PropertyChangeListeners
   associated with the named property.

  property-name - `java.lang.String`

  returns: all of the PropertyChangeListeners associated with
           the named property or an empty array if no such listeners have
           been added. - `java.beans.PropertyChangeListener[]`"
  ([^KeyboardFocusManager this ^java.lang.String property-name]
    (-> this (.getPropertyChangeListeners property-name)))
  ([^KeyboardFocusManager this]
    (-> this (.getPropertyChangeListeners))))

(defn get-vetoable-change-listeners
  "Returns an array of all the VetoableChangeListeners
   associated with the named property.

  property-name - `java.lang.String`

  returns: all of the VetoableChangeListeners associated with
           the named property or an empty array if no such listeners have
           been added. - `java.beans.VetoableChangeListener[]`"
  ([^KeyboardFocusManager this ^java.lang.String property-name]
    (-> this (.getVetoableChangeListeners property-name)))
  ([^KeyboardFocusManager this]
    (-> this (.getVetoableChangeListeners))))

(defn add-key-event-post-processor
  "Adds a KeyEventPostProcessor to this KeyboardFocusManager's post-
   processor chain. After a KeyEvent has been dispatched to and handled by
   its target, KeyboardFocusManager will request that each
   KeyEventPostProcessor perform any necessary post-processing as part
   of the KeyEvent's final resolution. KeyEventPostProcessors
   will be notified in the order in which they were added; the current
   KeyboardFocusManager will be notified last. Notifications will halt
   as soon as one KeyEventPostProcessor returns true from its
   postProcessKeyEvent method. There is no limit to the the
   total number of KeyEventPostProcessors that can be added, nor to the
   number of times that a particular KeyEventPostProcessor instance can be
   added.

   If a null post-processor is specified, no action is taken and no
   exception is thrown.

   In a multithreaded application, KeyEventPostProcessor behaves
   the same as other AWT listeners.  See
   AWT Threading Issues for more details.

  processor - the KeyEventPostProcessor to add to the post-processor chain - `java.awt.KeyEventPostProcessor`"
  ([^KeyboardFocusManager this ^java.awt.KeyEventPostProcessor processor]
    (-> this (.addKeyEventPostProcessor processor))))

(defn post-process-key-event
  "This method will be called by dispatchKeyEvent.
   By default, this method will handle any unconsumed KeyEvents that
   map to an AWT MenuShortcut by consuming the event
   and activating the shortcut.

  e - the KeyEvent to post-process - `java.awt.event.KeyEvent`

  returns: true to indicate that no other
           KeyEventPostProcessor will be notified of the KeyEvent. - `boolean`"
  (^Boolean [^KeyboardFocusManager this ^java.awt.event.KeyEvent e]
    (-> this (.postProcessKeyEvent e))))

(defn process-key-event
  "This method initiates a focus traversal operation if and only if the
   KeyEvent represents a focus traversal key for the specified
   focusedComponent. It is expected that focusedComponent is the current
   focus owner, although this need not be the case. If it is not,
   focus traversal will nevertheless proceed as if focusedComponent
   were the current focus owner.

  focused-component - the Component that will be the basis for a focus traversal operation if the specified event represents a focus traversal key for the Component - `java.awt.Component`
  e - the event that may represent a focus traversal key - `java.awt.event.KeyEvent`"
  ([^KeyboardFocusManager this ^java.awt.Component focused-component ^java.awt.event.KeyEvent e]
    (-> this (.processKeyEvent focused-component e))))

(defn set-default-focus-traversal-policy
  "Sets the default FocusTraversalPolicy. Top-level components
   use this value on their creation to initialize their own focus traversal
   policy by explicit call to Container.setFocusTraversalPolicy.
   Note: this call doesn't affect already created components as they have
   their policy initialized. Only new components will use this policy as
   their default policy.

  default-policy - the new, default FocusTraversalPolicy - `java.awt.FocusTraversalPolicy`

  throws: java.lang.IllegalArgumentException - if defaultPolicy is null"
  ([^KeyboardFocusManager this ^java.awt.FocusTraversalPolicy default-policy]
    (-> this (.setDefaultFocusTraversalPolicy default-policy))))

(defn dispatch-event
  "This method is called by the AWT event dispatcher requesting that the
   current KeyboardFocusManager dispatch the specified event on its behalf.
   It is expected that all KeyboardFocusManagers will dispatch all
   FocusEvents, all WindowEvents related to focus, and all KeyEvents.
   These events should be dispatched based on the KeyboardFocusManager's
   notion of the focus owner and the focused and active Windows, sometimes
   overriding the source of the specified AWTEvent. Dispatching must be
   done using redispatchEvent to prevent the AWT event
   dispatcher from recursively requesting that the KeyboardFocusManager
   dispatch the event again. If this method returns false,
   then the AWT event dispatcher will attempt to dispatch the event itself.

  e - the AWTEvent to be dispatched - `java.awt.AWTEvent`

  returns: true if this method dispatched the event;
           false otherwise - `boolean`"
  (^Boolean [^KeyboardFocusManager this ^java.awt.AWTEvent e]
    (-> this (.dispatchEvent e))))

(defn set-default-focus-traversal-keys
  "Sets the default focus traversal keys for a given traversal operation.
   This traversal key Set will be in effect on all
   Windows that have no such Set of
   their own explicitly defined. This Set will also be
   inherited, recursively, by any child Component of
   those Windows that has
   no such Set of its own explicitly defined.

   The default values for the default focus traversal keys are
   implementation-dependent. Sun recommends that all implementations for a
   particular native platform use the same default values. The
   recommendations for Windows and Unix are listed below. These
   recommendations are used in the Sun AWT implementations.



      Identifier
      Meaning
      Default


      KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS
      Normal forward keyboard traversal
      TAB on KEY_PRESSED,
          CTRL-TAB on KEY_PRESSED


      KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS
      Normal reverse keyboard traversal
      SHIFT-TAB on KEY_PRESSED,
          CTRL-SHIFT-TAB on KEY_PRESSED


      KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS
      Go up one focus traversal cycle
      none


      KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS
      Go down one focus traversal cycle
      none



   To disable a traversal key, use an empty Set;
   Collections.EMPTY_SET is recommended.

   Using the AWTKeyStroke API, client code can
   specify on which of two
   specific KeyEvents, KEY_PRESSED or
   KEY_RELEASED, the focus traversal operation will
   occur. Regardless of which KeyEvent is specified,
   however, all KeyEvents related to the focus
   traversal key, including the associated KEY_TYPED
   event, will be consumed, and will not be dispatched
   to any Component. It is a runtime error to
   specify a KEY_TYPED event as
   mapping to a focus traversal operation, or to map the same event to
   multiple default focus traversal operations.

   This method may throw a ClassCastException if any Object
   in keystrokes is not an AWTKeyStroke.

  id - one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS - `int`
  keystrokes - the Set of AWTKeyStrokes for the specified operation - `java.util.Set`

  throws: java.lang.IllegalArgumentException - if id is not one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS, or if keystrokes is null, or if keystrokes contains null, or if any keystroke represents a KEY_TYPED event, or if any keystroke already maps to another default focus traversal operation"
  ([^KeyboardFocusManager this ^Integer id ^java.util.Set keystrokes]
    (-> this (.setDefaultFocusTraversalKeys id keystrokes))))

(defn remove-vetoable-change-listener
  "Removes a VetoableChangeListener from the listener list for a specific
   property. This method should be used to remove VetoableChangeListeners
   that were registered for a specific bound property.

   If listener is null, no exception is thrown and no action is performed.

  property-name - a valid property name - `java.lang.String`
  listener - the VetoableChangeListener to be removed - `java.beans.VetoableChangeListener`"
  ([^KeyboardFocusManager this ^java.lang.String property-name ^java.beans.VetoableChangeListener listener]
    (-> this (.removeVetoableChangeListener property-name listener)))
  ([^KeyboardFocusManager this ^java.beans.VetoableChangeListener listener]
    (-> this (.removeVetoableChangeListener listener))))

(defn redispatch-event
  "Redispatches an AWTEvent in such a way that the AWT event dispatcher
   will not recursively request that the KeyboardFocusManager, or any
   installed KeyEventDispatchers, dispatch the event again. Client
   implementations of dispatchEvent and client-defined
   KeyEventDispatchers must call redispatchEvent(target, e)
   instead of target.dispatchEvent(e) to dispatch an event.

   This method is intended to be used only by KeyboardFocusManagers and
   KeyEventDispatchers. It is not for general client use.

  target - the Component to which the event should be dispatched - `java.awt.Component`
  e - the event to dispatch - `java.awt.AWTEvent`"
  ([^KeyboardFocusManager this ^java.awt.Component target ^java.awt.AWTEvent e]
    (-> this (.redispatchEvent target e))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list for a specific
   property. The specified property may be user-defined, or one of the
   following:

      whether the KeyboardFocusManager is currently managing focus
          for this application or applet's browser context
          (`managingFocus`)
      the focus owner (`focusOwner`)
      the permanent focus owner (`permanentFocusOwner`)
      the focused Window (`focusedWindow`)
      the active Window (`activeWindow`)
      the default focus traversal policy
          (`defaultFocusTraversalPolicy`)
      the Set of default FORWARD_TRAVERSAL_KEYS
          (`forwardDefaultFocusTraversalKeys`)
      the Set of default BACKWARD_TRAVERSAL_KEYS
          (`backwardDefaultFocusTraversalKeys`)
      the Set of default UP_CYCLE_TRAVERSAL_KEYS
          (`upCycleDefaultFocusTraversalKeys`)
      the Set of default DOWN_CYCLE_TRAVERSAL_KEYS
          (`downCycleDefaultFocusTraversalKeys`)
      the current focus cycle root (`currentFocusCycleRoot`)

   If listener is null, no exception is thrown and no action is performed.

  property-name - one of the property names listed above - `java.lang.String`
  listener - the PropertyChangeListener to be added - `java.beans.PropertyChangeListener`"
  ([^KeyboardFocusManager this ^java.lang.String property-name ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener property-name listener)))
  ([^KeyboardFocusManager this ^java.beans.PropertyChangeListener listener]
    (-> this (.addPropertyChangeListener listener))))

(defn set-global-current-focus-cycle-root
  "Sets the current focus cycle root. If the focus owner is itself a focus
   cycle root, then it may be ambiguous as to which Components represent
   the next and previous Components to focus during normal focus traversal.
   In that case, the current focus cycle root is used to differentiate
   among the possibilities.

   If a SecurityManager is installed, the calling thread must be granted
   the `replaceKeyboardFocusManager` AWTPermission. If this permission is
   not granted, this method will throw a SecurityException, and the current
   focus cycle root will not be changed.

   This method is intended to be used only by KeyboardFocusManagers and
   focus implementations. It is not for general client use.

  new-focus-cycle-root - the new focus cycle root - `java.awt.Container`

  throws: java.lang.SecurityException - if the calling thread does not have `replaceKeyboardFocusManager` permission"
  ([^KeyboardFocusManager this ^java.awt.Container new-focus-cycle-root]
    (-> this (.setGlobalCurrentFocusCycleRoot new-focus-cycle-root))))

(defn focus-previous-component
  "Focuses the Component before aComponent, typically based on a
   FocusTraversalPolicy.

  a-component - the Component that is the basis for the focus traversal operation - `java.awt.Component`"
  ([^KeyboardFocusManager this ^java.awt.Component a-component]
    (-> this (.focusPreviousComponent a-component)))
  ([^KeyboardFocusManager this]
    (-> this (.focusPreviousComponent))))

(defn up-focus-cycle
  "Moves the focus up one focus traversal cycle. Typically, the focus owner
   is set to aComponent's focus cycle root, and the current focus cycle
   root is set to the new focus owner's focus cycle root. If, however,
   aComponent's focus cycle root is a Window, then typically the focus
   owner is set to the Window's default Component to focus, and the current
   focus cycle root is unchanged.

  a-component - the Component that is the basis for the focus traversal operation - `java.awt.Component`"
  ([^KeyboardFocusManager this ^java.awt.Component a-component]
    (-> this (.upFocusCycle a-component)))
  ([^KeyboardFocusManager this]
    (-> this (.upFocusCycle))))

(defn add-vetoable-change-listener
  "Adds a VetoableChangeListener to the listener list for a specific
   property. The specified property may be user-defined, or one of the
   following:

      the focus owner (`focusOwner`)
      the permanent focus owner (`permanentFocusOwner`)
      the focused Window (`focusedWindow`)
      the active Window (`activeWindow`)

   If listener is null, no exception is thrown and no action is performed.

  property-name - one of the property names listed above - `java.lang.String`
  listener - the VetoableChangeListener to be added - `java.beans.VetoableChangeListener`"
  ([^KeyboardFocusManager this ^java.lang.String property-name ^java.beans.VetoableChangeListener listener]
    (-> this (.addVetoableChangeListener property-name listener)))
  ([^KeyboardFocusManager this ^java.beans.VetoableChangeListener listener]
    (-> this (.addVetoableChangeListener listener))))

