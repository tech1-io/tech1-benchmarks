package com.jedivision.temple.serialization;

public interface AbstractSerializer {
    byte[] serialize(Object object) throws Exception;
    Object deserialize(byte[] bytes, Class<?> type) throws Exception;
}
