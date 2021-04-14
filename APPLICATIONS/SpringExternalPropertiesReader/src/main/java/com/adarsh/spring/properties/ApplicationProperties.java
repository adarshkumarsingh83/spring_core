/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */
package com.adarsh.spring.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface ApplicationProperties {

    /**
     * getBooleanProperty() provides the specification for
     * getting the boolean property by passing the valid key
     *
     * @param propertyName accept the instance of the java.lang.String
     *                     containing the key for the property
     * @return boolean value for the key supplied
     */
    public boolean getBooleanProperty(String propertyName);

    /**
     * getBooleanProperty() provides the specification for
     * getting the String property by passing the valid key
     *
     * @param propertyName accept the instance of the java.lang.String
     *                     containing the key for the property
     * @return String value for the key supplied
     */
    public String getStringProperty(String propertyName);

    /**
     * getIntegerProperty() provides the specification for
     * getting the Integer property by passing the valid key
     *
     * @param propertyName accept the instance of the java.lang.String
     *                     containing the key for the property
     * @return Integer value for the key supplied
     */
    public int getIntegerProperty(String propertyName);

    /**
     * getLongProperty() provides the specification for
     * getting the Long property by passing the valid key
     *
     * @param propertyName accept the instance of the java.lang.String
     *                     containing the key for the property
     * @return Long value for the key supplied
     */
    public long getLongProperty(String propertyName);

    /**
     * hasProperty() provides the specification for
     * checking the valid existing  property by passing the valid key
     *
     * @param propName accept the instance of the java.lang.String
     *                 containing the key for the property
     * @return boolean true value for the key supplied if it exists
     *         otherwise return false
     */
    public boolean hasProperty(String propName);

    /**
     * getProperty() provides the specification for
     * getting the  property by passing the valid key
     *
     * @param propName accept the instance of the java.lang.String
     *                 containing the key for the property
     * @return Object value for the key supplied
     */
    public Object getProperty(String propName);

    /**
     * getAllProperties() provides the specification for
     * getting all the property
     *
     * @return java.util.Properties objects containing all the properties
     */
    public Properties getAllProperties();

    /**
     * propertySize() provide the specification for
     * getting the property total size from the property pool.
     * @return instance of the java.lang.Integer containing
     *         the value of the specified key.
     */
    public Integer propertySize();


    /**
     * loadProperties() provide the specification for loading the properties
     * from the various application modules and from application file system
     * it will scan whole application modules for .properties files and also
     * the application file system and load the properties from files
     *
     * @param propertiesObject accept the instance of java.util.Properties
     *                   which need to filled with the properties
     *                   from applications properties from various modules
     *                   and also from the application filesystem properties.
     * @throws java.io.IOException in case of I/O errors
     */
    public void loadProperties(Properties propertiesObject) throws IOException;

}

