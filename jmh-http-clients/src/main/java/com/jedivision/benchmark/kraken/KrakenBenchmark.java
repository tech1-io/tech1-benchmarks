package com.jedivision.benchmark.kraken;

import org.openjdk.jmh.annotations.Benchmark;

public class KrakenBenchmark extends AbstractKraken {

    @Benchmark
    public void commonHttpClient(KrakenState state) throws Exception {
        state.commonHttpClient();
    }

    @Benchmark
    public void jcabi(KrakenState state) throws Exception {
        state.jcabi();
    }

    @Benchmark
    public void jersey(KrakenState state) throws Exception {
        state.jersey();
    }

    @Benchmark
    public void okHttp(KrakenState state) throws Exception {
        state.okHttp();
    }

    @Benchmark
    public void unirest(KrakenState state) throws Exception {
        state.unirest();
    }

    @Benchmark
    public void unirestParams(KrakenState state) throws Exception {
        state.unirestParams();
    }
}
