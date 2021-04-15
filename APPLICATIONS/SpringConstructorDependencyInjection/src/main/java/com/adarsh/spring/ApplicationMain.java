package com.adarsh.spring;

import com.adarsh.spring.service.MyBusinessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    public static void main(String[] args) {

        /* XmlBeanFactory factory=new XmlBeanFactory(new FileSystemResource("applicationContext.xml"));*/
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        MyBusinessService businessObject = (MyBusinessService) context.getBean("businessObject");
        businessObject.displayData();

    }

}
