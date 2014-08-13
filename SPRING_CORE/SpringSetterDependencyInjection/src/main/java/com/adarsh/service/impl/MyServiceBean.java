package com.adarsh.service.impl;

import com.adarsh.service.SpringService;

import java.util.Date;

public class MyServiceBean implements SpringService {

    private String name;
    private Date date;

    public MyServiceBean() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void getWishMsg() {
        SpringService.console.println(this.name + " " + date);
    }

    public void getWishMsg(String name) {
        SpringService.console.println(name + " " + date);
    }

}
