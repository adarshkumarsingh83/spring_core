package com.adarsh.spring.service.impl;

import com.adarsh.spring.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Service(value = "myService")
public class MyServiceImpl implements MyService, InitializingBean, DisposableBean {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyServiceImpl.class);
    
    @Value("${app.service.msg}")
    private String msg;

    @PostConstruct
    public void init() {
       LOGGER.info(":=> Init Method()");
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
       LOGGER.info(":=> After Property Set()");
    }

    @Override
    public void destroy() throws Exception {
       LOGGER.info(":=> Destory()");
    }


    @PreDestroy
    public void close() {
       LOGGER.info(":=> close()");
    }

}
