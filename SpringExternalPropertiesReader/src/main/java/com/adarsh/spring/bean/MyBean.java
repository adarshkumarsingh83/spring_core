package com.adarsh.spring.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh_K
 * Date: 17/10/13
 * Time: 6:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyBean {

    String name1;
    String name2;
    String name3;
    String name4;

    public MyBean() {
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                ", name4='" + name4 + '\'' +
                '}';
    }
}
