package com.espark.adarsh.test;

import com.espark.adarsh.bean.MessageBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:/application-context.xml"})
public class ApplicationMainTest {

    @Autowired
    MessageBean messageBean;

    @Test
    public void test(){
        System.out.println(messageBean.getName());
    }
}
