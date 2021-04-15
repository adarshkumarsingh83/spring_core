package com.adarsh.spring.eventHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class ContextStoppedEventHandler<ContextStoppedEvent> implements ApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info(":=> ContextStoppedEvent Received");
    }
}