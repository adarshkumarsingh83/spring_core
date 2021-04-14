package com.adarsh.spring.service;

import com.adarsh.spring.bean.SpringTestBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MySpringBeanServiceImpl implements MySpringBeanService {
   private SpringTestBean springTestBean;

    public static final Logger LOGGER = LoggerFactory.getLogger(MySpringBeanServiceImpl.class);

   public MySpringBeanServiceImpl(){
	   super();
   }
     
   
   public void setSpringTestBean(SpringTestBean springTestBean){
	   this.springTestBean = springTestBean;
   }
   
   public void getWish(){
       LOGGER.info(":=> "+springTestBean.getMsg());
   }
}
