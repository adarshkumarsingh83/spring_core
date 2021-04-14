package com.adarsh.spring.service;

import com.adarsh.spring.bean.SpringTestBean;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class BusinessServiceImpl implements BusinessService {

    private SpringTestBean springTestBean;

    public BusinessServiceImpl(SpringTestBean springTestBean) {
        this.springTestBean = springTestBean;
    }

    public void setSpringTestBean(SpringTestBean springTestBean) {
        this.springTestBean = springTestBean;
    }

    public void wishMsg() {
        this.springTestBean.displayMsg();
    }
}
