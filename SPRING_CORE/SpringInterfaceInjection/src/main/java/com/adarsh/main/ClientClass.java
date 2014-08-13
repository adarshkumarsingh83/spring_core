package com.adarsh.main;

import com.adarsh.service.MySpringInterface;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ClientClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileSystemXmlApplicationContext fileSystemXmlApplicationContext=new FileSystemXmlApplicationContext("src\\main\\resources\\spring\\spring-cfg.xml");
		MySpringInterface object=(MySpringInterface)fileSystemXmlApplicationContext.getBean("businessObject");
	    object.getWushMsg();
	    
	}

}
