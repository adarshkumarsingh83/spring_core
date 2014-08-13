package com.adarsh.spring.main;


import com.adarsh.spring.bean.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    private static final Logger LOGGER= LoggerFactory.getLogger(ApplicationMain.class);
    
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:/spring/Spring-cfg.xml");

        MyService objA = (MyService) context.getBean("myServiceSingleTon");
        objA.getMessage();
        LOGGER.info("myServiceSingleTon " + objA.hashCode());

        MyService objB = (MyService) context.getBean("myServiceSingleTon");
        objB.getMessage();
        LOGGER.info("myServiceSingleTon " + objB.hashCode());

        objA = null;
        objA = (MyService) context.getBean("myServicePrototype");
        objA.getMessage();
        LOGGER.info("myServicePrototype " + objA.hashCode());

        objB = null;
        objB = (MyService) context.getBean("myServicePrototype");
        objB.getMessage();
        LOGGER.info("myServicePrototype " + objB.hashCode());

    }
}
