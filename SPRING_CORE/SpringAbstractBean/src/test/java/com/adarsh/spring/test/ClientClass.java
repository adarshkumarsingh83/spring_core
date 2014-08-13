package com.adarsh.spring.test;

import com.adarsh.spring.service.impl.ServiceClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.*;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.XmlBeanFactory;
/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ClientClass {

    public static final Logger LOGGER = LoggerFactory.getLogger(ClientClass.class);

    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("src\\main\\resources\\spring\\Spring-cfg.xml"));
        ServiceClass obj = (ServiceClass) beanFactory.getBean("serviceClass");
        LOGGER.info(obj.method());
    }

}
