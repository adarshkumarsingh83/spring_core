package com.adarsh.main;

import com.adarsh.service.impl.MyServiceBean;
import org.springframework.core.io.*;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;

public class ServiceClient {

	
	public static void main(String[] args) {
     
     BeanFactory factory =new XmlBeanFactory(new FileSystemResource("src\\main\\resources\\Spring-cfg.xml"));
     MyServiceBean serviceBeanObject=(MyServiceBean)factory.getBean("ClientClass");
     serviceBeanObject.getWishMsg();
     serviceBeanObject.getWishMsg("ADARSH KUMAR SINGH");
	}

}
