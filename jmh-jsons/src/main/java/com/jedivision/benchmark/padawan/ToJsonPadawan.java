package com.jedivision.benchmark.padawan;

import org.openjdk.jmh.annotations.Benchmark;

import static com.jedivision.jsons.JsonProviderType.*;

public class ToJsonPadawan extends AbstractPadawan {

    @Benchmark
    public void gson(JsonState state) throws Exception {
        state.toJson(GSON);
    }

    @Benchmark
    public void jackson(JsonState state) throws Exception {
        state.toJson(JACKSON);
    }

    @Benchmark
    public void flexjson(JsonState state) throws Exception {
        state.toJson(FLEXJSON);
    }

    @Benchmark
    public void genson(JsonState state) throws Exception {
        state.toJson(GENSON);
    }
}
