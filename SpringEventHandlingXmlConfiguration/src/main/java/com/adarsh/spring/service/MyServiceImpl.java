package com.adarsh.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyServiceImpl implements MyService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyServiceImpl.class);

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        LOGGER.info(":=> Your Message : " + message);
    }
}
