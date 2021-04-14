package com.adarsh.spring.service.impl;

import com.adarsh.spring.service.MySpringInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MySpringBeanClass implements MySpringInterface,
		ApplicationContextAware, BeanNameAware {

    public static final Logger LOGGER = LoggerFactory.getLogger(MySpringBeanClass.class);
    
	private String userName;   
 	private String beanName;
	private ApplicationContext applicationContext;
	
	public MySpringBeanClass() {
		super();
	}
    
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public void getWishMsg() {
	   LOGGER.info(":=> hi "+userName);
	   LOGGER.info(":=> Bean Class Name "+this.beanName);
	   LOGGER.info(":=> ApplicationContext object " + this.applicationContext.getDisplayName());
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
	 this.applicationContext =applicationContext;
	}

	public void setBeanName(String beanName) {
	     this.beanName=beanName;
	}

}
