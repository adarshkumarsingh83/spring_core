package com.adarsh.spring.main;

import com.adarsh.spring.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] z) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/Spring-cfg.xml");
        MySpringBean mySpringBean = (MySpringBean) context.getBean("mySpringBean");
        LOGGER.info(mySpringBean.toString());
    }
}
