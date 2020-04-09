package com.adarsh.spring.bean;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class Message {

    private String message1;
    private String message2;

    public void setMessage1(String message){
        this.message1  = message;
    }

    public void setMessage2(String message){
        this.message2  = message;
    }

    public void getMessage1(){
        System.out.println("World Message1 : " + message1);
    }

    public void getMessage2(){
        System.out.println("World Message2 : " + message2);
    }
}
