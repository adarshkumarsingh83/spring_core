package com.adarsh.spring.service.impl;

import com.adarsh.spring.service.MySpringInterface;

import static java.lang.System.out;
import java.util.*;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyBusinessBeanClass implements MySpringInterface {
	
	private String userName;
    private Date date;
    
		public MyBusinessBeanClass() {
			super();
		}

		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public Date getDate() {
			return date;
		}


		public void setDate(Date date) {
			this.date = date;
		}
	
		@SuppressWarnings("static-access")
		private String getWish(){
			Calendar cl=Calendar.getInstance();
			String msg=" ";
			int hour=cl.HOUR;
			if(hour<12){
				msg="GGOD MORINING ";
			}else if(hour<16){
				msg="GOOD AFTERNOON	";
			}else{
				msg="GOOD EVENING ";
			}
			return msg;
		}
	
	public void displayData() {
	     
        out.println("Date is "+this.date+" Nmae is "+this.userName+" "+this.getWish());
	}

}
