package com.jedivision.benchmark;

import org.openjdk.jmh.annotations.Benchmark;

public class PoloniexBenchmark extends AbstractState {

    @Benchmark
    public void commonHttpClient(PoloniexState state) throws Exception {
        state.commonHttpClient();
    }

    @Benchmark
    public void jersey(PoloniexState state) throws Exception {
        state.jersey();
    }

    @Benchmark
    public void okHttp(PoloniexState state) throws Exception {
        state.okHttp();
    }

    @Benchmark
    public void unirest(PoloniexState state) throws Exception {
        state.unirest();
    }

    @Benchmark
    public void unirestParams(PoloniexState state) throws Exception {
        state.unirestParams();
    }
}
