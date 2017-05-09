package com.jedivision.benchmark;

import org.openjdk.jmh.annotations.Benchmark;

public class SimpleCalculation extends BenchmarkRunner {
    private static final Integer FIRST_NUMBER = 7;
    private static final Integer SECOND_NUMBER = 7;

    @Benchmark
    public void add() throws Exception {
        int sum = FIRST_NUMBER + SECOND_NUMBER;
    }

    @Benchmark
    public void subtract() throws Exception {
        int difference = FIRST_NUMBER - SECOND_NUMBER;
    }
}
