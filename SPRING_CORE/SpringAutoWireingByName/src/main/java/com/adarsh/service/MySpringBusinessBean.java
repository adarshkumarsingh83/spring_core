package com.adarsh.service;

public class MySpringBusinessBean {

   private SampleSpringBusinessBean sampleSpringBusinessBean;
  
    public MySpringBusinessBean(){
    	super();
    }

    public void setSampleSpringBusinessBean(SampleSpringBusinessBean sampleSpringBusinessBean) {
        this.sampleSpringBusinessBean = sampleSpringBusinessBean;
    }

    public void wishMsg(){
        sampleSpringBusinessBean.displayMsg();
    }
}
