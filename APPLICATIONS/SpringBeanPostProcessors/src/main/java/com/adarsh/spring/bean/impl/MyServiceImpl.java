package com.adarsh.spring.bean.impl;


import com.adarsh.spring.bean.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyServiceImpl implements MyService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyServiceImpl.class);

    public void init(){
        LOGGER.info(" :=> Bean is going through init.");
    }

    private String message;

    public void setMessage(String message){
        this.message  = message;
    }

    public String getMessage(){
        return message;
    }

    public void destroy(){
        LOGGER.info(" :=> Bean will destroy now.");
    }

}
