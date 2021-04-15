package com.adarsh.spring.service;

import com.adarsh.spring.bean.SpringDataBean;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class BusinessServiceImpl implements BusinessService {

    private SpringDataBean springTestBean;

    public BusinessServiceImpl(SpringDataBean springDataBean) {
        this.springTestBean = springDataBean;
    }

    public void setSpringDataBean(SpringDataBean springDataBean) {
        this.springTestBean = springDataBean;
    }

    public void wishMsg() {
        this.springTestBean.displayMsg();
    }
}
