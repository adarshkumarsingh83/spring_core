package com.adarsh.spring;

import com.adarsh.spring.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class ApplicationMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        MyService obj = (MyService) context.getBean("myService");
        log.info(obj.getMsg());
        context.registerShutdownHook();
    }
}
