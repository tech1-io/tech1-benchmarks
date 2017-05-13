package com.jedivision.exchange.bitfinex;

import com.jedivision.exchange.client.JcabiClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JcabiBitfinexExchange extends BitfinexExchange {

    private final JcabiClient jcabiClient;

    public JcabiBitfinexExchange(JcabiClient jcabiClient) {
        this.jcabiClient = jcabiClient;
    }

    @Override
    public void ticker() throws IOException {
        jcabiClient.ticker(tickerURL(), BITFINEX);
    }

    @Override
    public void orderBook() throws IOException {
        jcabiClient.orderBook(orderBookURL(), BITFINEX);
    }

    @Override
    public void trades() throws IOException {
        jcabiClient.trades(tradesURL(), BITFINEX);
    }
}
