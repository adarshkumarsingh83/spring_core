package com.adarsh.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyCustomEvent extends ApplicationEvent {

    public MyCustomEvent(Object source) {
        super(source);
    }

    public String toString(){
        return "My Custom Event Generated ";
    }
}