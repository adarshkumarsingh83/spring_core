package com.adarsh.spring.bean;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyBean {

	private String userName;
	
	 public MyBean(){
		 System.out.println("MyBean class Constructor ");
	 }
   
	 public void setUserName(String userName){
	    	this.userName=userName;
	    }	    
	
	public void displayMsg(){
	    System.out.println("UserName is "+this.userName);
  }
}
