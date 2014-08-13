package com.adarsh.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface MyService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyService.class);

    public void getMessage();

    public void setMessage(String message);

}
