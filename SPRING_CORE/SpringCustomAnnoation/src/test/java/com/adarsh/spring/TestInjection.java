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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 12/6/13 1:46 PM
 * @see
 */
public class TestInjection {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestInjection.class);

    @Test
    public void testInject() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        System.out.println("\n\n\n");
        MyService myServiceImplOne = applicationContext.getBean(MyServiceImplOne.class);
        Map<Object, Object> map1 = myServiceImplOne.getBeanObjects();
        for (Map.Entry entry : map1.entrySet()) {
            MessageBean messageBean = (MessageBean) entry.getValue();
            LOGGER.info(myServiceImplOne.getMsgText() + " " + entry.getKey() + " " + entry.getValue() + " " + messageBean.getMsgData());
        }
        System.out.println("");
        MyService myServiceImplTwo = applicationContext.getBean(MyServiceImplTwo.class);
        Map<Object, Object> map2 = myServiceImplTwo.getBeanObjects();
        for (Map.Entry entry : map2.entrySet()) {
            MessageBean messageBean = (MessageBean) entry.getValue();
            LOGGER.info(myServiceImplTwo.getMsgText() + "  " + entry.getKey() + " " + entry.getValue() + " " + messageBean.getMsgData());
        }
    }
}
