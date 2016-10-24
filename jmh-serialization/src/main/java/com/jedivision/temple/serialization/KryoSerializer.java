package com.jedivision.temple.serialization;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

@Service
public class KryoSerializer extends AbstractKryo implements AbstractSerializer {

    @Override
    protected Input getInput(InputStream is) {
        return new Input(is);
    }

    @Override
    protected Output getOutput(OutputStream os) {
        return new Output(os);
    }

    @Override
    public byte[] serialize(Object object) throws Exception {
        return kryoSerialize(object);
    }

    @Override
    public Object deserialize(byte[] bytes, Class<?> type) throws Exception {
        return kryoDeserialize(bytes, type);
    }
}
