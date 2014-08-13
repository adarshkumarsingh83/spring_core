package com.adarsh.spring.service;

import com.adarsh.spring.bean.MySpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MySpringBeanServiceImpl implements MySpringBeanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MySpringBeanServiceImpl.class);

    private MySpringBean mySpringBean;

    public MySpringBeanServiceImpl() {
        super();
    }

    public void setMySpringBean(MySpringBean mySpringBean) {
        this.mySpringBean = mySpringBean;
    }

    public void getWish() {
        LOGGER.info(mySpringBean.getMsg());
    }
}
