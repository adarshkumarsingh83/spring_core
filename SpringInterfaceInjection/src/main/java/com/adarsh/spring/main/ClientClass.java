package com.adarsh.spring.main;

import com.adarsh.spring.service.MySpringInterface;
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
		FileSystemXmlApplicationContext fileSystemXmlApplicationContext=new FileSystemXmlApplicationContext("src\\main\\resources\\spring\\applicationContext.xml");
		MySpringInterface object=(MySpringInterface)fileSystemXmlApplicationContext.getBean("businessObject");
	    object.getWishMsg();
	    
	}

}
