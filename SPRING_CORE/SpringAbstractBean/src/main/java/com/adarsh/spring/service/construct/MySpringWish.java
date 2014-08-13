package com.adarsh.spring.service.construct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface MySpringWish {

    public static final Logger LOGGER = LoggerFactory.getLogger(MySpringWish.class);

  public String getWish();
}
