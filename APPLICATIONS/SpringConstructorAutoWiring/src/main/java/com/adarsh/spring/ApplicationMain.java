package com.adarsh.spring;

import com.adarsh.spring.service.BusinessServiceImpl;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {
	public static void main(String[] args) {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring/applicationContext.xml");
		BusinessServiceImpl obj=(BusinessServiceImpl)ctx.getBean("businessObject");
        obj.wishMsg();
	}
}
