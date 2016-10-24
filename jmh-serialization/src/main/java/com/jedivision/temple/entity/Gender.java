package com.jedivision.temple.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE("male"), FEMALE("female");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @JsonValue
    public String getGender() {
        return gender;
    }
}
