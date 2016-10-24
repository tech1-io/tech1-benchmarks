package com.jedivision.temple.serialization;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class JdkSerializer implements AbstractSerializer {

    @Override
    public byte[] serialize(Object object) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(object);
        }
        return os.toByteArray();
    }

    @Override
    public Object deserialize(byte[] bytes, Class<?> type) throws Exception {
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return ois.readObject();
        }
    }
}
