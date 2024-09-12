(ns jdk.util.zip.ZipOutputStream
  "This class implements an output stream filter for writing files in the
  ZIP file format. Includes support for both compressed and uncompressed
  entries."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip ZipOutputStream]))

(defn ->zip-output-stream
  "Constructor.

  Creates a new ZIP output stream.

  out - the actual output stream - `java.io.OutputStream`
  charset - the java.nio.charset.charset to be used to encode the entry names and comments - `java.nio.charset.Charset`"
  (^ZipOutputStream [^java.io.OutputStream out ^java.nio.charset.Charset charset]
    (new ZipOutputStream out charset))
  (^ZipOutputStream [^java.io.OutputStream out]
    (new ZipOutputStream out)))

(def *-stored
  "Static Constant.

  Compression method for uncompressed (STORED) entries.

  type: int"
  ZipOutputStream/STORED)

(defn set-comment
  "Sets the ZIP file comment.

  comment - the comment string - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the length of the specified ZIP file comment is greater than 0xFFFF bytes"
  ([^ZipOutputStream this ^java.lang.String comment]
    (-> this (.setComment comment))))

(defn set-method
  "Sets the default compression method for subsequent entries. This
   default will be used whenever the compression method is not specified
   for an individual ZIP file entry, and is initially set to DEFLATED.

  method - the default compression method - `int`

  throws: java.lang.IllegalArgumentException - if the specified compression method is invalid"
  ([^ZipOutputStream this ^Integer method]
    (-> this (.setMethod method))))

(defn set-level
  "Sets the compression level for subsequent entries which are DEFLATED.
   The default setting is DEFAULT_COMPRESSION.

  level - the compression level (0-9) - `int`

  throws: java.lang.IllegalArgumentException - if the compression level is invalid"
  ([^ZipOutputStream this ^Integer level]
    (-> this (.setLevel level))))

(defn put-next-entry
  "Begins writing a new ZIP file entry and positions the stream to the
   start of the entry data. Closes the current entry if still active.
   The default compression method will be used if no compression method
   was specified for the entry, and the current time will be used if
   the entry has no set modification time.

  e - the ZIP entry to be written - `java.util.zip.ZipEntry`

  throws: java.util.zip.ZipException - if a ZIP format error has occurred"
  ([^ZipOutputStream this ^java.util.zip.ZipEntry e]
    (-> this (.putNextEntry e))))

(defn close-entry
  "Closes the current ZIP entry and positions the stream for writing
   the next entry.

  throws: java.util.zip.ZipException - if a ZIP format error has occurred"
  ([^ZipOutputStream this]
    (-> this (.closeEntry))))

(defn write
  "Writes an array of bytes to the current ZIP entry data. This method
   will block until all the bytes are written.

  b - the data to be written - `byte[]`
  off - the start offset in the data - `int`
  len - the number of bytes that are written - `int`

  throws: java.util.zip.ZipException - if a ZIP file error has occurred"
  ([^ZipOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len))))

(defn finish
  "Finishes writing the contents of the ZIP output stream without closing
   the underlying stream. Use this method when applying multiple filters
   in succession to the same output stream.

  throws: java.util.zip.ZipException - if a ZIP file error has occurred"
  ([^ZipOutputStream this]
    (-> this (.finish))))

(defn close
  "Closes the ZIP output stream as well as the stream being filtered.

  throws: java.util.zip.ZipException - if a ZIP file error has occurred"
  ([^ZipOutputStream this]
    (-> this (.close))))

