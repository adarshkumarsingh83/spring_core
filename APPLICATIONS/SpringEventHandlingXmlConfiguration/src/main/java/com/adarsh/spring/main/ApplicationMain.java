package com.adarsh.spring.main;

import com.adarsh.spring.service.MyService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        context.start();

        MyService obj = (MyService) context.getBean("myService");
        obj.getMessage();

        context.refresh();

        // Let us raise a stop event.
        context.stop();
    }
}
