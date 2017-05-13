package com.jedivision.exchange.kraken;

import com.jedivision.exchange.client.CommonHttpClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CommonHttpClientKrakenExchange extends KrakenExchange {

    private final CommonHttpClient commonHttpClient;

    public CommonHttpClientKrakenExchange(CommonHttpClient commonHttpClient) {
        this.commonHttpClient = commonHttpClient;
    }

    @Override
    public void ticker() throws IOException {
        commonHttpClient.ticker(tickerURL(), KRAKEN);
    }

    @Override
    public void orderBook() throws IOException {
        commonHttpClient.orderBook(orderBookURL(), KRAKEN);
    }

    @Override
    public void trades() throws IOException {
        commonHttpClient.trades(tradesURL(), KRAKEN);
    }
}
