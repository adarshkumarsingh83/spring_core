package com.adarsh.spring.test;

import com.adarsh.spring.bean.MyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class ApplicationTest {


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
        log.info(" :=> myServiceSingleTon " + myServiceSingleTon1.hashCode());

        myServiceSingleTon2.getMessage();
        log.info(" :=> myServiceSingleTon " + myServiceSingleTon2.hashCode());

        myServicePrototype1.getMessage();
        log.info(" :=> myServicePrototype " + myServicePrototype1.hashCode());

        myServicePrototype2.getMessage();
        log.info(" :=> myServicePrototype " + myServicePrototype2.hashCode());

    }
}
