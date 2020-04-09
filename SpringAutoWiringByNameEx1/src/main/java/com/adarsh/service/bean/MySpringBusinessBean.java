package com.adarsh.service.bean;

public class MySpringBusinessBean {

   private MySpringTestBean mySpringTestBean;
  
    public MySpringBusinessBean(){
    	super();
    }
      
    public void setMySpringTestBean(MySpringTestBean mySpringTestBean){
    	this.mySpringTestBean = mySpringTestBean;
    }
    
    public void wishMsg(){
    	mySpringTestBean.displayMsg();
    }
}
