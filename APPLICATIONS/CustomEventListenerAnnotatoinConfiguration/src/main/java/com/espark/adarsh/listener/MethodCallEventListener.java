package com.espark.adarsh.listener;

import com.espark.adarsh.event.MethodCallEvent;
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
public class MethodCallEventListener {

    public static final Logger LOGGER = LoggerFactory.getLogger(MethodCallEventListener.class);

    @EventListener
    public void onMethodCallEventEvent(MethodCallEvent<String> event) {
        LOGGER.info(":=> MethodCallEventListener "+event.getData());
    }
}