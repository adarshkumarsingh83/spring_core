package com.adarsh.spring.service.impl;

import com.adarsh.spring.service.SpringService;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class MyServiceBean implements SpringService {

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
        log.info(" :=-> "+this.name+" "+date);
	}
  
	public void getWishMsg(String name) {
        log.info(" :=-> "+name+" "+date);
	}

}
