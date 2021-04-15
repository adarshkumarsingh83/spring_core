package com.adarsh.spring.properties;

import com.adarsh.spring.bean.MyBean;
import com.adarsh.spring.manager.MyManager;
import com.adarsh.spring.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@Slf4j
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(locations = "classpath*:/spring/applicationContext.xml")
public class ApplicationMainTest {

    @Qualifier("myServiceImpl")
    @Autowired(required = true)
    MyService myService;
    @Value("${sampleValidationKey}")
    String sampleValidationKey;
    @Autowired
    MyBean myBean;
    @Qualifier(value = "applicationProperties")
    @Autowired(required = true)
    ApplicationProperties applicationProperties;
    @Autowired
    private MyManager myManager;

    @Test
    public void testProperties() {

        log.info("value " + sampleValidationKey);
        log.info("value " + myService.getApplicationLogLevel());
        log.info("name " + myService.getAppName());
        log.info("MyBean " + myBean.toString());
        log.info("All Properties " + applicationProperties.getAllProperties().toString());
        log.info("MyManager " + myManager.getMessage());

    }

}
