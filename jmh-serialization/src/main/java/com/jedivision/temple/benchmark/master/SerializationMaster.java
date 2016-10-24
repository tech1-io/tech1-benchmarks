package com.jedivision.temple.benchmark.master;

import com.jedivision.temple.benchmark.AbstractState;
import com.jedivision.temple.benchmark.BenchmarkRunner;
import com.jedivision.temple.entity.Master;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.io.IOException;

import static com.jedivision.temple.serialization.SerializationType.*;

public class SerializationMaster extends BenchmarkRunner {

    @State(Scope.Benchmark)
    public static class SerializationState extends AbstractState {

        @Setup
        public void setup() throws IOException {
            initSerializers();
            initUsers("/jedi-master.json", Master.class);
        }
    }

    @Benchmark
    public long jdk(SerializationState state) throws Exception {
        return state.serialize(JDK);
    }

    @Benchmark
    public long fastjson(SerializationState state) throws Exception {
        return state.serialize(FASTJSON);
    }

    @Benchmark
    public long jacksonJson(SerializationState state) throws Exception {
        return state.serialize(JACKSON_JSON);
    }

    @Benchmark
    public long jacksonSmile(SerializationState state) throws Exception {
        return state.serialize(JACKSON_SMILE);
    }

    @Benchmark
    public long fst(SerializationState state) throws Exception {
        return state.serialize(FST);
    }

    @Benchmark
    public long fstUnsafe(SerializationState state) throws Exception {
        return state.serialize(FST_UNSAFE);
    }

    @Benchmark
    public long kryo(SerializationState state) throws Exception {
        return state.serialize(KRYO);
    }

    @Benchmark
    public long kryoUnsafe(SerializationState state) throws Exception {
        return state.serialize(KRYO_UNSAFE);
    }

    @Benchmark
    public long messagePack(SerializationState state) throws Exception {
        return state.serialize(MESSAGE_PACK);
    }
}
