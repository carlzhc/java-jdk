(ns javax.crypto.spec.DHParameterSpec
  "This class specifies the set of parameters used with the Diffie-Hellman
  algorithm, as specified in PKCS #3: Diffie-Hellman Key-Agreement
  Standard.

  A central authority generates parameters and gives them to the two
  entities seeking to generate a secret key. The parameters are a prime
  p, a base g, and optionally the length
  in bits of the private value, l.

  It is possible that more than one instance of parameters may be
  generated by a given central authority, and that there may be more than
  one central authority. Indeed, each individual may be its own central
  authority, with different entities having different parameters.

  Note that this class does not perform any validation on specified
  parameters. Thus, the specified values are returned directly even
  if they are null."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.spec DHParameterSpec]))

(defn ->dh-parameter-spec
  "Constructor.

  Constructs a parameter set for Diffie-Hellman, using a prime modulus
   p, a base generator g,
   and the size in bits, l, of the random exponent
   (private value).

  p - the prime modulus - `java.math.BigInteger`
  g - the base generator - `java.math.BigInteger`
  l - the size in bits of the random exponent (private value) - `int`"
  (^DHParameterSpec [^java.math.BigInteger p ^java.math.BigInteger g ^Integer l]
    (new DHParameterSpec p g l))
  (^DHParameterSpec [^java.math.BigInteger p ^java.math.BigInteger g]
    (new DHParameterSpec p g)))

(defn get-p
  "Returns the prime modulus p.

  returns: the prime modulus p - `java.math.BigInteger`"
  (^java.math.BigInteger [^DHParameterSpec this]
    (-> this (.getP))))

(defn get-g
  "Returns the base generator g.

  returns: the base generator g - `java.math.BigInteger`"
  (^java.math.BigInteger [^DHParameterSpec this]
    (-> this (.getG))))

(defn get-l
  "Returns the size in bits, l, of the random exponent
   (private value).

  returns: the size in bits, l, of the random exponent
   (private value), or 0 if this size has not been set - `int`"
  (^Integer [^DHParameterSpec this]
    (-> this (.getL))))

