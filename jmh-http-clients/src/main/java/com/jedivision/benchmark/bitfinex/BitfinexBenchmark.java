package com.jedivision.benchmark.bitfinex;

import org.openjdk.jmh.annotations.Benchmark;

public class BitfinexBenchmark extends AbstractBitfinex {

    @Benchmark
    public void commonHttpClient(BitfinexState state) throws Exception {
        state.commonHttpClient();
    }

    @Benchmark
    public void jcabi(BitfinexState state) throws Exception {
        state.jcabi();
    }

    @Benchmark
    public void jersey(BitfinexState state) throws Exception {
        state.jersey();
    }

    @Benchmark
    public void okHttp(BitfinexState state) throws Exception {
        state.okHttp();
    }

    @Benchmark
    public void unirest(BitfinexState state) throws Exception {
        state.unirest();
    }

    @Benchmark
    public void unirestParams(BitfinexState state) throws Exception {
        state.unirestParams();
    }
}
