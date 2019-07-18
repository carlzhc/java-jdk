(ns jdk.sql.Wrapper
  "Interface for JDBC classes which provide the ability to retrieve the delegate instance when the instance
  in question is in fact a proxy class.

  The wrapper pattern is employed by many JDBC driver implementations to provide extensions beyond
  the traditional JDBC API that are specific to a data source. Developers may wish to gain access to
  these resources that are wrapped (the delegates) as  proxy class instances representing the
  the actual resources. This interface describes a standard mechanism to access
  these wrapped resources
  represented by their proxy, to permit direct access to the resource delegates."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Wrapper]))

(defn unwrap
  "Returns an object that implements the given interface to allow access to
   non-standard methods, or standard methods not exposed by the proxy.

   If the receiver implements the interface then the result is the receiver
   or a proxy for the receiver. If the receiver is a wrapper
   and the wrapped object implements the interface then the result is the
   wrapped object or a proxy for the wrapped object. Otherwise return the
   the result of calling unwrap recursively on the wrapped object
   or a proxy for that result. If the receiver is not a
   wrapper and does not implement the interface, then an SQLException is thrown.

  iface - A Class defining an interface that the result must implement. - `java.lang.Class`

  returns: an object that implements the interface. May be a proxy for the actual implementing object. - `<T> T`

  throws: java.sql.SQLException - If no object found that implements the interface"
  ([^Wrapper this ^java.lang.Class iface]
    (-> this (.unwrap iface))))

(defn wrapper-for?
  "Returns true if this either implements the interface argument or is directly or indirectly a wrapper
   for an object that does. Returns false otherwise. If this implements the interface then return true,
   else if this is a wrapper then return the result of recursively calling isWrapperFor on the wrapped
   object. If this does not implement the interface and is not a wrapper, return false.
   This method should be implemented as a low-cost operation compared to unwrap so that
   callers can use this method to avoid expensive unwrap calls that may fail. If this method
   returns true then calling unwrap with the same argument should succeed.

  iface - a Class defining an interface. - `java.lang.Class`

  returns: true if this implements the interface or directly or indirectly wraps an object that does. - `boolean`

  throws: java.sql.SQLException - if an error occurs while determining whether this is a wrapper for an object with the given interface."
  (^Boolean [^Wrapper this ^java.lang.Class iface]
    (-> this (.isWrapperFor iface))))

