package com.adarsh.spring.service;
import java.util.*;

import static java.lang.System.out;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyBusinessServiceImpl implements MyBusinessService {

 private Date dateObject;	
	
	public MyBusinessServiceImpl(Date dateObject) {
	super();
	this.dateObject = dateObject;
}

	public MyBusinessServiceImpl() {
		super();
	}

	public void displayData() {
        out.print(dateObject);
	}

}
