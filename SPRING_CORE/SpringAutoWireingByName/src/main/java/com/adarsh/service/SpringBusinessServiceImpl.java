package com.adarsh.service;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class SpringBusinessServiceImpl implements SpringBusinessService {

   private SampleSpringBusinessBean sampleSpringBusinessBean;
  
    public SpringBusinessServiceImpl(){
    	super();
    }

    public void setSampleSpringBusinessBean(SampleSpringBusinessBean sampleSpringBusinessBean) {
        this.sampleSpringBusinessBean = sampleSpringBusinessBean;
    }

    public void wishMsg(){
        sampleSpringBusinessBean.displayMsg();
    }
}
