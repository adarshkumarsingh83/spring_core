package com.adarsh.spring.service.impl;

import com.adarsh.spring.service.MyBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static java.lang.System.out;

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

    public void displayData() {
        log.info(" :-> " + dateObject);
    }

}
