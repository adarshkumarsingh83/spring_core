/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.spring.service;
/**
 *@Product: MyService provides the specification for ..
 */


import com.adarsh.spring.annotation.BeanList;
import com.adarsh.spring.annotation.ClassLogger;
import com.adarsh.spring.annotation.ConstructorInjector;
import com.adarsh.spring.annotation.RequiredInjection;
import org.slf4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 12/6/13 1:02 PM
 * @see
 */

@RequiredInjection(required = true)
@Scope(value = "singleton")
@Service(value = "myServiceImplTwo")
public class MyServiceImplTwo implements MyService {

    private String msgText;

    public MyServiceImplTwo() {
    }

    @ConstructorInjector(data = "MyServiceImplTwo constructor")
    public MyServiceImplTwo(String msgText) {
        this.msgText = msgText;
    }

    public String getMsgText() {
        return msgText;
    }

    public Map<String, Object> beanObjects = new HashMap<>();

    public Map<Object, Object> getBeanObjects() {
        return (Map)beanObjects;
    }

    @Override
    @BeanList(required = true)
    public void setBeanObjects(Map<String, Object> beanObjects) {
        this.beanObjects = beanObjects;
        logger.info("setBeanObjects() "+beanObjects.toString());
    }

    @Override
    public void setBeanObjects(String key, Object bean) {
    }


    @ClassLogger(className = MyServiceImplTwo.class)
    private static Logger logger;

    public static void setLogger(Logger logger) {
        MyServiceImplTwo.logger = logger;
    }
}
