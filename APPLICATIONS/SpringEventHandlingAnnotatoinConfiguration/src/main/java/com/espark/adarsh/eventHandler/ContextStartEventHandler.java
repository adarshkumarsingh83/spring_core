package com.espark.adarsh.eventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Component
public class ContextStartEventHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(ContextStartEventHandler.class);

    @EventListener
    public void onApplicationEvent(ContextStartedEvent event) {
        LOGGER.info(":=> ContextStartedEvent Received");
    }
}