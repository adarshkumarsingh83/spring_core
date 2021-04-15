package com.espark.adarsh.eventHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
@Component
public class ContextRefreshedHandler {


    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info(":=> ContextRefreshedEvent Received");
    }
}