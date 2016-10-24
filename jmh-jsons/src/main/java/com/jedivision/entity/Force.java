package com.jedivision.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Force implements Serializable {
    private long id;
    private String title;
    private Date started;
    private List<String> areas;
    private String description;
}
