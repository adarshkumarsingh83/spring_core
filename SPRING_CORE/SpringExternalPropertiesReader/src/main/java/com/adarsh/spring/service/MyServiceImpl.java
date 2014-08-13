package com.adarsh.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh_K
 * Date: 16/10/13
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 */

@Scope("singleton")
@Service(value = "myServiceImpl")
public class MyServiceImpl implements MyService {

    @Value("${application.logger.level}")
    private String applicationLogLevel;

    @Value("${app.name1}")
    private String appName1;

    @Value("${app.name2}")
    private String appName2;

    @Value("${app.name3}")
    private String appName3;

    @Value("${app.name4}")
    private String appName4;

    @Value("${com.adarsh.spring.service.MyServiceImpl.value}")
    String value;

    public String getApplicationLogLevel() {
        return applicationLogLevel;
    }

    public String getAppName() {
        return appName1 + " " + appName2 + " " + appName3 + " " + appName4+" "+value;
    }
}
