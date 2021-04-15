package com.espark.adarsh.eventHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
@Component
public class ContextStoppedEventHandler {


    @EventListener
    public void onApplicationEvent(ContextStoppedEvent event) {
        log.info(":=> ContextStoppedEvent Received");
    }
}