package com.jedivision.benchmark.youngling;

import com.jedivision.benchmark.AbstractState;
import com.jedivision.benchmark.BenchmarkRunner;
import com.jedivision.entity.Youngling;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.io.IOException;

public abstract class AbstractYoungling extends BenchmarkRunner {

    @State(Scope.Benchmark)
    public static class JsonState extends AbstractState {

        @Setup
        public void setup() throws IOException {
            initJson("/jedi-youngling.json");
            initUserType(Youngling.class);
            initJsonProviders();
            initUsers();
        }
    }
}