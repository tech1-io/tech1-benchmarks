package com.jedivision.exchange.poloniex;

import com.mashape.unirest.http.exceptions.UnirestException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class OkHttpPoloniexExchange extends PoloniexExchange {
    private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpPoloniexExchange.class);

    private final OkHttpClient okHttpClient;

    public OkHttpPoloniexExchange(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public void ticker() throws IOException, UnirestException {
        Request request = new Request.Builder().url(this.tickerURL()).build();
        Response response = okHttpClient.newCall(request).execute();
        InputStream is = response.body().byteStream();
        String ticker = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug("Poloniex [OkHttp] ticker: " + ticker);
    }

    @Override
    public void orderBook() throws IOException, UnirestException {
        Request request = new Request.Builder().url(orderBookURL()).build();
        Response response = okHttpClient.newCall(request).execute();
        InputStream is = response.body().byteStream();
        String orderBook = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug("Poloniex [OkHttp] orderBook: " + orderBook);
    }

    @Override
    public void trades() throws IOException, UnirestException {
        Request request = new Request.Builder().url(tradesURL()).build();
        Response response = okHttpClient.newCall(request).execute();
        InputStream is = response.body().byteStream();
        String trades = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug("Poloniex [OkHttp] trades: " + trades);
    }
}
