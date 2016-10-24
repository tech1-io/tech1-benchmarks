package com.jedivision.temple.serialization;

import com.jedivision.temple.entity.*;
import org.msgpack.MessagePack;
import org.springframework.stereotype.Service;

@Service
public class MessagePackSerializer implements AbstractSerializer {
    private static final MessagePack MSGPACK = new MessagePack();

    public MessagePackSerializer() {
        MSGPACK.register(Gender.class);
        MSGPACK.register(Task.class);
        MSGPACK.register(Force.class);
        MSGPACK.register(Youngling.class);
        MSGPACK.register(Padawan.class);
        MSGPACK.register(Master.class);
    }

    @Override
    public byte[] serialize(Object object) throws Exception {
        return MSGPACK.write(object);
    }

    @Override
    public Object deserialize(byte[] bytes, Class<?> type) throws Exception {
        return MSGPACK.read(bytes, type);
    }
}
