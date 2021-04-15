package com.adarsh.spring.test;

import com.adarsh.spring.service.impl.MyServiceBean;
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
@ContextConfiguration(locations = {"classpath:/configuration/applicationContext.xml"})
public class ApplicationMainTest {


    @Autowired(required = true)
    private MyServiceBean myServiceBean;

    @Test
    public void testMyService(){
        myServiceBean.getWishMsg();
        myServiceBean.getWishMsg("ADARSH KUMAR SINGH");
    }
}
