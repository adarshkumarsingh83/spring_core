package com.adarsh.spring.main;

import com.adarsh.spring.bean.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {
    public static void main(String[] z) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        MySpringBean mySpringBean = (MySpringBean) context.getBean("mySpringBean");
        System.out.println(mySpringBean);
   }
}
