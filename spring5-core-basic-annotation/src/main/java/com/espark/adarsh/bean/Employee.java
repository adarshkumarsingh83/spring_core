package com.espark.adarsh.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {

    Integer id;
    String name;
    String email;

}
