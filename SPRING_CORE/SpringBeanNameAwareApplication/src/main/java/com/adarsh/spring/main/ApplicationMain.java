package com.adarsh.spring.main;

import com.adarsh.spring.bean.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/Spring-cfg.xml");
        MyService bean = (MyService) context.getBean("myService");
        System.out.println(" :=> " + bean.getMsg());
        bean.showBean();
    }

}
