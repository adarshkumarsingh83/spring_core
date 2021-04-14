package com.adarsh.spring;

import com.adarsh.spring.bean.Message;
import com.adarsh.spring.service.MyMessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");

        Message objA = (Message) context.getBean("message");

        objA.getMessage1();
        objA.getMessage2();

        MyMessageService objB = (MyMessageService) context.getBean("myMessage");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();

    }
}
