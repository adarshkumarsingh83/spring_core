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
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 12/6/13 1:46 PM
 * @see
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:/configuration/applicationContext.xml"})
public class TestInjection {


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
            log.info(myServiceImplOne.getMsgText()+" "+entry.getKey() + " " + entry.getValue()+" "+messageBean.getMsgData());
        }
        Map<Object, Object> map2 = myServiceImplTwo.getBeanObjects();
        for (Map.Entry entry : map2.entrySet()) {
            MessageBean messageBean=(MessageBean)entry.getValue();
            log.info(myServiceImplTwo.getMsgText()+"  "+entry.getKey() + " " + entry.getValue()+" "+messageBean.getMsgData());
        }
    }
}
