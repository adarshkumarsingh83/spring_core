package com.adarsh.spring.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class MyMessageServiceImpl implements MyMessageService {

    private String message1;
    private String message2;
    private String message3;

    public void setMessage1(String message) {
        this.message1 = message;
    }

    public void setMessage2(String message) {
        this.message2 = message;
    }

    public void setMessage3(String message) {
        this.message3 = message;
    }

    public void getMessage1() {
        log.info("India Message1 : " + message1);
    }

    public void getMessage2() {
        log.info("India Message2 : " + message2);
    }

    public void getMessage3() {
        log.info("India Message3 : " + message3);
    }
}
