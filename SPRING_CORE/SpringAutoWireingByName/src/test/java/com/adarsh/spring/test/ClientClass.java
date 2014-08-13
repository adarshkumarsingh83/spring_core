package com.adarsh.spring.test;
import com.adarsh.service.SpringBusinessServiceImpl;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ClientClass {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext fileSystemXmlApplicationContext=new FileSystemXmlApplicationContext("src\\main\\resources\\spring\\spring-cfg.xml");
        SpringBusinessServiceImpl springBusinessService=(SpringBusinessServiceImpl)fileSystemXmlApplicationContext.getBean("businessObject");
        springBusinessService.wishMsg();
	}

}
