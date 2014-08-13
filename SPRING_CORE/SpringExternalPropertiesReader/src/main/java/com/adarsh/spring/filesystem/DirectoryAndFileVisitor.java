/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.spring.filesystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This Class is providing custom implementation
 * for set of functionality related to search the file in the
 * application specific file system and its search in the whole
 * file system tree for the file on the basic of hte supplied
 * argument like extension or file name or regular expression .
 */

/**
 * @Author: Adarsh_K
 * @Author: $LastChangeBy Adarsh_K
 * @Version $Revised Date: 9/1/13 Time: 9:26 AM
 * @see java.nio.file.SimpleFileVisitor
 */

public class DirectoryAndFileVisitor extends SimpleFileVisitor {

    private int searchCriteria = 10;
    public static final int SEARCH_FILE_BY_NAME = 10;
    public static final int SEARCH_FILE_BY_EXTENSION = 11;
    public static final int SEARCH_FILE_BY_REGULAR_EXPRESSION = 12;
    public static final int SEARCH_DIRECTORY_BY_NAME = 20;
    public static final int SEARCH_DIRECTORY_BY_REGULAR_EXPRESSION = 21;

    private String fileDesc = null;
    private final List<String> filePathList = new ArrayList<String>();
    private final List<String> dirPathList = new ArrayList<String>();

    public DirectoryAndFileVisitor(final String fileDesc, final int searchCriteria) {
        Objects.requireNonNull(fileDesc);
        Objects.requireNonNull(searchCriteria);
        if (fileDesc != null && fileDesc.trim().length() != 0) {
            this.fileDesc = fileDesc;
            this.searchCriteria = searchCriteria;
        } else {
            throw new RuntimeException("InSufficient Argument Supplied :");
        }

    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes basicFileAttributes)
            throws IOException {
        Objects.requireNonNull(dir);
        Objects.requireNonNull(basicFileAttributes);
        final String currentDirPath = ((Path) dir).toString();
        switch (this.searchCriteria) {
            case SEARCH_DIRECTORY_BY_NAME:
                if (basicFileAttributes.isDirectory()
                        && currentDirPath.contains(fileDesc)) {
                    dirPathList.add(currentDirPath);
                }
                break;

            case SEARCH_DIRECTORY_BY_REGULAR_EXPRESSION:
                if (basicFileAttributes.isDirectory()
                        && currentDirPath.matches(fileDesc)) {
                    dirPathList.add(currentDirPath);
                }
                break;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes basicFileAttributes)
            throws IOException {

        Objects.requireNonNull(file);
        Objects.requireNonNull(basicFileAttributes);
        final String currentFilePath = ((Path) file).toString();

        switch (this.searchCriteria) {
            case SEARCH_FILE_BY_NAME:
                if (currentFilePath.contains(fileDesc)) {
                    filePathList.add(currentFilePath);
                }
                break;
            case SEARCH_FILE_BY_EXTENSION:
                if (currentFilePath.endsWith(fileDesc)) {
                    filePathList.add(currentFilePath);
                }
                break;
            case SEARCH_FILE_BY_REGULAR_EXPRESSION:
                if (currentFilePath.matches(fileDesc)) {
                    filePathList.add(currentFilePath);
                }
                break;

            case SEARCH_DIRECTORY_BY_NAME:
                if (basicFileAttributes.isDirectory()
                        && currentFilePath.contains(fileDesc)) {
                    dirPathList.add(currentFilePath);
                }
                break;

            case SEARCH_DIRECTORY_BY_REGULAR_EXPRESSION:
                if (basicFileAttributes.isDirectory()
                        && currentFilePath.matches(fileDesc)) {
                    dirPathList.add(currentFilePath);
                }
                break;
        }
        return FileVisitResult.CONTINUE;
    }

    public List<String> getFilePathList() {
        return filePathList;
    }

    public List<String> getDirPathList() {
        return dirPathList;
    }
}
