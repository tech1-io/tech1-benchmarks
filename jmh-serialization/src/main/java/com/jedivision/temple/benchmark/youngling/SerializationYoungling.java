package com.jedivision.temple.benchmark.youngling;

import com.jedivision.temple.benchmark.AbstractState;
import com.jedivision.temple.benchmark.BenchmarkRunner;
import com.jedivision.temple.entity.Youngling;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;

import static com.jedivision.temple.serialization.SerializationType.*;

public class SerializationYoungling extends BenchmarkRunner {

    @State(Scope.Benchmark)
    public static class SerializationState extends AbstractState {

        @Setup
        public void setup() throws IOException {
            initSerializers();
            initUsers("/jedi-youngling.json", Youngling.class);
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
