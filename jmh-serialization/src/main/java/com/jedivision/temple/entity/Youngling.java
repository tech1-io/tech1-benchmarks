package com.jedivision.temple.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Youngling implements Serializable {
    private long id;
    private boolean active;
    private int age;
    private String name;
    private Gender gender;
    private String email;
    private String phone;
}
