package com.adarsh.service.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MySpringTestBean {

    public static final Logger LOGGER = LoggerFactory.getLogger(MySpringTestBean.class);
	 
	private String userName;
    
	 public void setUserName(String userName){
	    	this.userName=userName;
	    }	    
	
	public void displayMsg(){
        LOGGER.info("UserName is "+this.userName);
   }
}
