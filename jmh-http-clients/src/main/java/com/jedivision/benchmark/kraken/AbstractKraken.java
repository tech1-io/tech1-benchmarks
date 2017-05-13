package com.jedivision.benchmark.kraken;

import com.jedivision.benchmark.AbstractBenchmark;
import com.jedivision.configuration.Application;
import com.jedivision.exchange.kraken.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public abstract class AbstractKraken extends AbstractBenchmark {

    @State(Scope.Benchmark)
    public static class KrakenState {
        private final ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        private final CommonHttpClientKrakenExchange commonHttpClientKrakenExchange = context.getBean(CommonHttpClientKrakenExchange.class);
        private final JcabiKrakenExchange jcabiKrakenExchange = context.getBean(JcabiKrakenExchange.class);
        private final JerseyKrakenExchange jerseyKrakenExchange = context.getBean(JerseyKrakenExchange.class);
        private final OkHttpKrakenExchange okHttpKrakenExchange = context.getBean(OkHttpKrakenExchange.class);
        private final UnirestKrakenExchange unirestKrakenExchange = context.getBean(UnirestKrakenExchange.class);
        private final UnirestParamsKrakenExchange unirestParamsKrakenExchange = context.getBean(UnirestParamsKrakenExchange.class);

        public void commonHttpClient() throws IOException, UnirestException {
            commonHttpClientKrakenExchange.ticker();
            commonHttpClientKrakenExchange.orderBook();
            commonHttpClientKrakenExchange.trades();
        }

        public void jcabi() throws IOException, UnirestException {
            jcabiKrakenExchange.ticker();
            jcabiKrakenExchange.orderBook();
            jcabiKrakenExchange.trades();
        }

        public void jersey() throws IOException, UnirestException {
            jerseyKrakenExchange.ticker();
            jerseyKrakenExchange.orderBook();
            jerseyKrakenExchange.trades();
        }

        public void okHttp() throws IOException, UnirestException {
            okHttpKrakenExchange.ticker();
            okHttpKrakenExchange.orderBook();
            okHttpKrakenExchange.trades();
        }

        public void unirest() throws IOException, UnirestException {
            unirestKrakenExchange.ticker();
            unirestKrakenExchange.orderBook();
            unirestKrakenExchange.trades();
        }

        public void unirestParams() throws IOException, UnirestException {
            unirestParamsKrakenExchange.ticker();
            unirestParamsKrakenExchange.orderBook();
            unirestParamsKrakenExchange.trades();
        }
    }
}
