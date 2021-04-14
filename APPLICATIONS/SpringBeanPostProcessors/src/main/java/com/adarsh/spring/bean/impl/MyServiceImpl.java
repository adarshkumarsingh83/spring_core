package com.adarsh.spring.bean.impl;


import com.adarsh.spring.bean.MyService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class MyServiceImpl implements MyService {


    public void init(){
        log.info(" :=> Bean is going through init.");
    }

    private String message;

    public void setMessage(String message){
        this.message  = message;
    }

    public String getMessage(){
        return message;
    }

    public void destroy(){
        log.info(" :=> Bean will destroy now.");
    }

}
