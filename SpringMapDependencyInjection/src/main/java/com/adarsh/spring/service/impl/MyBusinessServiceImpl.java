package com.adarsh.spring.service.impl;

import com.adarsh.spring.service.MyBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.out;

import java.util.*;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyBusinessServiceImpl implements MyBusinessService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyBusinessServiceImpl.class);
    private Map mapObject;

    public MyBusinessServiceImpl() {
        super();
    }

    public Map getMapObject() {
        return mapObject;
    }

    public void setMapObject(Map mapObject) {
        this.mapObject = mapObject;
    }

    public void displayMap() {
        HashMap hashMap = (HashMap) mapObject;
        Set setObject = hashMap.entrySet();
        Iterator itr = setObject.iterator();
        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();
            LOGGER.info(":=> "+mapEntry.getKey().toString() + " -> " + mapEntry.getValue().toString());
        }
    }


}
