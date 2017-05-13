package com.jedivision.exchange.poloniex;

import com.jedivision.exchange.client.JcabiClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JcabiPoloniexExchange extends PoloniexExchange {

    private final JcabiClient jcabiClient;

    public JcabiPoloniexExchange(JcabiClient jcabiClient) {
        this.jcabiClient = jcabiClient;
    }

    @Override
    public void ticker() throws IOException {
        jcabiClient.ticker(tickerURL(), POLONIEX);
    }

    @Override
    public void orderBook() throws IOException {
        jcabiClient.orderBook(orderBookURL(), POLONIEX);
    }

    @Override
    public void trades() throws IOException {
        jcabiClient.trades(tradesURL(), POLONIEX);
    }
}
