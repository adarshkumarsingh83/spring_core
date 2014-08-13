package com.adarsh.spring.test;

import com.adarsh.spring.bean.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring/Spring-cfg.xml"));
        MySpringBean testBean = (MySpringBean) beanFactory.getBean("afterBean");
        testBean.showValues();
    }
}

