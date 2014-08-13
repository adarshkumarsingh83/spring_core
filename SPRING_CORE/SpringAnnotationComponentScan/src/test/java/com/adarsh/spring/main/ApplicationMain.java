package com.adarsh.spring.main;

import com.adarsh.spring.services.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationMain {

    private static final Logger LOGGER=LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext-scan.xml"});

        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans) {
            LOGGER.info(bean);
        }

    }
}
