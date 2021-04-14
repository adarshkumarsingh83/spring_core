package com.espark.adarsh.service.impl;
import com.espark.adarsh.service.MyBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyBusinessServiceImpl implements MyBusinessService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyBusinessServiceImpl.class);
	private Set setObject;
	
	public MyBusinessServiceImpl() {
		super();		
	}

	public Set getSetObject() {
		return setObject;
	}

	public void setSetObject(Set setObject) {
		this.setObject = setObject;
	}

	public void displaySet() {
		 final Iterator itr = setObject.iterator();
		  while(itr.hasNext()){
              LOGGER.info(" :-> " + itr.next());
		 }
	}

}
