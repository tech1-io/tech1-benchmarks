package com.jedivision.benchmark;

import com.jedivision.configuration.Application;
import com.jedivision.exchange.poloniex.OkHttpPoloniexExchange;
import com.jedivision.exchange.poloniex.UnirestPoloniexExchange;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public abstract class AbstractState extends AbstractBenchmark {

    @State(Scope.Benchmark)
    public static class PoloniexState {
        private final ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        private final OkHttpPoloniexExchange okHttpPoloniexExchange = context.getBean(OkHttpPoloniexExchange.class);
        private final UnirestPoloniexExchange unirestPoloniexExchange = context.getBean(UnirestPoloniexExchange.class);

        public void okHttp() throws IOException {
            okHttpPoloniexExchange.ticker();
            okHttpPoloniexExchange.orderBook();
            okHttpPoloniexExchange.trades();
        }

        public void unirest() throws IOException, UnirestException {
            unirestPoloniexExchange.ticker();
            unirestPoloniexExchange.orderBook();
            unirestPoloniexExchange.trades();
        }
    }
}
