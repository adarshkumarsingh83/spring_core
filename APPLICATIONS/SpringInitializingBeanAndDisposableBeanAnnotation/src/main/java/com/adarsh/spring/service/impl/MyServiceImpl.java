package com.adarsh.spring.service.impl;

import com.adarsh.spring.service.MyService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service(value = "myService")
public class MyServiceImpl implements MyService, InitializingBean, DisposableBean {

    
    @Value("${app.service.msg}")
    private String msg;

    @PostConstruct
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
       log.info(":=> Destory()");
    }


    @PreDestroy
    public void close() {
       log.info(":=> close()");
    }

}
