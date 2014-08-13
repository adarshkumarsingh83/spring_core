package com.adarsh.spring.test;

import com.adarsh.spring.bean.LoggingBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring/Spring-cfg.xml"));
        xmlBeanFactory.preInstantiateSingletons();
        LoggingBean loginBean = (LoggingBean) xmlBeanFactory.getBean("loggingBean");
        loginBean.run();
    }

}

