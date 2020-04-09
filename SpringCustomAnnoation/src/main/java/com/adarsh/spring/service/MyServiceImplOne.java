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
import com.adarsh.spring.bean.MessageBean1;
import com.adarsh.spring.bean.MessageBean2;
import com.adarsh.spring.bean.MessageBean3;
import com.adarsh.spring.bean.MessageBean5;
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
@Service(value = "myServiceImplOne")
public class MyServiceImplOne implements MyService {

    private String msgText;

    public MyServiceImplOne() {
    }

    @ConstructorInjector(data = "MyServiceImplOne constructor")
    public MyServiceImplOne(String msgText) {
        this.msgText = msgText;
    }

    public String getMsgText() {
        return msgText;
    }

    public Map<Object, Object> beanObjects = new HashMap<>();
    public Map<Object, Object> getBeanObjects() {
        return beanObjects;
    }

    @Override
    @BeanList(beanList = {MessageBean1.class, MessageBean2.class, MessageBean5.class}, required = true)
    public void setBeanObjects(String key, Object bean) {
        this.beanObjects.put(key,bean);
        logger.info("setBeanObjects() "+beanObjects.toString());
    }

    public void setBeanObjects(Map<String, Object> beanObjects) {
    }

    @ClassLogger(className = MyServiceImplOne.class)
    private static Logger logger;
    public static void setLogger(Logger logger) {
        MyServiceImplOne.logger = logger;
    }
}
