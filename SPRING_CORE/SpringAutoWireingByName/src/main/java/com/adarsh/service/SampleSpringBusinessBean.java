package com.adarsh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class SampleSpringBusinessBean {

    public static final Logger LOGGER = LoggerFactory.getLogger(SampleSpringBusinessBean.class);
	 
	private String userName;
    
	 public void setUserName(String userName){
	    	this.userName=userName;
	    }	    
	
	public void displayMsg(){
        LOGGER.info("UserName is "+this.userName);
   }
}
