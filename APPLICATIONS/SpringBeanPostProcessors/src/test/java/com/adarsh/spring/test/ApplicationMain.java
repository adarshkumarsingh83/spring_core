package com.adarsh.spring.test;

import com.adarsh.spring.bean.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    public static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) {

        AbstractApplicationContext context =new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        MyService obj = (MyService) context.getBean("myService");
        LOGGER.info(obj.getMessage());
        context.registerShutdownHook();
    }
}