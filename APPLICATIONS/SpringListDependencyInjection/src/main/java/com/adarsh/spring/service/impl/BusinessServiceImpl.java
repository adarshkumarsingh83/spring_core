package com.adarsh.spring.service.impl;

import com.adarsh.spring.service.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class BusinessServiceImpl implements BusinessService {

    public static final Logger LOGGER = LoggerFactory.getLogger(BusinessServiceImpl.class);

    public List<String> listObject;

    public BusinessServiceImpl() {
        super();
    }

    public List<String> getListObject() {
        return listObject;
    }

    public void setListObject(List<String> listObject) {
        this.listObject = listObject;
    }

    public void displayList() {
        Iterator itr = listObject.iterator();
        while (itr.hasNext()) {
            LOGGER.info(":=> " + itr.next().toString());
        }
    }
}
