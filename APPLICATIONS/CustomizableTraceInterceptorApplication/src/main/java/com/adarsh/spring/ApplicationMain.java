package com.adarsh.spring;

import com.adarsh.spring.bean.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        final BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring/Spring-cfg.xml"));
        final MySpringBean testBean = (MySpringBean) beanFactory.getBean("afterBean");
        testBean.showValues();
    }
}

