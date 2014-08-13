package com.adarsh.spring.eventHandler;

import com.adarsh.spring.event.MyCustomEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.EventListener;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class CustomEventHandler <T extends EventListener> implements ApplicationListener {

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomEventHandler.class);

    public void onApplicationEvent(ApplicationEvent event) {
        LOGGER.info(event.toString());
    }
}
