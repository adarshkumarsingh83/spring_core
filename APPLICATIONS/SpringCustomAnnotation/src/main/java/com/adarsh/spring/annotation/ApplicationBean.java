package com.adarsh.spring.annotation;


import java.lang.annotation.*;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 12/6/13 2:27 PM
 * @see
 */
@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationBean {
    String name()default "";
}
