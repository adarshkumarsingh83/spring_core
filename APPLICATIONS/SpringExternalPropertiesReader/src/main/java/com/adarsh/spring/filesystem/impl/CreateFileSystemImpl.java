/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */
package com.adarsh.spring.filesystem.impl;


import com.adarsh.spring.properties.ApplicationProperties;
import org.apache.commons.io.FileDeleteStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 * @see
 */
public class CreateFileSystemImpl implements CreateFileSystem {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateFileSystemImpl.class);
    private static final CreateFileSystem CREATE_FILE_SYSTEM = new CreateFileSystemImpl();
    private boolean flushFileSystem = false;
    private String root = null;
    private String home = null;
    private String temp = null;
    private String log = null;
    private String upload = null;
    private String sql = null;
    private String download = null;
    private String properties = null;
    private String appPropertiesFile = null;
    private String imagePropertiesFile = null;
    private String fileSystemPropertiesFile = null;
    private String batchPackPropertiesFile = null;
    private String validationPropertiesFile = null;
    private String communicationPropertiesFile = null;
    private String packLevelPropertiesFile = null;
    private FileSystemServiceImpl fileSystem;

    private CreateFileSystemImpl() {
    }

    public static final CreateFileSystem getInstance() {
        return CREATE_FILE_SYSTEM;
    }

    @Override
    public void inItProperties(ApplicationProperties applicationProperties) throws Exception {
        if (applicationProperties.propertySize() > 0) {
            flushFileSystem = applicationProperties.getBooleanProperty(this.getClass().getName() + ".flush");
            root = applicationProperties.getStringProperty(this.getClass().getName() + ".root");
            home = applicationProperties.getStringProperty(this.getClass().getName() + ".home");
            temp = applicationProperties.getStringProperty(this.getClass().getName() + ".temp");
            log = applicationProperties.getStringProperty(this.getClass().getName() + ".log");
            sql = applicationProperties.getStringProperty(this.getClass().getName() + ".sql");
            upload = applicationProperties.getStringProperty(this.getClass().getName() + ".upload");
            download = applicationProperties.getStringProperty(this.getClass().getName() + ".download");
            properties = applicationProperties.getStringProperty(this.getClass().getName() + ".properties");
            appPropertiesFile = applicationProperties.getStringProperty(this.getClass().getName() + ".propertiesFile_app");
            fileSystemPropertiesFile = applicationProperties.getStringProperty(this.getClass().getName() + ".propertiesFile_file");
            imagePropertiesFile = applicationProperties.getStringProperty(this.getClass().getName() + ".propertiesFile_img");
            batchPackPropertiesFile = applicationProperties.getStringProperty(this.getClass().getName() + ".propertiesFile_batchPack");
            validationPropertiesFile = applicationProperties.getStringProperty(this.getClass().getName() + ".propertiesFile_validation");
            communicationPropertiesFile = applicationProperties.getStringProperty(this.getClass().getName() + ".propertiesFile_communication");
            packLevelPropertiesFile = applicationProperties.getStringProperty(this.getClass().getName() + ".propertiesFile_packLevels");
        } else {
            LOGGER.error("No Configuration Properties found ");
        }
    }

    @Override
    public void createFileSystem() throws IOException {

        if (flushFileSystem) {
            try {
                fileSystem = (FileSystemServiceImpl) FileSystemServiceImpl.getDefaultInstance();
                File fileSystemFile = fileSystem.getFileSystem();
                fileSystemFile = new File(fileSystemFile.getAbsolutePath() + File.separator + home);
                if (fileSystemFile.exists()) {
                    File[] files = fileSystemFile.listFiles();
                    for (File file : files) {
                        if (file.isFile() && !file.delete()) {
                            LOGGER.info("Unable to delete file :=" + file.getPath());
                        }
                        if (file.isDirectory()) {
                            try {
                                FileDeleteStrategy.FORCE.delete(file);
                            } catch (IOException e) {
                                LOGGER.error("Unable to delete directory :=" + file.getPath());
                            }
                        }
                    }
                }

                /* creating the basic dir structure for the home*/
                fileSystem.getDirectory(home, true, true);
                fileSystem.getDirectory(home, temp, true, true);
                fileSystem.getDirectory(home, log, true, true);
                fileSystem.getDirectory(home, sql, true, true);
                fileSystem.getDirectory(home, upload, true, true);
                fileSystem.getDirectory(home, download, true, true);
                fileSystem.getDirectory(home, properties, true, true);
                this.writeAppProp(fileSystem.getFile(home + File.separator + properties, appPropertiesFile, true, true));
                this.writeImgProp(fileSystem.getFile(home + File.separator + properties, imagePropertiesFile, true, true));
                this.writeFileProp(fileSystem.getFile(home + File.separator + properties, fileSystemPropertiesFile, true, true));
                this.writeValidationProp(fileSystem.getFile(home + File.separator + properties, validationPropertiesFile, true, true));
                this.writeCommunicationProp(fileSystem.getFile(home + File.separator + properties, communicationPropertiesFile, true, true));
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    private void writeAppProp(File file) {
        try {
            Properties properties = new Properties();
            properties.setProperty("application.logger.level", "TRACE");
            properties.setProperty("apollo.logger.level", "ALL");
            properties.setProperty("apollo.spring.logger.level", "INFO");
            properties.setProperty("apollo.hibernate.logger.level", "INFO");
            properties.setProperty("apollo.logger.size", "1024MB");
            properties.store(new FileOutputStream(file.getAbsoluteFile()), "Application Properties File ");
        } catch (Exception exceptionObject) {
            LOGGER.error(exceptionObject.getMessage());
        }
    }

    /**
     * writeImgProp() for image related
     *
     * @param file
     */
    private void writeImgProp(File file) {
        try {
            Properties properties = new Properties();
         /*   properties.setProperty(ImageTypeConversionTransformerImpl.class.getName() + ".IMAGE_CONVERSION_ENABLE", "true");
            properties.setProperty(ImageTypeConversionTransformerImpl.class.getName() + ".DEFAULT_IMAGE_EXTENSION", "JPEG");
            properties.setProperty(ImageTypeConversionTransformerImpl.class.getName() + ".IMAGE_EXTENSION", "JPG,JPEG,jpeg,jpg,Jpg,Jpeg.png,Png,Bmp,BMP,bmp");
            properties.setProperty(ImageReSizingTransformerImpl.class.getName() + ".IMAGE_RESIZE_ENABLE", "true");
            properties.setProperty(ImageReSizingTransformerImpl.class.getName() + ".IMAGE_SIZE", "200");
            properties.setProperty(ImageReSizingTransformerImpl.class.getName() + ".IMAGE_EXTENSION", "JPG,JPEG,jpeg,jpg,Jpg,Jpeg.png,Png,Bmp,BMP,bmp");
            properties.setProperty(ImageReSizingTransformerImpl.class.getName() + ".IMAGE_PAD_ENABLE", "false");
            properties.setProperty(ImageReSizingTransformerImpl.class.getName() + ".IMAGE_PAD", "4");*/
            properties.store(new FileOutputStream(file.getAbsoluteFile()), "Image Properties File ");
        } catch (Exception exceptionObject) {
            LOGGER.error(exceptionObject.getMessage());
        }
    }

    /**
     * writeFileProp() for file system properties
     *
     * @param file
     */
    private void writeFileProp(File file) {
        try {
            Properties properties = new Properties();
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".flush", "false");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".root", "application_home");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".home", "home");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".temp", "temp");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".log", "log");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".sql", "sql");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".upload", "upload");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".download", "downloads");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".properties", "properties");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".propertiesFile_app", "applicationProperties.properties");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".propertiesFile_file", "filSystemProperties.properties");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".propertiesFile_img", "imageProperties.properties");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".propertiesFile_validation", "validationProperties.properties");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".propertiesFile_communication", "communicationProperties.properties");

            properties.store(new FileOutputStream(file.getAbsoluteFile()), "FileSystem Properties File ");
        } catch (Exception exceptionObject) {
            LOGGER.error(exceptionObject.getMessage());
        }
    }

    /**
     * writeValidationProp() for excel validation
     *
     * @param file
     */
    private void writeValidationProp(File file) {
        try {
            Properties properties = new Properties();
            properties.setProperty("sampleValidationKey", "sampleValidationValue");
            properties.store(new FileOutputStream(file.getAbsoluteFile()), "Validation Properties File ");
        } catch (Exception exceptionObject) {
            LOGGER.error(exceptionObject.getMessage());
        }
    }



    /**
     * writeCommunicationProp() for communication
     *
     * @param file
     */
    private void writeCommunicationProp(File file) {
        try {
            Properties properties = new Properties();
            properties.setProperty("communicationKey", "communicationValue");
            properties.store(new FileOutputStream(file.getAbsoluteFile()), "Communication Properties File ");
        } catch (Exception exceptionObject) {
            LOGGER.error(exceptionObject.getMessage());
        }
    }
}
