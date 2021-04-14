package com.adarsh.spring;

import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class SpringDynamicBeanReference {

	private static final ClassPathXmlApplicationContext context = 
		new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");

	public static void main(String[] args) {
		
		loadFruitBasket();
		System.out.println("loading the injected bean");
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
		BeanDefinition bd = beanFactory.getBeanDefinition("fruitBasket");
		
		PropertyValue pv = bd.getPropertyValues().getPropertyValue("fruit");
        bd.getPropertyValues().removePropertyValue(pv);
        bd.getPropertyValues().addPropertyValue("fruit",context.getBean("orange"));
		beanFactory.registerBeanDefinition("fruitBasket",bd);
		loadFruitBasket();

	}
	
	private static void loadFruitBasket(){
		FruitBasket fruitBasket = (FruitBasket)  context.getBean("fruitBasket");
		System.out.println("loading fruit basket : "+fruitBasket + " -- " + fruitBasket.getFruit().getName());
	}
	
}
