package com.adarsh.spring.eventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ContextStoppedEventHandler<ContextStoppedEvent> implements ApplicationListener {

    public static final Logger LOGGER = LoggerFactory.getLogger(ContextStoppedEventHandler.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        LOGGER.info(":=> ContextStoppedEvent Received");
    }
}