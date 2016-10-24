package com.jedivision.temple.serialization;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JacksonJsonSerializer implements AbstractSerializer {
    private static final ObjectMapper MAPPER = new ObjectMapper(new JsonFactory());

    @Override
    public byte[] serialize(Object object) throws Exception {
        return MAPPER.writeValueAsBytes(object);
    }

    @Override
    public Object deserialize(byte[] bytes, Class<?> type) throws Exception {
        return MAPPER.readValue(bytes, type);
    }
}
