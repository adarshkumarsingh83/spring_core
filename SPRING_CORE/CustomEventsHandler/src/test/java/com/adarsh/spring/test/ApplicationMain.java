package com.adarsh.spring.test;

import com.adarsh.spring.event.CustomEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    public static void main(String[] args) {

        final ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:/spring/Spring-cfg.xml");

        final CustomEventPublisher eventPublisher = (CustomEventPublisher) context.getBean("eventPublisher");
        eventPublisher.publish();

        context.stop();
    }
}
