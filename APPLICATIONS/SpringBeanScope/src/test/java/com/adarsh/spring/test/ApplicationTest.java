package com.adarsh.spring.test;

import com.adarsh.spring.bean.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class ApplicationTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(ApplicationTest.class);

    @Qualifier(value = "myServiceSingleTon")
    @Autowired(required = true)
    private MyService myServiceSingleTon1;

    @Qualifier(value = "myServiceSingleTon")
    @Autowired(required = true)
    private MyService myServiceSingleTon2;

    @Qualifier(value = "myServicePrototype")
    @Autowired(required = true)
    private MyService myServicePrototype1;

    @Qualifier(value = "myServicePrototype")
    @Autowired(required = true)
    private MyService myServicePrototype2;

    @Test
    public void testMyService(){

        myServiceSingleTon1.getMessage();
        LOGGER.info(" :=> myServiceSingleTon " + myServiceSingleTon1.hashCode());

        myServiceSingleTon2.getMessage();
        LOGGER.info(" :=> myServiceSingleTon " + myServiceSingleTon2.hashCode());

        myServicePrototype1.getMessage();
        LOGGER.info(" :=> myServicePrototype " + myServicePrototype1.hashCode());

        myServicePrototype2.getMessage();
        LOGGER.info(" :=> myServicePrototype " + myServicePrototype2.hashCode());

    }
}
