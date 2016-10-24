package com.jedivision.benchmark.master;

import com.jedivision.benchmark.AbstractState;
import com.jedivision.benchmark.BenchmarkRunner;
import com.jedivision.entity.Master;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.io.IOException;

public abstract class AbstractMaster extends BenchmarkRunner {

    @State(Scope.Benchmark)
    public static class JsonState extends AbstractState {

        @Setup
        public void setup() throws IOException {
            initJson("/jedi-master.json");
            initUserType(Master.class);
            initJsonProviders();
            initUsers();
        }
    }
}