package com.espark.adarsh.service;

import com.espark.adarsh.event.MethodCallEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
@Service("myService")
public class MyServiceImpl implements MyService {


    @Autowired
    private ApplicationEventPublisher publisher;

    @Value(("${application.message}"))
    private String message;

    public void getMessage() {
        log.info(":=> Your Message : " + message);
        this.publisher.publishEvent(new MethodCallEvent<String>(this, "MyService getMessage() invoked "));
    }
}
