package com.jedivision.benchmark.padawan;

import com.jedivision.benchmark.AbstractState;
import com.jedivision.benchmark.BenchmarkRunner;
import com.jedivision.entity.Padawan;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.io.IOException;

public abstract class AbstractPadawan extends BenchmarkRunner {

    @State(Scope.Benchmark)
    public static class JsonState extends AbstractState {

        @Setup
        public void setup() throws IOException {
            initJson("/jedi-padawan.json");
            initUserType(Padawan.class);
            initJsonProviders();
            initUsers();
        }
    }
}