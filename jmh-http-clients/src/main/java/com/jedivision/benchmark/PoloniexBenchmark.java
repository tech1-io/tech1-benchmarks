package com.jedivision.benchmark;

import org.openjdk.jmh.annotations.Benchmark;

public class PoloniexBenchmark extends AbstractExchangeState {

    @Benchmark
    public void poloniexOkHttp(PoloniexState state) throws Exception {
        state.publicApiCalls();
    }
}
