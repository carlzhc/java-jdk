(ns jdk.awt.MenuItem
  "All items in a menu must belong to the class
  MenuItem, or one of its subclasses.

  The default MenuItem object embodies
  a simple labeled menu item.

  This picture of a menu bar shows five menu items:


  The first two items are simple menu items, labeled
  `Basic` and `Simple`.
  Following these two items is a separator, which is itself
  a menu item, created with the label `-`.
  Next is an instance of CheckboxMenuItem
  labeled `Check`. The final menu item is a
  submenu labeled `More Examples`,
  and this submenu is an instance of Menu.

  When a menu item is selected, AWT sends an action event to
  the menu item. Since the event is an
  instance of ActionEvent, the processEvent
  method examines the event and passes it along to
  processActionEvent. The latter method redirects the
  event to any ActionListener objects that have
  registered an interest in action events generated by this
  menu item.

  Note that the subclass Menu overrides this behavior and
  does not send any event to the frame until one of its subitems is
  selected."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt MenuItem]))

(defn ->menu-item
  "Constructor.

  Create a menu item with an associated keyboard shortcut.
   Note that use of `-` in a label is reserved to indicate
   a separator between menu items. By default, all menu
   items except for separators are enabled.

  label - the label for this menu item. - `java.lang.String`
  s - the instance of MenuShortcut associated with this menu item. - `java.awt.MenuShortcut`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true."
  (^MenuItem [^java.lang.String label ^java.awt.MenuShortcut s]
    (new MenuItem label s))
  (^MenuItem [^java.lang.String label]
    (new MenuItem label))
  (^MenuItem []
    (new MenuItem )))

(defn delete-shortcut
  "Delete any MenuShortcut object associated
   with this menu item."
  ([^MenuItem this]
    (-> this (.deleteShortcut))))

(defn enable
  "Deprecated. As of JDK version 1.1,
   replaced by setEnabled(boolean).

  b - `boolean`"
  ([^MenuItem this ^Boolean b]
    (-> this (.enable b)))
  ([^MenuItem this]
    (-> this (.enable))))

(defn add-action-listener
  "Adds the specified action listener to receive action events
   from this menu item.
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the action listener. - `java.awt.event.ActionListener`"
  ([^MenuItem this ^java.awt.event.ActionListener l]
    (-> this (.addActionListener l))))

(defn add-notify
  "Creates the menu item's peer.  The peer allows us to modify the
   appearance of the menu item without changing its functionality."
  ([^MenuItem this]
    (-> this (.addNotify))))

(defn disable
  "Deprecated. As of JDK version 1.1,
   replaced by setEnabled(boolean)."
  ([^MenuItem this]
    (-> this (.disable))))

(defn get-action-listeners
  "Returns an array of all the action listeners
   registered on this menu item.

  returns: all of this menu item's ActionListeners
           or an empty array if no action
           listeners are currently registered - `java.awt.event.ActionListener[]`"
  ([^MenuItem this]
    (-> this (.getActionListeners))))

(defn get-label
  "Gets the label for this menu item.

  returns: the label of this menu item, or null
                         if this menu item has no label. - `java.lang.String`"
  (^java.lang.String [^MenuItem this]
    (-> this (.getLabel))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this MenuItem.
   For menu items, the AccessibleContext takes the form of an
   AccessibleAWTMenuItem.
   A new AccessibleAWTMenuItem instance is created if necessary.

  returns: an AccessibleAWTMenuItem that serves as the
           AccessibleContext of this MenuItem - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^MenuItem this]
    (-> this (.getAccessibleContext))))

(defn param-string
  "Returns a string representing the state of this MenuItem.
   This method is intended to be used only for debugging purposes, and the
   content and format of the returned string may vary between
   implementations. The returned string may be empty but may not be
   null.

  returns: the parameter string of this menu item - `java.lang.String`"
  (^java.lang.String [^MenuItem this]
    (-> this (.paramString))))

(defn set-enabled
  "Sets whether or not this menu item can be chosen.

  b - if true, enables this menu item; if false, disables it. - `boolean`"
  ([^MenuItem this ^Boolean b]
    (-> this (.setEnabled b))))

(defn remove-action-listener
  "Removes the specified action listener so it no longer receives
   action events from this menu item.
   If l is null, no exception is thrown and no action is performed.
   Refer to AWT Threading Issues for details on AWT's threading model.

  l - the action listener. - `java.awt.event.ActionListener`"
  ([^MenuItem this ^java.awt.event.ActionListener l]
    (-> this (.removeActionListener l))))

(defn set-shortcut
  "Set the MenuShortcut object associated with this
   menu item. If a menu shortcut is already associated with
   this menu item, it is replaced.

  s - the menu shortcut to associate with this menu item. - `java.awt.MenuShortcut`"
  ([^MenuItem this ^java.awt.MenuShortcut s]
    (-> this (.setShortcut s))))

(defn get-listeners
  "Returns an array of all the objects currently registered
   as FooListeners
   upon this MenuItem.
   FooListeners are registered using the
   addFooListener method.


   You can specify the listenerType argument
   with a class literal, such as
   FooListener.class.
   For example, you can query a
   MenuItem m
   for its action listeners with the following code:



  ActionListener[] als = (ActionListener[])(m.getListeners(ActionListener.class));

   If no such listeners exist, this method returns an empty array.

  listener-type - the type of listeners requested; this parameter should specify an interface that descends from java.util.EventListener - `java.lang.Class`

  returns: an array of all objects registered as
            FooListeners on this menu item,
            or an empty array if no such
            listeners have been added - `<T extends java.util.EventListener> T[]`

  throws: java.lang.ClassCastException - if listenerType doesn't specify a class or interface that implements java.util.EventListener"
  ([^MenuItem this ^java.lang.Class listener-type]
    (-> this (.getListeners listener-type))))

(defn get-action-command
  "Gets the command name of the action event that is fired
   by this menu item.

  returns: `java.lang.String`"
  (^java.lang.String [^MenuItem this]
    (-> this (.getActionCommand))))

(defn set-action-command
  "Sets the command name of the action event that is fired
   by this menu item.

   By default, the action command is set to the label of
   the menu item.

  command - the action command to be set for this menu item. - `java.lang.String`"
  ([^MenuItem this ^java.lang.String command]
    (-> this (.setActionCommand command))))

(defn enabled?
  "Checks whether this menu item is enabled.

  returns: `boolean`"
  (^Boolean [^MenuItem this]
    (-> this (.isEnabled))))

(defn set-label
  "Sets the label for this menu item to the specified label.

  label - the new label, or null for no label. - `java.lang.String`"
  ([^MenuItem this ^java.lang.String label]
    (-> this (.setLabel label))))

(defn get-shortcut
  "Get the MenuShortcut object associated with this
   menu item,

  returns: the menu shortcut associated with this menu item,
                     or null if none has been specified. - `java.awt.MenuShortcut`"
  (^java.awt.MenuShortcut [^MenuItem this]
    (-> this (.getShortcut))))

