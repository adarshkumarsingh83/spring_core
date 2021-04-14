package com.adarsh.spring;

import com.adarsh.spring.bean.MyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class ApplicationMain {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:/spring/applicationContext.xml");
        MyService bean = (MyService) context.getBean("myService");
        log.info(" :=> " + bean.getMsg());
        bean.showBean();
    }

}
