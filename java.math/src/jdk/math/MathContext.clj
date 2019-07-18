(ns jdk.math.MathContext
  "Immutable objects which encapsulate the context settings which
  describe certain rules for numerical operators, such as those
  implemented by the BigDecimal class.

  The base-independent settings are:

  precision:
  the number of digits to be used for an operation; results are
  rounded to this precision

  roundingMode:
  a RoundingMode object which specifies the algorithm to be
  used for rounding."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.math MathContext]))

(defn ->math-context
  "Constructor.

  Constructs a new MathContext with a specified
   precision and rounding mode.

  set-precision - The non-negative int precision setting. - `int`
  set-rounding-mode - The rounding mode to use. - `java.math.RoundingMode`

  throws: java.lang.IllegalArgumentException - if the setPrecision parameter is less than zero."
  (^MathContext [^Integer set-precision ^java.math.RoundingMode set-rounding-mode]
    (new MathContext set-precision set-rounding-mode))
  (^MathContext [^Integer set-precision]
    (new MathContext set-precision)))

(def *-unlimited
  "Static Constant.

  A MathContext object whose settings have the values
    required for unlimited precision arithmetic.
    The values of the settings are:

    precision=0 roundingMode=HALF_UP

  type: java.math.MathContext"
  MathContext/UNLIMITED)

(def *-decimal-32
  "Static Constant.

  A MathContext object with a precision setting
    matching the IEEE 754R Decimal32 format, 7 digits, and a
    rounding mode of HALF_EVEN, the
    IEEE 754R default.

  type: java.math.MathContext"
  MathContext/DECIMAL32)

(def *-decimal-64
  "Static Constant.

  A MathContext object with a precision setting
    matching the IEEE 754R Decimal64 format, 16 digits, and a
    rounding mode of HALF_EVEN, the
    IEEE 754R default.

  type: java.math.MathContext"
  MathContext/DECIMAL64)

(def *-decimal-128
  "Static Constant.

  A MathContext object with a precision setting
    matching the IEEE 754R Decimal128 format, 34 digits, and a
    rounding mode of HALF_EVEN, the
    IEEE 754R default.

  type: java.math.MathContext"
  MathContext/DECIMAL128)

(defn get-precision
  "Returns the precision setting.
   This value is always non-negative.

  returns: an int which is the value of the precision
           setting - `int`"
  (^Integer [^MathContext this]
    (-> this (.getPrecision))))

(defn get-rounding-mode
  "Returns the roundingMode setting.
   This will be one of
   RoundingMode.CEILING,
   RoundingMode.DOWN,
   RoundingMode.FLOOR,
   RoundingMode.HALF_DOWN,
   RoundingMode.HALF_EVEN,
   RoundingMode.HALF_UP,
   RoundingMode.UNNECESSARY, or
   RoundingMode.UP.

  returns: a RoundingMode object which is the value of the
           roundingMode setting - `java.math.RoundingMode`"
  (^java.math.RoundingMode [^MathContext this]
    (-> this (.getRoundingMode))))

(defn equals
  "Compares this MathContext with the specified
   Object for equality.

  x - Object to which this MathContext is to be compared. - `java.lang.Object`

  returns: true if and only if the specified Object is
           a MathContext object which has exactly the same
           settings as this object - `boolean`"
  (^Boolean [^MathContext this ^java.lang.Object x]
    (-> this (.equals x))))

(defn hash-code
  "Returns the hash code for this MathContext.

  returns: hash code for this MathContext - `int`"
  (^Integer [^MathContext this]
    (-> this (.hashCode))))

(defn to-string
  "Returns the string representation of this MathContext.
   The String returned represents the settings of the
   MathContext object as two space-delimited words
   (separated by a single space character, '\u0020',
   and with no leading or trailing white space), as follows:


   The string `precision=`, immediately followed
   by the value of the precision setting as a numeric string as if
   generated by the Integer.toString
   method.


   The string `roundingMode=`, immediately
   followed by the value of the roundingMode setting as a
   word.  This word will be the same as the name of the
   corresponding public constant in the RoundingMode
   enum.


   For example:


   precision=9 roundingMode=HALF_UP

   Additional words may be appended to the result of
   toString in the future if more properties are added to
   this class.

  returns: a String representing the context settings - `java.lang.String`"
  (^java.lang.String [^MathContext this]
    (-> this (.toString))))

