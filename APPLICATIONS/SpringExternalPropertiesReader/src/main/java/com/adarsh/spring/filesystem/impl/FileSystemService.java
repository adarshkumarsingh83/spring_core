/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */
package com.adarsh.spring.filesystem.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * * This file is providing specification
 * for set of services related to application
 * specific file system. it offers set of method to
 * get the files and directory in the file system.
 */

/**
 * @Author: Adarsh_K
 * @Author: $LastChangeBy Adarsh_K
 * @Version $Revised Date: 8/1/13 Time: 2:02 PM
 */
public interface FileSystemService {

    /**
     * getRootFileSystem() is providing the specification
     * for getting the root of the file system in the from
     * of the instance of the java.io.DataFile containing the
     * reference of the root.
     *
     * @return instance of the java.io.DataFile referencing to
     *         the file system root directory.
     */
    public File getRootFileSystem();

    /**
     * getFileSystem() provide the specification for
     * getting the application specific file system
     * which is default created at the time of the
     * application startup.
     *
     * @return instance of the java.io.DataFile referencing
     *         to the default file system root directory.
     * @throws java.io.IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getFileSystem() throws IOException;

    /**
     * getTempDirectory() provide the specification for
     * getting the temporary directory in the application
     * specific file system and return the reference in the
     * instance of the java.io.DataFile.
     *
     * @return instance of the java.io.DataFile containing reference
     *         of the temp directory in the application file system.
     * @throws java.io.IOException IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getTempDirectory() throws IOException;

    /**
     * getSqlDirectory() provide the specification for
     * getting the sql directory in the application
     * specific file system and return the reference in the
     * instance of the java.io.File.
     *
     * @return instance of the java.io.File containing reference
     *         of the sql directory in the application file system.
     * @throws java.io.IOException IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getSqlDirectory() throws IOException;


    /**
     * getDownloadDirectory() provide the specification for
     * getting the download directory in the application
     * specific file system and return the reference in the
     * instance of the java.io.DataFile.
     *
     * @return instance of the java.io.DataFile containing reference
     *         of the temp directory in the application file system.
     * @throws java.io.IOException IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getDownloadDirectory() throws IOException;


    /**
     * getUploadDirectory() provide the specification for
     * getting the upload directory in the application
     * specific file system and return the reference in the
     * instance of the java.io.DataFile.
     *
     * @return instance of the java.io.DataFile containing reference
     *         of the temp directory in the application file system.
     * @throws java.io.IOException IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getUploadDirectory() throws IOException;


    /**
     * getDirectory() provide the specification for getting
     * the specified directory in the application filesystem
     * and it return the reference of that directory in the
     * instance of the java.io.DataFile.
     *
     * @param childPath accept the instance of java.lang.String
     *                  containing the path of the directory of
     *                  the child directory for the application
     *                  root directory.
     * @return
     * @throws java.io.IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getDirectory(String childPath) throws IOException;

    /**
     * getDirectory() provide the specification for getting
     * the specified directory in the application specific
     * filesystem and we can create the directory if its not
     * exists in the filesystem on the basic of the crate flag.
     *
     * @param childPath accept the instance of the java.lang.String
     *                  containing the sub directory path in the
     *                  application filesystem.
     * @param create    accept the instance of the java.lang.Boolean
     *                  containing the information about the creation
     *                  of the directory inside the filesystem or not.
     * @return instance of the java.io.DataFile reference's the specified
     *         directory in the application filesystem.
     * @throws java.io.IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getDirectory(String childPath, boolean create)
            throws IOException;


    /**
     * getDirectory() provide the specification for getting
     * the specified directory in the application specific
     * filesystem and we can create the directory if its not
     * exists in the filesystem on the basic of the crate flag
     * and by verify flag will ensuring the accessibility on the
     * directory like existence of the file then followed by
     * read & write permission on the directory.
     *
     * @param childPath accept the instance of the java.lang.String
     *                  containing the sub directory path in the
     *                  application filesystem.
     * @param create    accept the instance of the java.lang.Boolean
     *                  containing the information about the creation
     *                  of the directory inside the filesystem or not.
     * @param verify    accept the instance of the java.lang.Boolean
     *                  containing the information about the access
     *                  permission to be checked or not.
     * @return instance of the java.io.DataFile reference's the specified
     *         directory in the application filesystem.
     * @throws java.io.IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getDirectory(String childPath, boolean create, boolean verify)
            throws IOException;

    /**
     * getDirectory() provide the specification for getting
     * the specified directory in the application specific
     * filesystem and we can create the directory if its not
     * exists in the filesystem on the basic of the crate flag
     * and by verify flag will ensuring the accessibility on the
     * directory like existence of the file then followed by
     * read & write permission on the directory.
     *
     * @param parentPath    accept the instance of the java.lang.String
     *                      containing the sub directory path in the
     *                      application filesystem.
     * @param directoryName accept the instance of the java.lang.String
     *                      containing the directory Name
     * @param create        accept the instance of the java.lang.Boolean
     *                      containing the information about the creation
     *                      of the directory inside the filesystem or not.
     * @return instance of the java.io.DataFile reference's the specified
     *         directory in the application filesystem.
     * @throws java.io.IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getDirectory(String parentPath, String directoryName, boolean create) throws IOException;

    /**
     * getDirectory() provide the specification for getting
     * the specified directory in the application specific
     * filesystem and we can create the directory if its not
     * exists in the filesystem on the basic of the crate flag
     * and by verify flag will ensuring the accessibility on the
     * directory like existence of the file then followed by
     * read & write permission on the directory.
     *
     * @param parentDir    accept the instance of the java.lang.String
     *                     containing the parent directory path in the
     *                     application filesystem.
     * @param childDirName accept the instance of the java.lang.String
     *                     containing the child directory Name
     * @param create       accept the instance of the java.lang.Boolean
     *                     containing the information about the creation
     *                     of the directory inside the filesystem or not
     * @param verify       accept the instance of the java.lang.Boolean
     *                     containing the information about the access
     *                     permission to be checked or not.
     * @return instance of the java.io.DataFile reference's the specified
     *         directory in the application filesystem.
     * @throws java.io.IOException
     */
    public File getDirectory(String parentDir, String childDirName, boolean create, boolean verify)
            throws IOException;

    /**
     * getFile() provide the specification for getting the
     * file from the application filesystem on the basic of
     * the child path supplied to the method .
     *
     * @param childPath accept the instance of the java.lang.String
     *                  containing the path of the file in side the
     *                  application filesystem.
     * @return instance of the java.io.DataFile reference's the specified
     *         directory in the application filesystem if file is not
     *         exists then this won't create the new file with the
     *         specified path and filename and it will return null.
     * @throws java.io.IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getFile(String childPath)
            throws IOException;

    /**
     * getFile() provide the specification for the getting the
     * file form the application filesystem on the basic of the
     * child path supplied to the method we can create the file
     * if not exists on the basic of the
     *
     * @param childPath accept the instance of the java.lang.String
     *                  containing the path of the file in side the
     *                  application filesystem.
     * @param create    accept the instance of the java.lang.Boolean
     *                  containing the information about the creation
     *                  of the file instance inside the filesystem or not.
     * @param verify    accept the instance of the java.lang.Boolean
     *                  containing the information about the access
     *                  permission to be checked or not.
     * @return instance of the java.io.DataFile reference's the specified
     *         file in the application filesystem.
     * @throws java.io.IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getFile(String childPath, boolean create, boolean verify)
            throws IOException;

    /**
     * getFile() provide the specification for the getting the
     * file form the application filesystem on the basic of the
     * parent path & file Name supplied to the method we can create the file
     * if not exists on the basic of the
     *
     * @param parentPath accept the instance of the java.lang.String
     *                   containing the parent dir path for the file in side the
     *                   application filesystem.
     * @param fileName   accept the instance of the java.lang.String containing the file
     *                   name for the file
     * @param create     accept the instance of the java.lang.Boolean
     *                   containing the information about the creation
     *                   of the file instance inside the filesystem or not.
     * @param verify     accept the instance of the java.lang.Boolean
     *                   containing the information about the access
     *                   permission to be checked or not.
     * @return instance of the java.io.DataFile reference's the specified
     *         file in the application filesystem.
     * @throws java.io.IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getFile(String parentPath, String fileName, boolean create, boolean verify)
            throws IOException;

    /**
     * getFile() provide the specification for the getting the file
     * form the application filesystem on the basic of the
     * child path supplied to the method we can create the file
     * if not exists on the basic of the create flag we can verify
     * the access privilege on the file like file exists ,read and write
     * permission on the basic of verify flag and we can specify the
     * parent directory for creating the new file if file is not
     * found in the application filesystem.
     *
     * @param childPath   accept the instance of the java.lang.String
     *                    containing the path of the file in side the
     *                    application filesystem.
     * @param isDirectory accept the instance of the java.lang.Boolean
     *                    containing the information about the cration
     *                    of the parent directory for specified file
     *                    path in case file is not existing.
     * @param create      accept the instance of the java.lang.Boolean
     *                    containing the information about the creation
     *                    of the file instance inside the filesystem or not.
     * @param verify      accept the instance of the java.lang.Boolean
     *                    containing the information about the access
     *                    permission to be checked or not.
     * @return instance of the java.io.DataFile reference's the specified
     *         file in the application filesystem.
     * @throws java.io.IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getFile(String childPath, boolean isDirectory, boolean create, boolean verify)
            throws IOException;

    /**
     * getFile() provide the specification for the getting the
     * file from the application filesystem based on the child path
     * it can crate the file if not exists by enabling the create flag
     * if file is not available in application filesystem then it can
     * create the file with the specified parent file. and verify the
     * access permission by enabling flag and we can specify the directory
     * where file need to be searched in the application file system.
     *
     * @param parent      accept the instance of the java.io.DataFile
     *                    referencing the parent directory for the file
     * @param childPath   accept the instance of the java.lang.String
     *                    containing the path of the file in side the
     *                    application filesystem.
     * @param isDirectory accept the instance of the java.lang.Boolean
     *                    containing the information about the cration
     *                    of the parent directory for specified file
     *                    path in case file is not existing.
     * @param create      accept the instance of the java.lang.Boolean
     *                    containing the information about the creation
     *                    of the file instance inside the filesystem or not.
     * @param verify      accept the instance of the java.lang.Boolean
     *                    containing the information about the access
     *                    permission to be checked or not.
     * @return instance of the java.io.DataFile reference's the specified
     *         file in the application filesystem.
     * @throws java.io.IOException when any abnormal condition
     *                             encounter in execution of the application.
     */
    public File getFile(File parent, String childPath, boolean isDirectory, boolean create, boolean verify)
            throws IOException;

    /**
     * verifyAccessToFile() provide the specification for checking
     * the access permission on the supplied instance of the
     * java.io.DataFile it check for existence of the specified
     * file in the application filesystem and also checks for
     * read and write permission on the file.
     *
     * @param file accept the instance of the jav.io.DataFile
     *             referencing the file in the application
     *             filesystem.
     * @return instance of the java.io.DataFile which is having
     *         read and write permission.
     * @throws java.io.IOException in case when the supplied instance
     *                             of the java.io.DataFile is not having
     *                             permission or read & write and its
     *                             also check for the file existence
     *                             in the application filesystem.
     */
    public File verifyAccessToFile(File file) throws IOException;


    /**************** Native IO based Operation on the Application DataFile System ****************/

    /**
     * getFileByExtension() provide the functionality for the
     * getting the file on the basic of the file extension supplied
     * in the form of jav.lang.String instance containing file extension
     * it internally usages the java.nio package and traverse the whole
     * application file system and return the path of the files which is
     * having the same extension of the file.
     *
     * @param fileExt accept the instance of the java.lang.String
     *                containing the file extension for searching in
     *                the application file system.
     * @return instance of the java.util.List containing the absolute
     *         file path in the form fo the String which are matched
     *         with the supplied file extension.
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public List<String> getFileByExtension(final String fileExt)
            throws Exception;

    /**
     * getFileByExtension() provide the functionality for the
     * getting the file on the basic of the file extension supplied
     * in the form of jav.lang.String instance containing file extension
     * it internally usages the java.nio package and traverse the whole
     * application file system and return the path of the files which is
     * having the same extension of the file.
     *
     * @param directory accept the instance of the java.lang.String
     *                  containing the directory path where to search file
     * @param fileExt   accept the instance of the java.lang.String
     *                  containing the file extension for searching in
     *                  the application file system.
     * @return instance of the java.util.List containing the absolute
     *         file path in the form fo the String which are matched
     *         with the supplied file extension.
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public List<String> getFileByExtension(final String directory, final String fileExt)
            throws Exception;

    /**
     * getFileByName() provide the functionality for the
     * getting the file on the basic of the file fileName supplied
     * in the form of jav.lang.String instance containing file name
     * it internally usages the java.nio package and traverse the whole
     * application file system and return the path of the files which is
     * having the same name of the file.
     *
     * @param fileName accept the instance of the java.lang.String
     *                 containing the file name for searching in
     *                 the application file system.
     * @return instance of the java.util.List containing the absolute
     *         file path in the form fo the String which are matched
     *         with the supplied file name.
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public List<String> getFileByName(final String fileName)
            throws Exception;


    /**
     * getFileByName() provide the functionality for the
     * getting the file on the basic of the file fileName supplied
     * in the form of jav.lang.String instance containing file name
     * it internally usages the java.nio package and traverse the whole
     * application file system and return the path of the files which is
     * having the same name of the file.
     *
     * @param directory accept the instance of the java.lang.String
     *                  containing the directory path where to search file
     * @param fileName  accept the instance of the java.lang.String
     *                  containing the file name for searching in
     *                  the application file system.
     * @return instance of the java.util.List containing the absolute
     *         file path in the form fo the String which are matched
     *         with the supplied file name.
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public List<String> getFileByName(final String directory, final String fileName)
            throws Exception;

    /**
     * getFileByRegEx() provide the functionality for the
     * getting the file on the basic of the regular expression supplied
     * in the form of jav.lang.String instance containing regular expression
     * it internally usages the java.nio package and traverse the whole
     * application file system and return the path of the files which is
     * having the similar to the pattern supplied .
     *
     * @param regExp accept the instance of the java.lang.String
     *               containing the regular expression for searching in
     *               the application file system.
     * @return instance of the java.util.List containing the absolute
     *         file path in the form fo the String which are matched
     *         with the supplied regular expression pattern of the
     *         regular expression.
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public List<String> getFileByRegEx(final String regExp)
            throws Exception;


    /**
     * getFileByRegEx() provide the functionality for the
     * getting the file on the basic of the regular expression supplied
     * in the form of jav.lang.String instance containing regular expression
     * it internally usages the java.nio package and traverse the whole
     * application file system and return the path of the files which is
     * having the similar to the pattern supplied
     *
     * @param directory accept the instance of the java.lang.String
     *                  containing the directory path where to search file
     * @param regExp    accept the instance of the java.lang.String
     *                  containing the regular expression for searching in
     *                  the application file system.
     * @return instance of the java.util.List containing the absolute
     *         file path in the form fo the String which are matched
     *         with the supplied regular expression pattern of the
     *         regular expression.
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public List<String> getFileByRegEx(final String directory, final String regExp)
            throws Exception;

    /**
     * getDirByName() provide the functionality for the
     * getting the dir on the basic of the file dirName supplied
     * in the form of jav.lang.String instance containing dir name
     * it internally usages the java.nio package and traverse the whole
     * application file system and return the path of the dir which is
     * having the same name of the dir.
     *
     * @param dirName accept the instance of the java.lang.String
     *                containing the dir name for searching in
     *                the application file system.
     * @return instance of the java.util.List containing the absolute
     *         dir path in the form fo the String which are matched
     *         with the supplied dir name.
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public List<String> getDirByName(final String dirName)
            throws Exception;


    /**
     * getDirByName() provide the functionality for the
     * getting the dir on the basic of the file dirName supplied
     * in the form of jav.lang.String instance containing dir name
     * it internally usages the java.nio package and traverse the whole
     * application file system and return the path of the dir which is
     * having the same name of the dir.
     *
     * @param directory accept the instance of the java.lang.String
     *                  containing the directory path where to search file
     * @param dirName   accept the instance of the java.lang.String
     *                  containing the dir name for searching in
     *                  the application file system.
     * @return instance of the java.util.List containing the absolute
     *         dir path in the form fo the String which are matched
     *         with the supplied dir name.
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public List<String> getDirByName(final String directory, final String dirName)
            throws Exception;

    /**
     * getDirByRegExp() provide the functionality for the
     * getting the dir on the basic of the regular expression supplied
     * in the form of jav.lang.String instance containing regular expression
     * it internally usages the java.nio package and traverse the whole
     * application file system and return the path of the dir which is
     * having the similar to the pattern supplied .
     *
     * @param regExp accept the instance of the java.lang.String
     *               containing the regular expression for searching in
     *               the application file system.
     * @return instance of the java.util.List containing the absolute
     *         dir path in the form fo the String which are matched
     *         with the supplied pattern of regular expression .
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public List<String> getDirByRegExp(final String regExp)
            throws Exception;


    /**
     * getDirByRegExp() provide the functionality for the
     * getting the dir on the basic of the regular expression supplied
     * in the form of jav.lang.String instance containing regular expression
     * it internally usages the java.nio package and traverse the whole
     * application file system and return the path of the dir which is
     * having the similar to the pattern supplied .
     *
     * @param directory accept the instance of the java.lang.String
     *                  containing the directory path where to search file.
     * @param regExp    accept the instance of the java.lang.String
     *                  containing the regular expression for searching in
     *                  the application file system.
     * @return instance of the java.util.List containing the absolute
     *         dir path in the form fo the String which are matched
     *         with the supplied pattern of regular expression .
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public List<String> getDirByRegExp(final String directory, final String regExp)
            throws Exception;

    /**
     * deleteFile() provide the functionality for the deletion of the file
     * by passing the file name with the path of the file .
     *
     * @param file accept the instance of the java.lang.String
     *             containing the file name and path where to delete file.
     * @return instance of the java.lang.Boolean containing the status of the
     *         deletion of the operation .
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public boolean deleteFile(final String file) throws Exception;

    /**
     * deleteFile() provide the functionality for the deletion of the file
     * by passing the file name with the parent path of the file
     *
     * @param parentDir accept the instance of the java.lang.String
     *                  containing the parent dir path
     * @param file      accept the instance of the java.lang.String
     *                  containing the file name and path where to delete file.
     * @return instance of the java.lang.Boolean containing the status of the
     *         deletion of the operation .
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application.
     */
    public boolean deleteFile(final String parentDir, final String file) throws Exception;

    /**
     * deleteDirectory() provide the functionality for the deletion of the dir
     * by passing the dir name with the path.
     *
     * @param directory accept the instance of the java.lang.String
     *             containing the dir name and path where to delete file.
     * @return instance of the java.lang.Boolean containing the status of the
     *         deletion of the operation
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application
     */
    public boolean deleteDirectory(final String directory) throws Exception;

    /**
     * deleteDirectory() provide the functionality for the deletion of the dir
     * by passing the dir name with the path.
     *
     * @param parentDir accept the instance of the java.lang.String
     *                  containing the parent dir path
     * @param directory      accept the instance of the java.lang.String
     *                  containing the dir name and path where to delete file
     * @return instance of the java.lang.Boolean containing the status of the
     *         deletion of the operation
     * @throws Exception instance when any abnormal state rise in the
     *                   during the execution of the application
     */
    public boolean deleteDirectory(final String parentDir, final String directory) throws Exception;

}
