package com.espark.adarsh;

import com.espark.adarsh.bean.MessageBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        MessageBean messageBean = (MessageBean) context.getBean("messageBean");
        System.out.println(messageBean.getName());
    }

}
