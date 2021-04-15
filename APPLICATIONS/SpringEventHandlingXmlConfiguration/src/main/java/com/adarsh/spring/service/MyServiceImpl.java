package com.adarsh.spring.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class MyServiceImpl implements MyService {


    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        log.info(":=> Your Message : " + message);
    }
}
