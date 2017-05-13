package com.jedivision.exchange.kraken;

import com.jedivision.exchange.client.JerseyClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JerseyKrakenExchange extends KrakenExchange {

    private final JerseyClient jerseyClient;

    public JerseyKrakenExchange(JerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    @Override
    public void ticker() throws IOException {
        jerseyClient.ticker(tickerURL(), KRAKEN);
    }

    @Override
    public void orderBook() throws IOException {
        jerseyClient.orderBook(orderBookURL(), KRAKEN);
    }

    @Override
    public void trades() throws IOException {
        jerseyClient.trades(tradesURL(), KRAKEN);
    }
}
