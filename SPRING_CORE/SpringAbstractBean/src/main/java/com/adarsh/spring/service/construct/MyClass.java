package com.adarsh.spring.service.construct;

import java.util.Calendar;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyClass extends AbstractClass {
	
	public MyClass() {
		super();
	}

	public String getWish() {
		final Calendar cl=Calendar.getInstance();
		final int hour=cl.HOUR;
		 String msg=super.getName()+" ";
		if(hour < 12){
			msg += "good morning";
		}else if(hour <16){
			msg+=" good afternoon ";			
		}else{
			msg+=" good evening ";
		}
		return msg;
	}

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
