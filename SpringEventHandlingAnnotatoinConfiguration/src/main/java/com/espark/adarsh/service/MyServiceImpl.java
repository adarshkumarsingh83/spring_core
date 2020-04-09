package com.espark.adarsh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Service("myService")
public class MyServiceImpl implements MyService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyServiceImpl.class);

    @Value(("${application.message}"))
    private String message;

    public void getMessage() {
        LOGGER.info(":=> Your Message : " + message);
    }
}
