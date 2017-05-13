package com.jedivision.exchange.kraken;

import com.jedivision.exchange.client.JcabiClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JcabiKrakenExchange extends KrakenExchange {

    private final JcabiClient jcabiClient;

    public JcabiKrakenExchange(JcabiClient jcabiClient) {
        this.jcabiClient = jcabiClient;
    }

    @Override
    public void ticker() throws IOException {
        jcabiClient.ticker(tickerURL(), KRAKEN);
    }

    @Override
    public void orderBook() throws IOException {
        jcabiClient.orderBook(orderBookURL(), KRAKEN);
    }

    @Override
    public void trades() throws IOException {
        jcabiClient.trades(tradesURL(), KRAKEN);
    }
}
