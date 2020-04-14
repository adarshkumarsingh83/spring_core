/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.spring.service;
/**
 *@Product: MyService provides the specification for ..
 */


import java.util.Map;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 12/6/13 1:02 PM
 * @see
 */

public interface MyService {

    public String getMsgText();

    public Map<Object, Object> getBeanObjects();

    public void setBeanObjects(String key, Object bean);

    public void setBeanObjects(Map<String, Object> beanObjects);
}
