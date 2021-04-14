package com.adarsh.spring.main;

import com.adarsh.spring.service.MyService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        MyService obj = (MyService) context.getBean("myService");
        System.out.println(obj.getMsg());
        context.registerShutdownHook();
    }
}
