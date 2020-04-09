package com.adarsh.spring.properties;

import com.adarsh.spring.bean.MyBean;
import com.adarsh.spring.manager.MyManager;
import com.adarsh.spring.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(locations = "classpath*:/spring/applicationContext.xml")
public class PropertiesTest {

    protected static final Logger LOGGER = LoggerFactory.getLogger(PropertiesTest.class);
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

        LOGGER.info("value " + sampleValidationKey);
        LOGGER.info("value " + myService.getApplicationLogLevel());
        LOGGER.info("name " + myService.getAppName());
        LOGGER.info("MyBean " + myBean.toString());
        LOGGER.info("All Properties " + applicationProperties.getAllProperties().toString());
        LOGGER.info("MyManager " + myManager.getMessage());

    }

}
