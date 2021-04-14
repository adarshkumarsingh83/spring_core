package com.espark.adarsh.listener;

import com.espark.adarsh.event.MethodCallEvent;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Component
public class MethodCallEventListener {

    @EventListener
    public void onMethodCallEventEvent(MethodCallEvent<String> event) {
        log.info(":=> MethodCallEventListener "+event.getData());
    }
}