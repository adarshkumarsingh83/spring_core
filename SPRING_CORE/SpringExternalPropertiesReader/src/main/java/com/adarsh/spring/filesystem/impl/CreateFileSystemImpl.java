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
    private String dxHome = null;
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
            dxHome = applicationProperties.getStringProperty(this.getClass().getName() + ".dxHome");
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
                fileSystemFile = new File(fileSystemFile.getAbsolutePath() + File.separator + dxHome);
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

                /* creating the basic dir structure for the dm*/
                fileSystem.getDirectory(dxHome, true, true);
                fileSystem.getDirectory(dxHome, temp, true, true);
                fileSystem.getDirectory(dxHome, log, true, true);
                fileSystem.getDirectory(dxHome, sql, true, true);
                fileSystem.getDirectory(dxHome, upload, true, true);
                fileSystem.getDirectory(dxHome, download, true, true);
                fileSystem.getDirectory(dxHome, properties, true, true);
                this.writeAppProp(fileSystem.getFile(dxHome + File.separator + properties, appPropertiesFile, true, true));
                this.writeImgProp(fileSystem.getFile(dxHome + File.separator + properties, imagePropertiesFile, true, true));
                this.writeFileProp(fileSystem.getFile(dxHome + File.separator + properties, fileSystemPropertiesFile, true, true));
                this.writeBatchPackProp(fileSystem.getFile(dxHome + File.separator + properties, batchPackPropertiesFile, true, true));
                this.writeValidationProp(fileSystem.getFile(dxHome + File.separator + properties, validationPropertiesFile, true, true));
                this.writeCommunicationProp(fileSystem.getFile(dxHome + File.separator + properties, communicationPropertiesFile, true, true));
                this.writePackLevelProp(fileSystem.getFile(dxHome + File.separator + properties, packLevelPropertiesFile, true, true));
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    private void writeAppProp(File file) {
        try {
            Properties properties = new Properties();
            properties.setProperty("com.merittrac.apollo.dx.persistence.job.SeedDataInjector.inject", "true");
            properties.setProperty("com.merittrac.apollo.dx.web.service.DatabaseScriptExporterServiceImpl.export", "false");
            properties.setProperty("com.merittrac.apollo.dx.web.service.DatabaseScriptExporterServiceImpl.delimiter", ";");
            properties.setProperty("com.merittrac.apollo.dx.core.log.ApplicationAppender.userAppFileSystemLog", "true");
            properties.setProperty("com.merittrac.apollo.dx.web.rest.server.impl.DmAcsCommunicationImpl.loadTest", "false");
            properties.setProperty("com.merittrac.apollo.dx.web.service.FileSystemMonitorServiceImpl.pollingInterval", "100000");
            properties.setProperty("com.merittrac.apollo.dx.web.service.FileSystemMonitorServiceImpl.enable", "false");
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
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".root", "apollo_home");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".dxHome", "dx");
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
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".propertiesFile_batchPack", "batchPackProperties.properties");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".propertiesFile_communication", "communicationProperties.properties");
            properties.setProperty(CreateFileSystemImpl.class.getName() + ".propertiesFile_packLevels", "packLevels.properties");

            properties.setProperty("com.merittrac.apollo.dx.web.file.FileWriterServiceImpl.name", "ACS_LIST.TXT");
            properties.setProperty("com.merittrac.apollo.dx.web.file.FileWriterServiceImpl.appendData", "true");

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
     * writeBatchPackProp() for batch Pack configuration
     *
     * @param file
     */
    private void writeBatchPackProp(File file) {
        try {
            Properties properties = new Properties();
            properties.setProperty("com.merittrac.apollo.dx.web.service.BatchPackServiceImpl.LEVEL", "acs");
            properties.setProperty("com.merittrac.apollo.dx.web.service.BatchPackServiceImpl.Encryption", "true");
            properties.setProperty("com.merittrac.apollo.dx.web.service.BatchPackServiceImpl.EncryptionType", "256");
            properties.setProperty("com.merittrac.apollo.dx.web.service.BatchPackServiceImpl.PasswordProtection", "false");
            properties.store(new FileOutputStream(file.getAbsoluteFile()), "BatchPack Properties File ");
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

            properties.setProperty("com.merittrac.apollo.dx.web.rest.client.impl.PackGenRestRequestServiceImpl.HOST", "SRAVANTHI");
            properties.setProperty("com.merittrac.apollo.dx.web.rest.client.impl.PackGenRestRequestServiceImpl.PORT", "8080");
            properties.setProperty("com.merittrac.apollo.dx.web.rest.client.impl.PackGenRestRequestServiceImpl.MIME_TYPE", "application/json");
            properties.setProperty("com.merittrac.apollo.dx.web.rest.client.impl.PackGenRestRequestServiceImpl.CONTEXT", "/apollo-package-gen-1.1.0-SNAPSHOT/rest");
            properties.setProperty("com.merittrac.apollo.dx.web.rest.client.impl.PackGenRestRequestServiceImpl.APACK_SERVICE_URL", "/dmRequestResource/generate/apack/");
            properties.setProperty("com.merittrac.apollo.dx.web.rest.client.impl.PackGenRestRequestServiceImpl.QPACK_SERVICE_URL", "/dmRequestResource/generate/qpack/");
            properties.setProperty("com.merittrac.apollo.dx.web.service.GeneratePackService.DM_ACS.GDM_REST_HTTP_PROTOCOL", "http://");
            properties.setProperty("com.merittrac.apollo.dx.web.service.GeneratePackService.DM_ACS.DM_TOMCAT_HOST_NAME", "BHARGAVI");
            properties.setProperty("com.merittrac.apollo.dx.web.service.GeneratePackService.DM_ACS.DM_TOMCAT_PORT", "8080");
            properties.setProperty("com.merittrac.apollo.dx.web.service.GeneratePackService.DM_ACS.DM_TOMCAT_MODULE", "/DmWeb");
            properties.setProperty("com.merittrac.apollo.dx.web.service.GeneratePackService.DM_ACS.DM_DOWNLOAD_SERVLET", "/MTDownloadServlet?dm");

            properties.setProperty("com.merittrac.apollo.dx.web.jms.server.ProcessPacksToRPS.DM_RPS_QUEUE", "dm_queue");
            properties.setProperty("com.merittrac.apollo.dx.web.jms.server.ProcessPacksToRPS.DM_RPS_EXCHANGE", "integration-exchange");
            properties.setProperty("com.merittrac.apollo.dx.web.jms.server.ProcessPacksToRPS.DM_RPS_USER_NAME", "guest");
            properties.setProperty("com.merittrac.apollo.dx.web.jms.server.ProcessPacksToRPS.DM_RPS_PASSWORD", "guest");
            properties.setProperty("com.merittrac.apollo.dx.web.jms.server.ProcessPacksToRPS.DM_RPS_HOST_NAME", "localhost");
            properties.setProperty("com.merittrac.apollo.dx.web.jms.server.ProcessPacksToRPS.DM_RPS_VIRTUAL_HOST_NAME", "/");
            properties.setProperty("com.merittrac.apollo.dx.web.jms.server.ProcessPacksToRPS.DM_RPS_PORT", "5672");
            properties.setProperty("com.merittrac.apollo.dx.web.jms.server.ProcessPacksToRPS.DM_RPS_URI", "amqp\\://guest\\:guest@172.16.238.161\\:5672/");
            properties.setProperty("com.merittrac.apollo.dx.web.jms.server.ProcessPacksToRPS.DM_RPS_PACKS_TO_RPS", "true");
            properties.setProperty("com.merittrac.apollo.dx.web.jms.server.ProcessPacksToRPS.DM_RPS_RETRY_COUNT", "5");

            properties.store(new FileOutputStream(file.getAbsoluteFile()), "Communication Properties File ");
        } catch (Exception exceptionObject) {
            LOGGER.error(exceptionObject.getMessage());
        }
    }

    /**
     * writePackLevelProp() for pack configuration
     *
     * @param file
     */
    private void writePackLevelProp(File file) {
        try {
            Properties properties = new Properties();
            properties.setProperty("com.merittrac.apollo.dx.web.service.communication.acs.PackageService.DM_ACS.APACK_DOWNLOAD_LEVEL", "EVENT");
            properties.setProperty("com.merittrac.apollo.dx.web.service.communication.acs.PackageService.DM_ACS.BPACK_DOWNLOAD_LEVEL", "EVENT");
            properties.setProperty("com.merittrac.apollo.dx.web.service.communication.acs.PackageService.DM_ACS.QPACK_DOWNLOAD_LEVEL", "BATCH");
            properties.setProperty("com.merittrac.apollo.dx.web.service.communication.acs.PackageService.DM_ACS.MPACK_DOWNLOAD_LEVEL", "EVENT");
            properties.setProperty("com.merittrac.apollo.dx.web.service.communication.acs.PackageService.MIN_BEFORE_DOWNLOAD_TIME", "5");
            properties.setProperty("com.merittrac.apollo.dx.web.service.communication.acs.manualDownload.ManualDownloadPacks.DM_ACS_META_DATA_FILE_NAME", "metaData.json");
            properties.setProperty("com.merittrac.apollo.dx.web.service.communication.acs.manualDownload.ManualDownloadPacks.DM_ACS_MANUAL_DOWNLOAD_FOLDER_NAME", "manualCopy");
            properties.store(new FileOutputStream(file.getAbsoluteFile()), "Pack Level Configuration Properties File ");
        } catch (Exception exceptionObject) {
            LOGGER.error(exceptionObject.getMessage());
        }
    }
}
