package com.adarsh.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyServiceImpl implements MyService, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {

        MyServiceImpl.applicationContext = applicationContext;
        LOGGER.info(" :-> " + MyServiceImpl.applicationContext.getId());
        LOGGER.info(" :-> " + MyServiceImpl.applicationContext.getDisplayName());
        LOGGER.info(" :-> " + MyServiceImpl.applicationContext.getBean("myService"));
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
