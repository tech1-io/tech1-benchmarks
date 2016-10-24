package com.jedivision.jsons;

import java.util.List;

public interface AbstractJson {
    <T> String toJson(List<T> objects) throws Exception;
    <T> List fromJson(String json, Class<T> clazz) throws Exception;
}
