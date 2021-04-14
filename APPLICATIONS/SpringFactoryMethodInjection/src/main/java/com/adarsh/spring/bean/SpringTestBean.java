package com.adarsh.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class SpringTestBean {

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringTestBean.class);
    private static SpringTestBean springTestBean;
    private String userName;
    
    static{
    	springTestBean =new SpringTestBean();
    }
    
    private SpringTestBean(){
        LOGGER.info("Constructor of the IestBean ");
    }
    public void setUserName(String userName){
    	this.userName=userName;
    }
    
    public static SpringTestBean myFactory(){
    	return springTestBean;
    }
    
    public String getMsg(){
    	return this.userName;
    }
}
