package com.adarsh.service.bean;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MySpringTestBean {
	 
	private String userName;
    
	 public void setUserName(String userName){
	    	this.userName=userName;
	    }	    
	
	public void displayMsg(){
	    System.out.println("UserName is "+this.userName);
   }
}
