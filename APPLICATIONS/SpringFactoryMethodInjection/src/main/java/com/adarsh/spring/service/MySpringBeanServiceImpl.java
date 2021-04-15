package com.adarsh.spring.service;

import com.adarsh.spring.bean.SpringDataBean;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class MySpringBeanServiceImpl implements MySpringBeanService {

    private SpringDataBean springTestBean;

    public MySpringBeanServiceImpl() {
        super();
    }


    public void setSpringTestBean(SpringDataBean springTestBean) {
        this.springTestBean = springTestBean;
    }

    public void getWish() {
        log.info(":=> " + springTestBean.getMsg());
    }
}
