package com.adarsh.spring.test;

import com.adarsh.spring.bean.Message;
import com.adarsh.spring.service.MyMessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired(required = true)
    private Message message;

    @Autowired(required = true)
    private MyMessageService myMessageService;

    @Test
    public void testMyService() {
        message.getMessage1();
        message.getMessage2();

        myMessageService.getMessage1();
        myMessageService.getMessage2();
        myMessageService.getMessage3();
    }
}
