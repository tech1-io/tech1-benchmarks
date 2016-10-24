package com.jedivision.temple.serialization;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.UnsafeInput;
import com.esotericsoftware.kryo.io.UnsafeOutput;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

@Service
public class KryoUnsafeSerializer extends AbstractKryo implements AbstractSerializer {

    @Override
    protected Input getInput(InputStream is) {
        return new UnsafeInput(is);
    }

    @Override
    protected Output getOutput(OutputStream os) {
        return new UnsafeOutput(os);
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
