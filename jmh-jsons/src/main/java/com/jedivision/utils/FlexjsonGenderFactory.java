package com.jedivision.utils;

import com.jedivision.entity.Gender;
import flexjson.ObjectBinder;
import flexjson.ObjectFactory;

import java.lang.reflect.Type;

public class FlexjsonGenderFactory implements ObjectFactory {

    @Override
    public Object instantiate(ObjectBinder objectBinder, Object o, Type type, Class aClass) {
        if (Gender.class.equals(type)) {
            return Gender.valueOf(o.toString().toUpperCase());
        } else {
            throw new RuntimeException("Unexpected Gender value...");
        }
    }
}
