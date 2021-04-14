package com.adarsh.service;

import com.adarsh.service.bean.MySpringTestBean;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class SpringBusinessServiceImpl implements SpringBusinessService {

   private MySpringTestBean mySpringTestBean;
  
    public SpringBusinessServiceImpl(){
    	super();
    }
      
    public void setMySpringTestBean(MySpringTestBean mySpringTestBean){
    	this.mySpringTestBean = mySpringTestBean;
    }
    
    public void wishMsg(){
    	mySpringTestBean.displayMsg();
    }
}
