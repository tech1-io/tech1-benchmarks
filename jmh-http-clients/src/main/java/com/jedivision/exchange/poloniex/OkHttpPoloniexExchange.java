package com.jedivision.exchange.poloniex;

import com.jedivision.exchange.AbstractExchange;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OkHttpPoloniexExchange implements AbstractExchange {
    private static final String POLONIEX_TICKER_URL = "https://poloniex.com/public?command=returnTicker";
    private static final String POLONIEX_ORDERBOOK_URL = "https://poloniex.com/public?command=returnOrderBook&currencyPair=all&depth=100";
    private static final String POLONIEX_TRADES_URL = "https://poloniex.com/public?command=returnTradeHistory&currencyPair=BTC_NXT&start=1410158341&end=1410499372";

    private final OkHttpClient okHttpClient;

    public OkHttpPoloniexExchange(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public void publicApiCalls() throws IOException {
        // call ticker
        Request tickerRequest = new Request.Builder()
                .url(POLONIEX_TICKER_URL)
                .build();

        Response tickerResponse = okHttpClient.newCall(tickerRequest).execute();
        String ticker = tickerResponse.body().string();

        // call orderBook
        Request orderBookRequest = new Request.Builder()
                .url(POLONIEX_ORDERBOOK_URL)
                .build();

        Response orderBookResponse = okHttpClient.newCall(tickerRequest).execute();
        String orderBook = orderBookResponse.body().string();

        // call call trades
        Request tradesRequest = new Request.Builder()
                .url(POLONIEX_TRADES_URL)
                .build();

        Response tradesResponse = okHttpClient.newCall(tickerRequest).execute();
        String trades = tradesResponse.body().string();
    }
}
