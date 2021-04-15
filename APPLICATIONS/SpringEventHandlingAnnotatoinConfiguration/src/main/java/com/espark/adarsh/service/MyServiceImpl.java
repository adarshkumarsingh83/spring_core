package com.espark.adarsh.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
@Service("myService")
public class MyServiceImpl implements MyService {


    @Value(("${application.message}"))
    private String message;

    public void getMessage() {
        log.info(":=> Your Message : " + message);
    }
}
