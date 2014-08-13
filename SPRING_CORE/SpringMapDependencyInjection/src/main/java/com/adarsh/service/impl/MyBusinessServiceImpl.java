package com.adarsh.service.impl;

import com.adarsh.service.MyBusinessService;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBusinessServiceImpl.class);
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
        final HashMap hashMap = (HashMap) mapObject;
        final Set setObject = hashMap.entrySet();
        final Iterator itr = setObject.iterator();
        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();
            LOGGER.info(mapEntry.getKey().toString() + " -> " + mapEntry.getValue().toString());
        }
    }

}
