package com.adarsh.spring.service.impl;

import com.adarsh.spring.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class MyServiceImpl implements MyService, InitializingBean, DisposableBean {

    private String msg;

    public void init() {
        log.info(":=> Init Method()");
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(":=> After Property Set()");
    }

    @Override
    public void destroy() throws Exception {
        log.info(":=> Destroy()");
    }


    public void close() {
        log.info(":=> close()");
    }

}
