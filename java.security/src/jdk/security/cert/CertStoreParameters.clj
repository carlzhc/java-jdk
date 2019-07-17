(ns jdk.security.cert.CertStoreParameters
  "A specification of CertStore parameters.

  The purpose of this interface is to group (and provide type safety for)
  all CertStore parameter specifications. All
  CertStore parameter specifications must implement this
  interface.

  Typically, a CertStoreParameters object is passed as a parameter
  to one of the CertStore.getInstance methods.
  The getInstance method returns a CertStore that
  is used for retrieving Certificates and CRLs. The
  CertStore that is returned is initialized with the specified
  parameters. The type of parameters needed may vary between different types
  of CertStores."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertStoreParameters]))

(defn clone
  "Makes a copy of this CertStoreParameters.

   The precise meaning of `copy` may depend on the class of
   the CertStoreParameters object. A typical implementation
   performs a `deep copy` of this object, but this is not an absolute
   requirement. Some implementations may perform a `shallow copy` of some
   or all of the fields of this object.

   Note that the CertStore.getInstance methods make a copy
   of the specified CertStoreParameters. A deep copy
   implementation of clone is safer and more robust, as it
   prevents the caller from corrupting a shared CertStore by
   subsequently modifying the contents of its initialization parameters.
   However, a shallow copy implementation of clone is more
   appropriate for applications that need to hold a reference to a
   parameter contained in the CertStoreParameters. For example,
   a shallow copy clone allows an application to release the resources of
   a particular CertStore initialization parameter immediately,
   rather than waiting for the garbage collection mechanism. This should
   be done with the utmost care, since the CertStore may still
   be in use by other threads.

   Each subclass should state the precise behavior of this method so
   that users and developers know what to expect.

  returns: a copy of this CertStoreParameters - `java.lang.Object`"
  ([^. this]
    (-> this (.clone))))

