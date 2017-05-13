package com.jedivision.exchange.poloniex;

import com.jedivision.exchange.client.JerseyClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JerseyPoloniexExchange extends PoloniexExchange {

    private final JerseyClient jerseyClient;

    public JerseyPoloniexExchange(JerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    @Override
    public void ticker() throws IOException {
        jerseyClient.ticker(tickerURL(), POLONIEX);
    }

    @Override
    public void orderBook() throws IOException {
        jerseyClient.orderBook(orderBookURL(), POLONIEX);
    }

    @Override
    public void trades() throws IOException {
        jerseyClient.trades(tradesURL(), POLONIEX);
    }
}
