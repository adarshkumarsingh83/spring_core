package com.adarsh.spring;

import com.adarsh.spring.service.FruitBasket;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class ApplicationTest implements BeanFactoryAware{


    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
    }


    @Autowired(required = true)
    private ApplicationContext applicationContext;

    @Test
    public void testMyService(){
        this.loadFruitBasket();
        log.info(" :=> loading the injected bean");
        final DefaultListableBeanFactory defaultListableBeanFactory=(DefaultListableBeanFactory)beanFactory;
        final BeanDefinition beanDefinition = defaultListableBeanFactory.getBeanDefinition("fruitBasket");
        final PropertyValue propertyValue = beanDefinition.getPropertyValues().getPropertyValue("fruit");
        beanDefinition.getPropertyValues().removePropertyValue(propertyValue);
        beanDefinition.getPropertyValues().addPropertyValue("fruit",applicationContext.getBean("orange"));
        defaultListableBeanFactory.registerBeanDefinition("fruitBasket",beanDefinition);
        this.loadFruitBasket();
    }

    private void loadFruitBasket(){
        final FruitBasket fruitBasket = (FruitBasket)  applicationContext.getBean("fruitBasket");
        log.info(" :=> loading fruit basket : "+fruitBasket + " -- " + fruitBasket.getFruit().getName());
    }
}
