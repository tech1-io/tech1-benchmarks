package com.jedivision.benchmark.bitfinex;

import com.jedivision.benchmark.AbstractBenchmark;
import com.jedivision.configuration.Application;
import com.jedivision.exchange.bitfinex.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public abstract class AbstractBitfinex extends AbstractBenchmark {

    @State(Scope.Benchmark)
    public static class BitfinexState {
        private final ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        private final CommonHttpClientBitfinexExchange commonHttpClientBitfinexExchange = context.getBean(CommonHttpClientBitfinexExchange.class);
        private final JcabiBitfinexExchange jcabiBitfinexExchange = context.getBean(JcabiBitfinexExchange.class);
        private final JerseyBitfinexExchange jerseyBitfinexExchange = context.getBean(JerseyBitfinexExchange.class);
        private final OkHttpBitfinexExchange okHttpBitfinexExchange = context.getBean(OkHttpBitfinexExchange.class);
        private final UnirestBitfinexExchange unirestBitfinexExchange = context.getBean(UnirestBitfinexExchange.class);
        private final UnirestParamsBitfinexExchange unirestParamsBitfinexExchange = context.getBean(UnirestParamsBitfinexExchange.class);

        public void commonHttpClient() throws IOException, UnirestException {
            commonHttpClientBitfinexExchange.ticker();
            commonHttpClientBitfinexExchange.orderBook();
            commonHttpClientBitfinexExchange.trades();
        }

        public void jcabi() throws IOException, UnirestException {
            jcabiBitfinexExchange.ticker();
            jcabiBitfinexExchange.orderBook();
            jcabiBitfinexExchange.trades();
        }

        public void jersey() throws IOException, UnirestException {
            jerseyBitfinexExchange.ticker();
            jerseyBitfinexExchange.orderBook();
            jerseyBitfinexExchange.trades();
        }

        public void okHttp() throws IOException, UnirestException {
            okHttpBitfinexExchange.ticker();
            okHttpBitfinexExchange.orderBook();
            okHttpBitfinexExchange.trades();
        }

        public void unirest() throws IOException, UnirestException {
            unirestBitfinexExchange.ticker();
            unirestBitfinexExchange.orderBook();
            unirestBitfinexExchange.trades();
        }

        public void unirestParams() throws IOException, UnirestException {
            unirestParamsBitfinexExchange.ticker();
            unirestParamsBitfinexExchange.orderBook();
            unirestParamsBitfinexExchange.trades();
        }
    }
}
