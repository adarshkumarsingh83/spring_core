package com.espark.adarsh.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Component
public class ContextRefreshedHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(ContextRefreshedHandler.class);

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.info(":=> ContextRefreshedEvent Received");
    }
}