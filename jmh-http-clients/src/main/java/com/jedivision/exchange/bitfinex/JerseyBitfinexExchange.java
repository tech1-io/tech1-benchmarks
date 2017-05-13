package com.jedivision.exchange.bitfinex;

import com.jedivision.exchange.client.JerseyClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JerseyBitfinexExchange extends BitfinexExchange {

    private final JerseyClient jerseyClient;

    public JerseyBitfinexExchange(JerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    @Override
    public void ticker() throws IOException {
        jerseyClient.ticker(tickerURL(), BITFINEX);
    }

    @Override
    public void orderBook() throws IOException {
        jerseyClient.orderBook(orderBookURL(), BITFINEX);
    }

    @Override
    public void trades() throws IOException {
        jerseyClient.trades(tradesURL(), BITFINEX);
    }
}
