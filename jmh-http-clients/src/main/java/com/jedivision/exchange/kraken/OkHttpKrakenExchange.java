package com.jedivision.exchange.kraken;

import com.jedivision.exchange.client.OkHttpInternalClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OkHttpKrakenExchange extends KrakenExchange {

    private final OkHttpInternalClient okHttpInternalClient;

    public OkHttpKrakenExchange(OkHttpInternalClient okHttpInternalClient) {
        this.okHttpInternalClient = okHttpInternalClient;
    }

    @Override
    public void ticker() throws IOException {
        okHttpInternalClient.ticker(tickerURL(), KRAKEN);
    }

    @Override
    public void orderBook() throws IOException {
        okHttpInternalClient.orderBook(orderBookURL(), KRAKEN);
    }

    @Override
    public void trades() throws IOException {
        okHttpInternalClient.trades(tradesURL(), KRAKEN);
    }
}
