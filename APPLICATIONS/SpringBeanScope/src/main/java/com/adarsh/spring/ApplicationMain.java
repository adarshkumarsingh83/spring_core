package com.adarsh.spring;


import com.adarsh.spring.bean.MyService;
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

        MyService objA = (MyService) context.getBean("myServiceSingleTon");
        objA.getMessage();
        System.out.println("myServiceSingleTon " + objA.hashCode());

        MyService objB = (MyService) context.getBean("myServiceSingleTon");
        objB.getMessage();
        System.out.println("myServiceSingleTon " + objB.hashCode());

        objA = null;
        objA = (MyService) context.getBean("myServicePrototype");
        objA.getMessage();
        System.out.println("myServicePrototype " + objA.hashCode());

        objB = null;
        objB = (MyService) context.getBean("myServicePrototype");
        objB.getMessage();
        System.out.println("myServicePrototype " + objB.hashCode());

    }
}
