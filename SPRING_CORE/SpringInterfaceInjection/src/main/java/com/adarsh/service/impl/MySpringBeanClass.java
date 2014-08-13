package com.adarsh.service.impl;
import static java.lang.System.out;

import com.adarsh.service.MySpringInterface;
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
    
    private static final Logger LOGGER= LoggerFactory.getLogger(MySpringBeanClass.class);
    
	private String userName;   
 	private String beanName;
	private ApplicationContext applicaionContext;
	
	public MySpringBeanClass() {
		super();
	}
    
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public void getWushMsg() {
	   LOGGER.info("hi "+userName);	
	   LOGGER.info("Bean Clas Name "+this.beanName);
	   LOGGER.info("ApplicationContext object "+this.applicaionContext.getDisplayName());
	}

	public void setApplicationContext(ApplicationContext applicaionContext)
			throws BeansException {
	 this.applicaionContext=applicaionContext;
	}

	public void setBeanName(String beanName) {
	     this.beanName=beanName;
	}

}
