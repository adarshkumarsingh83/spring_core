package com.adarsh.spring.main;

import com.adarsh.spring.service.MyBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.*;
import org.springframework.beans.factory.xml.*;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ClientClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientClass.class);

    public static void main(String[] args) {
        try {
            XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("src\\main\\resources\\spring\\spring-cfg.xml"));
            MyBusinessService object = (MyBusinessService) factory.getBean("businessObject");
            object.displayProperyFile();
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage());
        } finally {
            LOGGER.info("finally block of the main method");
        }
    }

}
