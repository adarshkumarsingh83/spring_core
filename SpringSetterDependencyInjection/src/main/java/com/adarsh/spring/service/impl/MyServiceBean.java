package com.adarsh.spring.service.impl;

import com.adarsh.spring.service.SpringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
public class MyServiceBean implements SpringService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyServiceBean.class);

	private String name;
	private Date date;
	
	public MyServiceBean(){
		super();
	}
	
	public void setName(String name){
		 this.name=name;
	}
	
	public void setDate(Date date){
		this.date=date;
	}
	
	public void getWishMsg() {
        LOGGER.info(" :=-> "+this.name+" "+date);
	}
  
	public void getWishMsg(String name) {
        LOGGER.info(" :=-> "+name+" "+date);
	}

}
