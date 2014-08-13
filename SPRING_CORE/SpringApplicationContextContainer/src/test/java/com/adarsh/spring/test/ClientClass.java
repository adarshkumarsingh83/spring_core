package com.adarsh.spring.test;

import com.adarsh.spring.service.MySpringInterface;
import org.springframework.context.support.FileSystemXmlApplicationContext;
/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ClientClass {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext ctc=new FileSystemXmlApplicationContext("src\\main\\resources\\spring\\spring-cfg.xml");
		MySpringInterface object=(MySpringInterface)ctc.getBean("businessObject");
	    object.displayData();
	}

}
