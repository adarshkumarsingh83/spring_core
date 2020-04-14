package com.adarsh.spring.annotation;


import java.lang.annotation.*;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 13/6/13 8:48 AM
 * @see
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassLogger {
    Class className()default Object.class;
}
