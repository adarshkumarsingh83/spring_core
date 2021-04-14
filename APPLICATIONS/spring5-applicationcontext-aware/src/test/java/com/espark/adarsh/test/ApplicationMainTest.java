package com.espark.adarsh.test;

import com.espark.adarsh.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:application-configuration.xml"})
public class ApplicationMainTest {

    @Autowired
    MessageService myService;

    @Test
    public void testMyService(){
        log.info(" :=> " + myService.getMessage());
    }
}