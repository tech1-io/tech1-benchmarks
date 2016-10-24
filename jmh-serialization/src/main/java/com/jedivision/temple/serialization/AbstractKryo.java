package com.jedivision.temple.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.pool.KryoFactory;
import com.esotericsoftware.kryo.pool.KryoPool;
import com.jedivision.temple.entity.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;

abstract class AbstractKryo {

    protected abstract Input getInput(InputStream is);

    protected abstract Output getOutput(OutputStream os);

    private static final KryoFactory KRYO_FACTORY = () -> {
        Kryo kryo = new Kryo();
        kryo.register(Date.class);
        kryo.register(ArrayList.class);
        kryo.register(Gender.class);
        kryo.register(Task.class);
        kryo.register(Force.class);
        kryo.register(Youngling.class);
        kryo.register(Padawan.class);
        kryo.register(Master.class);
        return kryo;
    };

    private static final KryoPool KRYO_POOL = new KryoPool.Builder(KRYO_FACTORY)
            .softReferences()
            .build();

    byte[] kryoSerialize(Object object) {
        Kryo kryo = KRYO_POOL.borrow();
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (Output output = getOutput(baos)) {
                kryo.writeObject(output, object);
            }
            return baos.toByteArray();
        } finally {
            KRYO_POOL.release(kryo);
        }
    }

    Object kryoDeserialize(byte[] bytes, Class<?> type) {
        Kryo kryo = KRYO_POOL.borrow();
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            try (Input input = getInput(bais)) {
                return kryo.readObject(input, type);
            }
        } finally {
            KRYO_POOL.release(kryo);
        }
    }
}
