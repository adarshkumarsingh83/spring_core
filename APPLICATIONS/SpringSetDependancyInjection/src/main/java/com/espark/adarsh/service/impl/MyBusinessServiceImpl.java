package com.espark.adarsh.service.impl;

import com.espark.adarsh.service.MyBusinessService;
import lombok.extern.slf4j.Slf4j;
import java.util.*;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
public class MyBusinessServiceImpl implements MyBusinessService {

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
              log.info(" :-> " + itr.next());
		 }
	}

}
