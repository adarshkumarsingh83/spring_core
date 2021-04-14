package com.adarsh.spring.initializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class BeanInitializer implements BeanPostProcessor {


    public Object postProcessBeforeInitialization(Object bean,
                                                  String beanName) throws BeansException {
        log.info(" :=> BeforeInitialization : " + beanName);
        // you can return any other object as well
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean,
                                                 String beanName) throws BeansException {
        log.info(" :=> AfterInitialization : " + beanName);
        // you can return any other object as well
        return bean;
    }

}