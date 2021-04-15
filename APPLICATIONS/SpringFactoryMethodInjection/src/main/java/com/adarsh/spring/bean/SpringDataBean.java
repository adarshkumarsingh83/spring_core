package com.adarsh.spring.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class SpringDataBean {

    private static SpringDataBean springTestBean;
    private String userName;
    
    static{
    	springTestBean =new SpringDataBean();
    }
    
    private SpringDataBean(){
        log.info("Constructor of the IestBean ");
    }
    public void setUserName(String userName){
    	this.userName=userName;
    }
    
    public static SpringDataBean myFactory(){
    	return springTestBean;
    }
    
    public String getMsg(){
    	return this.userName;
    }
}
