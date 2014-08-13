package com.adarsh.spring.service;

import com.adarsh.spring.bean.MyBean;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class BusinessServiceImpl implements BusinessService {

    private MyBean myBean;

    public BusinessServiceImpl(MyBean myBean) {
        this.myBean = myBean;
    }

    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }

    public void wishMsg() {
        this.myBean.displayMsg();
    }
}
