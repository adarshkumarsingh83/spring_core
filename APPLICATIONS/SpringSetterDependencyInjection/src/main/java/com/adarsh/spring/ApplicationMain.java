package com.adarsh.spring;

import com.adarsh.spring.service.impl.MyServiceBean;
import org.springframework.core.io.*;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;

public class ApplicationMain {

	
	public static void main(String[] args) {
     
     BeanFactory factory =new XmlBeanFactory(new FileSystemResource("src/main/resources/configuration/applicationContext.xml"));
     MyServiceBean serviceBeanObject=(MyServiceBean)factory.getBean("myServiceBean");
     serviceBeanObject.getWishMsg();
     serviceBeanObject.getWishMsg("ADARSH KUMAR SINGH");
	}

}
