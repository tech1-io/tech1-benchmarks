package com.jedivision.benchmark;

import org.openjdk.jmh.annotations.Benchmark;

public class PoloniexBenchmark extends AbstractState {

    @Benchmark
    public void okHttp(PoloniexState state) throws Exception {
        state.okHttp();
    }
}
