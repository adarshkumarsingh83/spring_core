/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */
package com.adarsh.spring.properties.impl;


import com.adarsh.spring.filesystem.impl.CreateFileSystem;
import com.adarsh.spring.filesystem.impl.CreateFileSystemImpl;
import com.adarsh.spring.filesystem.impl.FileSystemService;
import com.adarsh.spring.filesystem.impl.FileSystemServiceImpl;
import com.adarsh.spring.properties.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:37 PM#$
 * @see com.adarsh.spring.properties.ApplicationProperties
 * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
 */
public class ApplicationPropertiesImpl extends PropertyPlaceholderConfigurer
        implements ApplicationProperties {

    private final static Logger logger = LoggerFactory.getLogger(ApplicationPropertiesImpl.class);
    private static final CreateFileSystem createFileSystem = CreateFileSystemImpl.getInstance();
    private static Properties properties = new Properties();
    private static ApplicationProperties applicationProperties;

    public ApplicationPropertiesImpl() {
        logger.trace("APPLICATION PROPERTIES INITIALISED ");
        applicationProperties = this;
    }

    public static ApplicationProperties getInstance() {
        return applicationProperties;
    }

    @Override
    public void loadProperties(Properties propertiesObject) throws IOException {
        try {
            super.loadProperties(propertiesObject);
            Properties fileSystemProperties = this.readProperties();

            if (fileSystemProperties != null && fileSystemProperties.size() != 0) {
                final String fileSystemFlush = fileSystemProperties.getProperty(CreateFileSystemImpl.class.getName() + ".flush");
                if (fileSystemFlush != null && !fileSystemFlush.isEmpty()) {
                    final boolean flush = Boolean.parseBoolean(fileSystemFlush);
                    if (flush) {
                        //1.creating file system.
                        logger.info("creating new file system ");
                        this.copyProperties(propertiesObject, properties);
                        this.copyProperties(fileSystemProperties, properties);
                        createFileSystem.inItProperties(applicationProperties);
                        createFileSystem.createFileSystem();
                        properties.clear();
                        //2 read all the properties
                        fileSystemProperties = this.readProperties();
                    }
                }
            } else {
                //create file system.
                logger.info("creating new file system ");
                this.copyProperties(propertiesObject, properties);
                createFileSystem.inItProperties(applicationProperties);
                createFileSystem.createFileSystem();
                properties.clear();
                //2 read all the properties
                fileSystemProperties = this.readProperties();
            }
            this.copyProperties(fileSystemProperties, propertiesObject);
            super.setLocalOverride(false);
            super.setOrder(Integer.MIN_VALUE);
            super.setIgnoreResourceNotFound(true);
            super.setIgnoreUnresolvablePlaceholders(true);
            //super.setProperties(propertiesObject);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        } finally {
            this.copyProperties(propertiesObject, properties);
        }
    }

    /**
     * readProperties() provide the implementation for reading the
     * properties from the application file system and creating the
     * properties pool and then returning all the properties to the
     * caller method.
     *
     * @return the instance of the java.util.Properties containing
     *         the properties in key and value pair of the applicaion
     *         file system.
     */
    private Properties readProperties() {
        final Properties fileSystemProperties = new Properties();
        try {
            final FileSystemService fileSystemService = FileSystemServiceImpl.getDefaultInstance();
            final List list = fileSystemService.getDirByName("dx");
            if (list != null && list.size() > 0) {
                final String homeDir = list.get(0).toString();
                final List<String> filePathList = fileSystemService.getFileByExtension(homeDir, "properties");
                if (filePathList != null && filePathList.size() > 0) {
                    for (String filePath : filePathList) {
                        try {
                            fileSystemProperties.load(new FileInputStream(new File(filePath)));
                            final Set<Map.Entry<Object, Object>> setProperties = fileSystemProperties.entrySet();
                            final Iterator<Map.Entry<Object, Object>> iterator = setProperties.iterator();
                            while (iterator.hasNext()) {
                                final Map.Entry<Object, Object> entry = iterator.next();
                                fileSystemProperties.put(entry.getKey().toString(), entry.getValue());
                            }
                        } catch (Exception e) {
                            logger.error(e.getMessage());
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        return fileSystemProperties;
    }

    /**
     * copyProperties() copy the properties from spring properties pool
     * to application local properties pool.
     *
     * @param propertiesFrom accept the instance of the java.util.Properties
     *                       containing properties from where to copy.
     * @param propertiesTo   accept the instance of the java.util.Properties
     *                       into which properties need to be copy.
     */
    private void copyProperties(final Properties propertiesFrom, final Properties propertiesTo) {
        final Set<String> propertiesSet = propertiesFrom.stringPropertyNames();
        final Iterator iterator = propertiesSet.iterator();
        while (iterator.hasNext()) {
            String propKey = iterator.next().toString();
            propertiesTo.put(propKey, propertiesFrom.get(propKey));
        }
    }

    @Override
    public Object getProperty(String propName) {
        return properties.getProperty(propName);
    }

    @Override
    public boolean hasProperty(String propName) {
        return properties.containsKey(propName);
    }

    @Override
    public boolean getBooleanProperty(String propertyName) {
        return Boolean.parseBoolean(properties.getProperty(propertyName));
    }

    @Override
    public String getStringProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    @Override
    public int getIntegerProperty(String propertyName) {
        return Integer.parseInt(properties.getProperty(propertyName));
    }

    @Override
    public long getLongProperty(String propertyName) {
        return Long.parseLong(properties.getProperty(propertyName));
    }

    @Override
    public Properties getAllProperties() {
        return properties;
    }

    @Override
    public Integer propertySize() {
        Integer result = 0;
        if (properties != null) {
            result = properties.size();
        }
        return result;
    }

}
