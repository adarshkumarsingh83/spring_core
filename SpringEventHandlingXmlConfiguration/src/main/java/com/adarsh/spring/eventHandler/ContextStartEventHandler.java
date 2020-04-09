package com.adarsh.spring.eventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ContextStartEventHandler<ContextStartedEvent> implements ApplicationListener {

    public static final Logger LOGGER = LoggerFactory.getLogger(ContextStartEventHandler.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        LOGGER.info(":=> ContextStartedEvent Received");
    }
}