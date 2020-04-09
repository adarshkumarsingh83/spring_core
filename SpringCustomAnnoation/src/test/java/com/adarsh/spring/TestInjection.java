/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.spring;
/*
 * {@inheritDoc}
*/

/**
 * @Product : TestInjection provide implementation of the specification
 *                    provided for the ...    
 */


import com.adarsh.spring.bean.MessageBean;
import com.adarsh.spring.service.MyService;
import com.adarsh.spring.service.MyServiceImplOne;
import com.adarsh.spring.service.MyServiceImplTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 12/6/13 1:46 PM
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/configuration/applicationContext.xml"})
public class TestInjection {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestInjection.class);

    @Qualifier(value = "myServiceImplOne")
    @Autowired(required = true)
    private MyService myServiceImplOne;

    @Qualifier(value = "myServiceImplTwo")
    @Autowired(required = true)
    private MyService myServiceImplTwo;

    @Test
    public void testInject() throws Exception {

        Map<Object, Object> map1 = myServiceImplOne.getBeanObjects();
        for (Map.Entry entry : map1.entrySet()) {
            MessageBean messageBean=(MessageBean)entry.getValue();
            LOGGER.info(myServiceImplOne.getMsgText()+" "+entry.getKey() + " " + entry.getValue()+" "+messageBean.getMsgData());
        }
        Map<Object, Object> map2 = myServiceImplTwo.getBeanObjects();
        for (Map.Entry entry : map2.entrySet()) {
            MessageBean messageBean=(MessageBean)entry.getValue();
            LOGGER.info(myServiceImplTwo.getMsgText()+"  "+entry.getKey() + " " + entry.getValue()+" "+messageBean.getMsgData());
        }
    }
}
