package com.jedivision.exchange.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class OkHttpInternalClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpInternalClient.class);

    private final OkHttpClient okHttpClient;

    public OkHttpInternalClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public void ticker(String tickerURL, String exchangeTitle) throws IOException {
        Request request = new Request.Builder().url(tickerURL).build();
        okhttp3.Response response = okHttpClient.newCall(request).execute();
        InputStream is = response.body().byteStream();
        String ticker = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [OkHttp] ticker: " + ticker);
    }

    public void orderBook(String orderBookURL, String exchangeTitle) throws IOException {
        Request request = new Request.Builder().url(orderBookURL).build();
        okhttp3.Response response = okHttpClient.newCall(request).execute();
        InputStream is = response.body().byteStream();
        String orderBook = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [OkHttp] orderBook: " + orderBook);
    }

    public void trades(String tradesURL, String exchangeTitle) throws IOException {
        Request request = new Request.Builder().url(tradesURL).build();
        okhttp3.Response response = okHttpClient.newCall(request).execute();
        InputStream is = response.body().byteStream();
        String trades = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [OkHttp] trades: " + trades);
    }
}
