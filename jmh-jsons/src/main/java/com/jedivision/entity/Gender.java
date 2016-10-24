package com.jedivision.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

public enum Gender {
    @SerializedName("male")
    MALE("male"),

    @SerializedName("female")
    FEMALE("female");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @JsonValue
    public String getGender() {
        return gender;
    }
}
