package com.adarsh.spring.bean;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MySpringBean {
    private static MySpringBean mySpringBean;
    private String userName;
    
    static{
    	mySpringBean =new MySpringBean();
    }
    
    private MySpringBean(){
    	System.out.println("Constructor of the IestBean ");
    }
    public void setUserName(String userName){
    	this.userName=userName;
    }
    
    public static MySpringBean myFactory(){
    	return mySpringBean;
    }
    
    public String getMsg(){
    	return this.userName;
    }
}
