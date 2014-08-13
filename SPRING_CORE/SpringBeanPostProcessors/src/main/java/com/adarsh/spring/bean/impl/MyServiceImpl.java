package com.adarsh.spring.bean.impl;


import com.adarsh.spring.bean.MyService;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyServiceImpl implements MyService {

    public void init(){
        System.out.println("Bean is going through init.");
    }

    private String message;

    public void setMessage(String message){
        this.message  = message;
    }

    public String getMessage(){
        return message;
    }

    public void destroy(){
        System.out.println("Bean will destroy now.");
    }

}
