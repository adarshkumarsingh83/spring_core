package com.adarsh.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class LoggingBean implements BeanNameAware {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingBean.class);

    private String name;

    public void setBeanName(String name) {
        this.name = name;
    }

    public void run() {
        LOGGER.info("Bean name is'" + this.name + "'.");
    }
}
