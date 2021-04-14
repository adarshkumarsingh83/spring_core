package com.adarsh.spring.annotation;


import java.lang.annotation.*;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 13/6/13 11:12 AM
 * @see
 */
@Documented
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConstructorInjector {
    String data()default "data";
}
