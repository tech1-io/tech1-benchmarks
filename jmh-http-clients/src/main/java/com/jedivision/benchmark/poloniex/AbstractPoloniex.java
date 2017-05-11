package com.jedivision.benchmark.poloniex;

import com.jedivision.benchmark.AbstractBenchmark;
import com.jedivision.configuration.Application;
import com.jedivision.exchange.poloniex.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public abstract class AbstractPoloniex extends AbstractBenchmark {

    @State(Scope.Benchmark)
    public static class PoloniexState {
        private final ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        private final CommonHttpClientPoloniexExchange commonHttpClientPoloniexExchange = context.getBean(CommonHttpClientPoloniexExchange.class);
        private final JcabiPoloniexExchange jcabiPoloniexExchange = context.getBean(JcabiPoloniexExchange.class);
        private final JerseyPoloniexExchange jerseyPoloniexExchange = context.getBean(JerseyPoloniexExchange.class);
        private final OkHttpPoloniexExchange okHttpPoloniexExchange = context.getBean(OkHttpPoloniexExchange.class);
        private final UnirestPoloniexExchange unirestPoloniexExchange = context.getBean(UnirestPoloniexExchange.class);
        private final UnirestParamsPoloniexExchange unirestParamsPoloniexExchange = context.getBean(UnirestParamsPoloniexExchange.class);

        public void commonHttpClient() throws IOException, UnirestException {
            commonHttpClientPoloniexExchange.ticker();
            commonHttpClientPoloniexExchange.orderBook();
            commonHttpClientPoloniexExchange.trades();
        }

        public void jcabi() throws IOException, UnirestException {
            jcabiPoloniexExchange.ticker();
            jcabiPoloniexExchange.orderBook();
            jcabiPoloniexExchange.trades();
        }

        public void jersey() throws IOException, UnirestException {
            jerseyPoloniexExchange.ticker();
            jerseyPoloniexExchange.orderBook();
            jerseyPoloniexExchange.trades();
        }

        public void okHttp() throws IOException, UnirestException {
            okHttpPoloniexExchange.ticker();
            okHttpPoloniexExchange.orderBook();
            okHttpPoloniexExchange.trades();
        }

        public void unirest() throws IOException, UnirestException {
            unirestPoloniexExchange.ticker();
            unirestPoloniexExchange.orderBook();
            unirestPoloniexExchange.trades();
        }

        public void unirestParams() throws IOException, UnirestException {
            unirestParamsPoloniexExchange.ticker();
            unirestParamsPoloniexExchange.orderBook();
            unirestParamsPoloniexExchange.trades();
        }
    }
}
