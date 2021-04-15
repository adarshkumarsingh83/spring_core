package com.adarsh.spring.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class SpringDataBean {


	private String userName;
	
	 public SpringDataBean(){
         log.info(":=>  SpringTestBean class Constructor ");
	 }
   
	 public void setUserName(String userName){
	    	this.userName=userName;
	    }	    
	
	public void displayMsg(){
        log.info(":=> UserName is "+this.userName);
  }
}
