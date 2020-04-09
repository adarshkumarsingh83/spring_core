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

    public static final Logger LOGGER = LoggerFactory.getLogger(MyBusinessServiceImpl.class);

 private Date dateObject;	
	
	public MyBusinessServiceImpl(Date dateObject) {
	super();
	this.dateObject = dateObject;
}

	public MyBusinessServiceImpl() {
		super();
	}

	public void displayData() {
        LOGGER.info(":=> "+dateObject);
	}

}
