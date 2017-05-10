package com.jedivision.exchange.poloniex;

import com.jedivision.exchange.AbstractExchange;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OkHttpPoloniexExchange implements AbstractExchange {
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
        LOGGER.debug("Poloniex ticker: " + ticker);
    }

    @Override
    public void orderBook() throws IOException {
        Request request = new Request.Builder().url(orderBookURL()).build();
        Response response = okHttpClient.newCall(request).execute();
        String orderBook = response.body().string();
        LOGGER.debug("Poloniex orderBook: " + orderBook);
    }

    @Override
    public void trades() throws IOException {
        Request request = new Request.Builder().url(tradesURL()).build();
        Response response = okHttpClient.newCall(request).execute();
        String trades = response.body().string();
        LOGGER.debug("Poloniex trades: " + trades);
    }

    @Override
    public String tickerURL() {
        return "https://poloniex.com/public?command=returnTicker";
    }

    @Override
    public String orderBookURL() {
        return "https://poloniex.com/public?command=returnOrderBook&currencyPair=all&depth=100";
    }

    @Override
    public String tradesURL() {
        return "https://poloniex.com/public?command=returnTradeHistory&currencyPair=BTC_NXT&start=1410158341&end=1410499372";
    }
}
