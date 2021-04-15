package com.adarsh.spring.manager;

import com.adarsh.spring.annotation.Manager;
import com.adarsh.spring.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh_K
 * Date: 18/10/13
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Manager(value = "myManagerImpl")
public class MyManagerImpl implements MyManager {


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



    @Qualifier("myServiceImpl")
    @Autowired
    private MyService myService;

    public String getMessage() {
        log.info("\n"+applicationLogLevel+" "+appName1+appName2+appName3+appName4);
        return myService.getAppName();
    }
}
