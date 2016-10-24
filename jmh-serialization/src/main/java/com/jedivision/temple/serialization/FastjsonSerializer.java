package com.jedivision.temple.serialization;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

@Service
public class FastjsonSerializer implements AbstractSerializer {

    @Override
    public byte[] serialize(Object object) throws Exception {
        return JSON.toJSONBytes(object);
    }

    @Override
    public Object deserialize(byte[] bytes, Class<?> type) throws Exception {
        return JSON.parseObject(bytes, type);
    }
}
