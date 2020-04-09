package com.adarsh.spring.initializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class BeanInitializer implements BeanPostProcessor {

    public static final Logger LOGGER = LoggerFactory.getLogger(BeanInitializer.class);

    public Object postProcessBeforeInitialization(Object bean,
                                                  String beanName) throws BeansException {
        LOGGER.info(" :=> BeforeInitialization : " + beanName);
        // you can return any other object as well
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean,
                                                 String beanName) throws BeansException {
        LOGGER.info(" :=> AfterInitialization : " + beanName);
        // you can return any other object as well
        return bean;
    }

}