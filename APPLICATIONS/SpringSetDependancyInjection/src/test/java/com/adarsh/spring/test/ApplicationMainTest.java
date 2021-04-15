package com.adarsh.spring.test;

import com.espark.adarsh.service.MyBusinessService;
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
public class ApplicationMainTest {


    @Autowired(required = true)
    private MyBusinessService myBusinessService;

    @Test
    public void testMyService(){
        this.myBusinessService.displaySet();
    }
}
