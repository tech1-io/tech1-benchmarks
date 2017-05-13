package com.jedivision.exchange.bitfinex;

import com.jedivision.exchange.client.OkHttpInternalClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OkHttpBitfinexExchange extends BitfinexExchange {

    private final OkHttpInternalClient okHttpInternalClient;

    public OkHttpBitfinexExchange(OkHttpInternalClient okHttpInternalClient) {
        this.okHttpInternalClient = okHttpInternalClient;
    }

    @Override
    public void ticker() throws IOException {
        okHttpInternalClient.ticker(tickerURL(), BITFINEX);
    }

    @Override
    public void orderBook() throws IOException {
        okHttpInternalClient.orderBook(orderBookURL(), BITFINEX);
    }

    @Override
    public void trades() throws IOException {
        okHttpInternalClient.trades(tradesURL(), BITFINEX);
    }
}
