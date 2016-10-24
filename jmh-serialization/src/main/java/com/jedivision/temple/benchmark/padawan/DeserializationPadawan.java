package com.jedivision.temple.benchmark.padawan;

import com.jedivision.temple.benchmark.AbstractState;
import com.jedivision.temple.benchmark.BenchmarkRunner;
import com.jedivision.temple.entity.Padawan;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.io.IOException;

import static com.jedivision.temple.serialization.SerializationType.*;

public class DeserializationPadawan extends BenchmarkRunner {

    @State(Scope.Benchmark)
    public static class SerializationState extends AbstractState {

        @Setup
        public void setup() throws IOException {
            initSerializers();
            initUsers("/jedi-padawan.json", Padawan.class);
            initSerializedBytesByType();
        }
    }

    @Benchmark
    public void jdk(SerializationState state) throws Exception {
        state.deserialize(JDK);
    }

    @Benchmark
    public void fastjson(SerializationState state) throws Exception {
        state.deserialize(FASTJSON);
    }

    @Benchmark
    public void jacksonJson(SerializationState state) throws Exception {
        state.deserialize(JACKSON_JSON);
    }

    @Benchmark
    public void jacksonSmile(SerializationState state) throws Exception {
        state.deserialize(JACKSON_SMILE);
    }

    @Benchmark
    public void fst(SerializationState state) throws Exception {
        state.deserialize(FST);
    }

    @Benchmark
    public void fstUnsafe(SerializationState state) throws Exception {
        state.deserialize(FST_UNSAFE);
    }

    @Benchmark
    public void kryo(SerializationState state) throws Exception {
        state.deserialize(KRYO);
    }

    @Benchmark
    public void kryoUnsafe(SerializationState state) throws Exception {
        state.deserialize(KRYO_UNSAFE);
    }

    @Benchmark
    public void messagePack(SerializationState state) throws Exception {
        state.deserialize(MESSAGE_PACK);
    }
}
