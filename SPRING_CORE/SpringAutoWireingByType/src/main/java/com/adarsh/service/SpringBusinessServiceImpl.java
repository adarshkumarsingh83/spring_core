package com.adarsh.service;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class SpringBusinessServiceImpl implements SpringBusinessService {

   private SpringBusinessBean springBusinessBean;
  
    public SpringBusinessServiceImpl(){
    	super();
    }
      
    public void setSpringBusinessBean(SpringBusinessBean springBusinessBean){
    	this.springBusinessBean = springBusinessBean;
    }
    
    public void wishMsg(){
    	springBusinessBean.displayMsg();
    }
}
