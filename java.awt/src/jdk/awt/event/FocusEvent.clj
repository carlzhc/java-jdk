(ns jdk.awt.event.FocusEvent
  "A low-level event which indicates that a Component has gained or lost the
  input focus. This low-level event is generated by a Component (such as a
  TextField). The event is passed to every FocusListener or
  FocusAdapter object which registered to receive such events
  using the Component's addFocusListener method. (
  FocusAdapter objects implement the FocusListener
  interface.) Each such listener object gets this FocusEvent when
  the event occurs.

  There are two levels of focus events: permanent and temporary. Permanent
  focus change events occur when focus is directly moved from one Component to
  another, such as through a call to requestFocus() or as the user uses the
  TAB key to traverse Components. Temporary focus change events occur when
  focus is temporarily lost for a Component as the indirect result of another
  operation, such as Window deactivation or a Scrollbar drag. In this case,
  the original focus state will automatically be restored once that operation
  is finished, or, for the case of Window deactivation, when the Window is
  reactivated. Both permanent and temporary focus events are delivered using
  the FOCUS_GAINED and FOCUS_LOST event ids; the level may be distinguished in
  the event using the isTemporary() method.

  An unspecified behavior will be caused if the id parameter
  of any particular FocusEvent instance is not
  in the range from FOCUS_FIRST to FOCUS_LAST."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.event FocusEvent]))

(defn ->focus-event
  "Constructor.

  Constructs a FocusEvent object with the
   specified temporary state and opposite Component.
   The opposite Component is the other
   Component involved in this focus change.
   For a FOCUS_GAINED event, this is the
   Component that lost focus. For a
   FOCUS_LOST event, this is the Component
   that gained focus. If this focus change occurs with a native
   application, with a Java application in a different VM,
   or with no other Component, then the opposite
   Component is null.
    This method throws an
   IllegalArgumentException if source
   is null.

  source - The Component that originated the event - `java.awt.Component`
  id - An integer indicating the type of event. For information on allowable values, see the class description for FocusEvent - `int`
  temporary - Equals true if the focus change is temporary; false otherwise - `boolean`
  opposite - The other Component involved in the focus change, or null - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if source equals null"
  (^FocusEvent [^java.awt.Component source ^Integer id ^Boolean temporary ^java.awt.Component opposite]
    (new FocusEvent source id temporary opposite))
  (^FocusEvent [^java.awt.Component source ^Integer id ^Boolean temporary]
    (new FocusEvent source id temporary))
  (^FocusEvent [^java.awt.Component source ^Integer id]
    (new FocusEvent source id)))

(def *-focus-first
  "Static Constant.

  The first number in the range of ids used for focus events.

  type: int"
  FocusEvent/FOCUS_FIRST)

(def *-focus-last
  "Static Constant.

  The last number in the range of ids used for focus events.

  type: int"
  FocusEvent/FOCUS_LAST)

(def *-focus-gained
  "Static Constant.

  This event indicates that the Component is now the focus owner.

  type: int"
  FocusEvent/FOCUS_GAINED)

(def *-focus-lost
  "Static Constant.

  This event indicates that the Component is no longer the focus owner.

  type: int"
  FocusEvent/FOCUS_LOST)

(defn temporary?
  "Identifies the focus change event as temporary or permanent.

  returns: true if the focus change is temporary;
           false otherwise - `boolean`"
  (^Boolean [^FocusEvent this]
    (-> this (.isTemporary))))

(defn get-opposite-component
  "Returns the other Component involved in this focus change. For a
   FOCUS_GAINED event, this is the Component that lost focus. For a
   FOCUS_LOST event, this is the Component that gained focus. If this
   focus change occurs with a native application, with a Java application
   in a different VM or context, or with no other Component, then null is
   returned.

  returns: the other Component involved in the focus change, or null - `java.awt.Component`"
  (^java.awt.Component [^FocusEvent this]
    (-> this (.getOppositeComponent))))

(defn param-string
  "Returns a parameter string identifying this event.
   This method is useful for event-logging and for debugging.

  returns: a string identifying the event and its attributes - `java.lang.String`"
  (^java.lang.String [^FocusEvent this]
    (-> this (.paramString))))

