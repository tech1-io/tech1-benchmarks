package com.jedivision.benchmark.master;

import org.openjdk.jmh.annotations.Benchmark;

import static com.jedivision.jsons.JsonProviderType.*;

public class FromJsonMaster extends AbstractMaster {

    @Benchmark
    public void gson(JsonState state) throws Exception {
        state.fromJson(GSON);
    }

    @Benchmark
    public void jackson(JsonState state) throws Exception {
        state.fromJson(JACKSON);
    }


    @Benchmark
    public void flexjson(JsonState state) throws Exception {
        state.fromJson(FLEXJSON);
    }

    @Benchmark
    public void genson(JsonState state) throws Exception {
        state.fromJson(GENSON);
    }
}
