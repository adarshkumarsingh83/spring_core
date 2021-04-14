/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */
package com.adarsh.spring.filesystem.impl;

import com.adarsh.spring.properties.ApplicationProperties;

import java.io.IOException;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 * @see
 */
public interface CreateFileSystem {


    public void inItProperties(ApplicationProperties applicationProperties) throws Exception;

    public void createFileSystem() throws IOException ;

}
