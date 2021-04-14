package com.adarsh.spring.main;


import com.adarsh.spring.service.MyBusinessService;
import org.springframework.core.io.*;
import org.springframework.beans.factory.xml.*;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ClientClass {

	
	public static void main(String[] args) {
        XmlBeanFactory factory=new XmlBeanFactory(new FileSystemResource("src\\main\\resources\\spring\\applicationContext.xml"));
        MyBusinessService object=(MyBusinessService)factory.getBean("businessObject");
        object.displayData();
	}

}
