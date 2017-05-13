package com.jedivision.exchange.poloniex;

import com.jedivision.exchange.client.OkHttpInternalClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OkHttpPoloniexExchange extends PoloniexExchange {

    private final OkHttpInternalClient okHttpInternalClient;

    public OkHttpPoloniexExchange(OkHttpInternalClient okHttpInternalClient) {
        this.okHttpInternalClient = okHttpInternalClient;
    }

    @Override
    public void ticker() throws IOException {
        okHttpInternalClient.ticker(tickerURL(), POLONIEX);
    }

    @Override
    public void orderBook() throws IOException {
        okHttpInternalClient.orderBook(orderBookURL(), POLONIEX);
    }

    @Override
    public void trades() throws IOException {
        okHttpInternalClient.trades(tradesURL(), POLONIEX);
    }
}
