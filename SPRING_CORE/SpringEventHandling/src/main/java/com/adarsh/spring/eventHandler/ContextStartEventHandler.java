package com.adarsh.spring.eventHandler;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.ApplicationListener;
/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ContextStartEventHandler <ContextStartedEvent> implements ApplicationListener{

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("ContextStartedEvent Received");
    }
}