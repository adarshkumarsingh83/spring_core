package com.adarsh.spring.test;

import com.adarsh.service.SpringBusinessService;
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
    private SpringBusinessService springBusinessService;

    @Test
    public void testMyService(){
        springBusinessService.wishMsg();
    }
}
