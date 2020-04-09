package com.adarsh.spring.test;

import com.adarsh.spring.bean.MySpringBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired(required = true)
    private MySpringBean mySpringBean;

    @Test
    public void testMyService(){
        LOGGER.info(" :=> " +mySpringBean);
    }
}
