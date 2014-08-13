package com.adarsh.spring.service.impl;

import com.adarsh.spring.service.construct.MyClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ServiceClass implements BeanNameAware {

    public static final Logger LOGGER = LoggerFactory.getLogger(ServiceClass.class);

    private MyClass myClass;
    private String beanName;

    public void setMyClass(MyClass myClass) {
        this.myClass = myClass;
    }

    public String method() {
        LOGGER.info("Bean Name is " + beanName);
         return myClass.getWish();
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

}
