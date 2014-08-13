package com.adarsh.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


import static java.lang.System.out;


/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyBusinessServiceImpl implements MyBusinessService {


    private static final Logger LOGGER = LoggerFactory.getLogger(MyBusinessServiceImpl.class);
    private Properties propertiesFile;

    public Properties getPropertiesFile() {
        return propertiesFile;
    }

    public void setPropertiesFile(Properties propertiesFile) {
        this.propertiesFile = propertiesFile;
    }

    public MyBusinessServiceImpl() {
        super();
    }

    public void displayProperyFile() throws Exception {
        Enumeration<Object> enm = propertiesFile.elements();
        while (enm.hasMoreElements()) {
            LOGGER.info(enm.nextElement().toString());
        }
    }

}
