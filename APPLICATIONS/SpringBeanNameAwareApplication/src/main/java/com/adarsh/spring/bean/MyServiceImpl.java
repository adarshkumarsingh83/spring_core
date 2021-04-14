package com.adarsh.spring.bean;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class MyServiceImpl implements MyService,BeanNameAware {


    private String name;

    public void setBeanName(String name) {
        this.name = name;
    }

    public void showBean() {
        log.info(" :=> Bean name : " + this.name);
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
