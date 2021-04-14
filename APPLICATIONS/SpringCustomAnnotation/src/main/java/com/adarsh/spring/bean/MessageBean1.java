/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.spring.bean;
/*
 * {@inheritDoc}
*/

/**
 * @Product : MessageBean1 provide implementation of the specification
 *                    provided for the ...    
 */


import com.adarsh.spring.annotation.ApplicationBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 12/6/13 1:00 PM
 * @see
 */
@ApplicationBean(name = "messageBean1")
public class MessageBean1 implements MessageBean{

    public MessageBean1() {
    }

    @Value("${messageBean1}")
    private String msgData;

    public String getMsgData() {
        return msgData;
    }

    public void setMsgData(String msgData) {
        this.msgData = msgData;
    }
}
