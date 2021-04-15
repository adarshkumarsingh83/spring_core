package com.adarsh.spring.service;

import lombok.extern.slf4j.Slf4j;

import java.util.*;


/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Slf4j
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
        log.info(":=> " + dateObject);
    }

}
