package com.adarsh.service;

public class MySpringBusinessBean {
   private SpringBusinessBean springBusinessBean;
  
    public MySpringBusinessBean(){
    	super();
    }
      
    public void setSpringBusinessBean(SpringBusinessBean springBusinessBean){
    	this.springBusinessBean = springBusinessBean;
    }
    
    public void wishMsg(){
    	springBusinessBean.displayMsg();
    }
}
