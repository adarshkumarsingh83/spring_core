package com.adarsh.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface MySpringBean {

    public static final Logger LOGGER = LoggerFactory.getLogger(MySpringBean.class);

    public String getFirstName();

    public void setFirstName(String firstName);

    public void showValues();
}
