/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */
package com.adarsh.spring.filesystem.impl;

/*
 * {@inheritDoc}
 */


import com.adarsh.spring.filesystem.DirectoryAndFileVisitor;
import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @Author: Adarsh_K
 * @Author: $LastChangeBy Adarsh_K
 * @Version $Revised Date: 8/1/13 Time: 2:02 PM
 * @Product This file is providing implementation
 * for set of functionality related to.
 * @see FileSystemService
 */
@Scope(value = "singleton")
@Service("fileSystemServiceImpl")
public class FileSystemServiceImpl implements FileSystemService {

    private final static Logger logger = LoggerFactory.getLogger(FileSystemServiceImpl.class);
    private static final FileSystem local = FileSystems.getDefault();
    private static FileSystemService defaultFileSystemService = null;
    private String defaultFileSystemPath = null;
    private File defaultFileRoot = null;
    private Path path = null;

    static {
        try {
            String apolloHome = System.getenv().get("apollo_home".toUpperCase());
            if (apolloHome == null) {
                apolloHome = System.getenv().get("apollo_home");
            }
            if (apolloHome == null || apolloHome.trim().length() == 0) {
                File[] roots = File.listRoots();
                File tempDrive = null;
                long tempSize = 0;
                for (File drive : roots) {
                    if (drive.exists() && drive.canWrite()) {
                        long diskSize = new File(drive.getPath()).getFreeSpace();
                        if (tempSize < diskSize) {
                            tempSize = diskSize;
                            tempDrive = drive;
                        }
                    }
                }
                apolloHome = tempDrive + File.separator + "apollo_home";
            }
            defaultFileSystemService = new FileSystemServiceImpl(apolloHome);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public FileSystemServiceImpl() throws Exception {
        logger.info(this.getClass().getName() + " constructed ");
    }

    public FileSystemServiceImpl(final String defaultFileSystemPath) throws IOException {
        this.defaultFileSystemPath = defaultFileSystemPath;
        defaultFileRoot = this.getFile(null, defaultFileSystemPath, true, true, true);
        path = local.getPath(defaultFileRoot.getAbsolutePath()+File.separator+"dx");
        defaultFileSystemService = this;
    }

    /**
     * getDefaultInstance() provide the functionality for
     * getting the default instance of the FileSystemService
     * which is having default file system location
     *
     * @return instance of the FileSystemService having the default
     *         instance created at the time of the class loading.
     */
    public static FileSystemService getDefaultInstance() {
        return defaultFileSystemService;
    }

    public void setDefaultFileSystemPath(String defaultFileSystemPath) {
        this.defaultFileSystemPath = defaultFileSystemPath;
    }

    @Override
    public File getRootFileSystem() {
        return defaultFileRoot;
    }

    public File getFileSystem()
            throws IOException {
        return verifyAccessToFile(new File(getFileSystemAsString()));
    }

    @Override
    public File getTempDirectory()
            throws IOException {
        File file = null;
        try {
            String t = defaultFileSystemService.getDirByName("temp").get(0);
            file = new File(t);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return file;
    }

    @Override
    public File getDirectory(String childPath)
            throws IOException {
        return getFile(childPath, true, false, true);
    }

    @Override
    public File getDownloadDirectory() throws IOException {
        File file = null;
        try {
            String t = defaultFileSystemService.getDirByName("download").get(0);
            file = new File(t);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return file;
    }

    @Override
    public File getSqlDirectory() throws IOException {
        File file = null;
        try {
            String t = defaultFileSystemService.getDirByName("sql").get(0);
            file = new File(t);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return file;
    }

    @Override
    public File getUploadDirectory() throws IOException {
        File file = null;
        try {
            String t = defaultFileSystemService.getDirByName("upload").get(0);
            file = new File(t);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return file;
    }

    @Override
    public File getDirectory(String childPath, boolean create)
            throws IOException {
        return getFile(childPath, true, create, true);
    }

    @Override
    public File getDirectory(String parentPath, String directoryName, boolean create)
            throws IOException {
        return getFile(this.getFile(parentPath).getAbsolutePath() + File.separator + directoryName, true, create, true);
    }

    @Override
    public File getDirectory(String childPath, boolean create, boolean verify)
            throws IOException {
        return getFile(childPath, true, create, verify);
    }

    public File getDirectory(String parentDir, String childDirName, boolean create, boolean verify)
            throws IOException {
        return getFile(parentDir + File.separator + childDirName, true, create, verify);
    }

    @Override
    public File getFile(String childPath)
            throws IOException {
        return getFile(childPath, false, false, true);
    }

    @Override
    public File getFile(String childPath, boolean create, boolean verify)
            throws IOException {
        return getFile(childPath, false, create, verify);
    }

    @Override
    public File getFile(String parentPath, String fileName, boolean create, boolean verify)
            throws IOException {
        return getFile(getFile(parentPath), fileName, false, create, verify);
    }


    @Override
    public File getFile(String childPath, boolean isDirectory, boolean create, boolean verify)
            throws IOException {
        return getFile(getFileSystem(), childPath, isDirectory, create, verify);
    }

    @Override
    public File getFile(File parent, String childPath, boolean isDirectory, boolean create, boolean verify)
            throws IOException {
        File file;
        if (parent != null) {
            file = new File(parent, FilenameUtils.normalize(childPath));
        } else {
            file = new File(FilenameUtils.normalize(childPath));
        }
        if (create) {
            if (!file.exists()) {
                if (isDirectory) {
                    file.mkdirs();
                } else {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
            }
        }
        if (verify) {
            return verifyAccessToFile(file);
        }
        return file;
    }

    @Override
    public File verifyAccessToFile(File file) throws IOException {
        if (!file.exists()) {
            throw new IOException("Unable to access filesystem :=" + file.getPath());
        }
        if (!file.canRead()) {
            throw new IOException("Unable to read filesystem :=" + file.getPath());
        }
        if (!file.canWrite()) {
            throw new IOException("Unable to write filesystem :=" + file.getPath());
        }
        return file;
    }

    public String getFileSystemAsString() {
        return this.getRootFileSystem().getAbsolutePath();
    }


    @Override
    public boolean deleteFile(String file) throws Exception {
        try {
            FileDeleteStrategy.FORCE.delete(new File(file));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteFile(String parentDir, String file) throws Exception {
        try {
            FileDeleteStrategy.FORCE.delete(new File(parentDir + File.separator + file));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteDirectory(String directory) throws Exception {
        try {
            FileDeleteStrategy.FORCE.delete(new File(directory));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteDirectory(String parentDir, String directory) throws Exception {
        try {
            FileDeleteStrategy.FORCE.delete(new File(parentDir + File.separator + directory));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<String> getFileByExtension(final String fileExt) throws Exception {
        final DirectoryAndFileVisitor fileVisitor =
                new DirectoryAndFileVisitor(fileExt
                        , DirectoryAndFileVisitor.SEARCH_FILE_BY_EXTENSION);
        Files.walkFileTree(path, fileVisitor);
        return fileVisitor.getFilePathList();
    }

    @Override
    public List<String> getFileByExtension(final String directory, final String fileExt) throws Exception {
        final DirectoryAndFileVisitor fileVisitor =
                new DirectoryAndFileVisitor(fileExt
                        , DirectoryAndFileVisitor.SEARCH_FILE_BY_EXTENSION);
        Files.walkFileTree(local.getPath(directory), fileVisitor);
        return fileVisitor.getFilePathList();
    }


    @Override
    public List<String> getFileByName(final String fileName) throws Exception {
        final DirectoryAndFileVisitor fileVisitor =
                new DirectoryAndFileVisitor(fileName
                        , DirectoryAndFileVisitor.SEARCH_FILE_BY_NAME);
        Files.walkFileTree(path, fileVisitor);
        return fileVisitor.getFilePathList();
    }

    @Override
    public List<String> getFileByName(final String directory, final String fileName) throws Exception {
        final DirectoryAndFileVisitor fileVisitor =
                new DirectoryAndFileVisitor(fileName
                        , DirectoryAndFileVisitor.SEARCH_FILE_BY_NAME);
        Files.walkFileTree(local.getPath(directory), fileVisitor);
        return fileVisitor.getFilePathList();
    }

    @Override
    public List<String> getFileByRegEx(final String regExp) throws Exception {
        final DirectoryAndFileVisitor fileVisitor =
                new DirectoryAndFileVisitor(regExp
                        , DirectoryAndFileVisitor.SEARCH_FILE_BY_REGULAR_EXPRESSION);
        Files.walkFileTree(path, fileVisitor);
        return fileVisitor.getFilePathList();
    }

    @Override
    public List<String> getFileByRegEx(final String directory, final String regExp) throws Exception {
        final DirectoryAndFileVisitor fileVisitor =
                new DirectoryAndFileVisitor(regExp
                        , DirectoryAndFileVisitor.SEARCH_FILE_BY_REGULAR_EXPRESSION);
        Files.walkFileTree(local.getPath(directory), fileVisitor);
        return fileVisitor.getFilePathList();
    }


    @Override
    public List<String> getDirByName(final String dirName) throws Exception {
        final DirectoryAndFileVisitor fileVisitor =
                new DirectoryAndFileVisitor(dirName
                        , DirectoryAndFileVisitor.SEARCH_DIRECTORY_BY_NAME);
        Files.walkFileTree(path, fileVisitor);
        return fileVisitor.getDirPathList();
    }

    @Override
    public List<String> getDirByName(final String directory, final String dirName) throws Exception {
        final DirectoryAndFileVisitor fileVisitor =
                new DirectoryAndFileVisitor(dirName
                        , DirectoryAndFileVisitor.SEARCH_DIRECTORY_BY_NAME);
        Files.walkFileTree(local.getPath(directory), fileVisitor);
        return fileVisitor.getDirPathList();
    }


    @Override
    public List<String> getDirByRegExp(final String regExp) throws Exception {
        final DirectoryAndFileVisitor fileVisitor =
                new DirectoryAndFileVisitor(regExp
                        , DirectoryAndFileVisitor.SEARCH_DIRECTORY_BY_REGULAR_EXPRESSION);
        Files.walkFileTree(path, fileVisitor);
        return fileVisitor.getDirPathList();
    }

    @Override
    public List<String> getDirByRegExp(final String directory, final String regExp) throws Exception {
        final DirectoryAndFileVisitor fileVisitor =
                new DirectoryAndFileVisitor(regExp
                        , DirectoryAndFileVisitor.SEARCH_DIRECTORY_BY_REGULAR_EXPRESSION);
        Files.walkFileTree(local.getPath(directory), fileVisitor);
        return fileVisitor.getDirPathList();
    }
}
