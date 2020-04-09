package com.adarsh.spring.main;

import com.adarsh.spring.bean.MyService;
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

    public static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:/spring/applicationContext.xml");
        MyService bean = (MyService) context.getBean("myService");
        LOGGER.info(" :=> " + bean.getMsg());
        bean.showBean();
    }

}
