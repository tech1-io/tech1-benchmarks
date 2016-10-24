package com.jedivision.temple.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.smile.SmileFactory;
import org.springframework.stereotype.Service;

@Service
public class JacksonSmileSerializer implements AbstractSerializer {
    private static final ObjectMapper MAPPER = new ObjectMapper(new SmileFactory());

    @Override
    public byte[] serialize(Object object) throws Exception {
        return MAPPER.writeValueAsBytes(object);
    }

    @Override
    public Object deserialize(byte[] bytes, Class<?> type) throws Exception {
        return MAPPER.readValue(bytes, type);
    }
}
