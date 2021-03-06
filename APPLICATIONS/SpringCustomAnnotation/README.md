# SpringCustomAnnotation

---


### To Build Code 
* mvn clean package 

```
@Target(ElementType.PACKAGE), package header
@Target(ElementType.TYPE), class header
@Target(ElementType.CONSTRUCTOR), constructor header
@Target(ElementType.METHOD), method header
@Target(ElementType.FIELD), for class fields only
@Target(ElementType.PARAMATER), for method parameters only
@Target(ElementType.LOCAL_VARIABLE), for local variables only


@Documented,for java doc
@Inherited ,check for the annotation in current class if not found then move to parent upto object class

@Retention(RetentionPolicy.RUNTIME)Indicates how long annotations with the annotated type are to be retained.



package java.lang.annotation;

public enum ElementType {
  TYPE,			// Class, interface, or enum (but not annotation)
  FIELD,		// Field (including enumerated values)
  METHOD,		// Method (does not include constructors)
  PARAMETER,		// Method parameter
  CONSTRUCTOR,		// Constructor
  LOCAL_VARIABLE,	// Local variable or catch clause
  ANNOTATION_TYPE,	// Annotation Types (meta-annotations)
  PACKAGE		// Java package
}
```
