(ns javax.print.attribute.standard.PageRanges
  "Class PageRanges is a printing attribute class, a set of integers, that
  identifies the range(s) of print-stream pages that the Printer object uses
  for each copy of each document which are to be printed. Nothing is printed
  for any pages identified that do not exist in the document(s). The attribute
  is associated with print-stream pages, not application-numbered pages
  (for example, the page numbers found in the headers and or footers for
  certain word processing applications).

  In most cases, the exact pages to be printed will be generated by a device
  driver and this attribute would not be required. However, when printing an
  archived document which has already been formatted, the end user may elect to
  print just a subset of the pages contained in the document. In this case, if
  a page range of `n-m` is specified, the first page
  to be printed will be page n. All subsequent pages of the document
  will be printed through and including page m.

  If a PageRanges attribute is not specified for a print job, all pages of
  the document will be printed. In other words, the default value for the
  PageRanges attribute is always {{1, Integer.MAX_VALUE}}.

  The effect of a PageRanges attribute on a multidoc print job (a job with
  multiple documents) depends on whether all the docs have the same page ranges
  specified or whether different docs have different page ranges specified, and
  on the (perhaps defaulted) value of the MultipleDocumentHandling attribute.


  If all the docs have the same page ranges specified, then any value of MultipleDocumentHandling makes sense, and the
  printer's processing depends on the MultipleDocumentHandling value:


  SINGLE_DOCUMENT -- All the input docs will be combined together into one
  output document. The specified page ranges of that output document will be
  printed.


  SINGLE_DOCUMENT_NEW_SHEET -- All the input docs will be combined together
  into one output document, and the first impression of each input doc will
  always start on a new media sheet. The specified page ranges of that output
  document will be printed.


  SEPARATE_DOCUMENTS_UNCOLLATED_COPIES -- For each separate input doc, the
  specified page ranges will be printed.


  SEPARATE_DOCUMENTS_COLLATED_COPIES -- For each separate input doc, the
  specified page ranges will be printed.



  SEPARATE_DOCUMENTS_UNCOLLATED_COPIES -- For each separate input doc, its own
  specified page ranges will be printed..


  SEPARATE_DOCUMENTS_COLLATED_COPIES -- For each separate input doc, its own
  specified page ranges will be printed..



  IPP Compatibility: The PageRanges attribute's canonical array form
  gives the lower and upper bound for each range of pages to be included in
  and IPP `page-ranges` attribute. See class SetOfIntegerSyntax for an
  explanation of canonical array form. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PageRanges]))

(defn ->page-ranges
  "Constructor.

  Construct a new page ranges attribute containing a single range of
   integers. That is, only those pages in the one range are to be printed.

  lower-bound - Lower bound of the range. - `int`
  upper-bound - Upper bound of the range. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if a null range is specified or if a non-null range is specified with lowerBound less than 1."
  (^PageRanges [^Integer lower-bound ^Integer upper-bound]
    (new PageRanges lower-bound upper-bound))
  (^PageRanges [members]
    (new PageRanges members)))

(defn equals
  "Returns whether this page ranges attribute is equivalent to the passed
   in object. To be equivalent, all of the following conditions must be
   true:


   object is not null.

   object is an instance of class PageRanges.

   This page ranges attribute's members and object's members
   are the same.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this page ranges
            attribute, false otherwise. - `boolean`"
  (^Boolean [^PageRanges this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PageRanges, the category is class PageRanges itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^PageRanges this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PageRanges, the category name is `page-ranges`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^PageRanges this]
    (-> this (.getName))))

