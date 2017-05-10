package com.jedivision.exchange.poloniex;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OkHttpPoloniexExchange extends PoloniexExchange {
    private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpPoloniexExchange.class);

    private final OkHttpClient okHttpClient;

    public OkHttpPoloniexExchange(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public void ticker() throws IOException {
        Request request = new Request.Builder().url(this.tickerURL()).build();
        Response response = okHttpClient.newCall(request).execute();
        String ticker = response.body().string();
        LOGGER.debug("Poloniex [OkHttp] ticker: " + ticker);
    }

    @Override
    public void orderBook() throws IOException {
        Request request = new Request.Builder().url(orderBookURL()).build();
        Response response = okHttpClient.newCall(request).execute();
        String orderBook = response.body().string();
        LOGGER.debug("Poloniex [OkHttp] orderBook: " + orderBook);
    }

    @Override
    public void trades() throws IOException {
        Request request = new Request.Builder().url(tradesURL()).build();
        Response response = okHttpClient.newCall(request).execute();
        String trades = response.body().string();
        LOGGER.debug("Poloniex [OkHttp] trades: " + trades);
    }
}
