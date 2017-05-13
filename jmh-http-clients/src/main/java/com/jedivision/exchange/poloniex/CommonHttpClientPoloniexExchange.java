package com.jedivision.exchange.poloniex;

import com.jedivision.exchange.client.CommonHttpClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CommonHttpClientPoloniexExchange extends PoloniexExchange {

    private final CommonHttpClient commonHttpClient;

    public CommonHttpClientPoloniexExchange(CommonHttpClient commonHttpClient) {
        this.commonHttpClient = commonHttpClient;
    }

    @Override
    public void ticker() throws IOException {
        commonHttpClient.ticker(tickerURL(), POLONIEX);
    }

    @Override
    public void orderBook() throws IOException {
        commonHttpClient.orderBook(orderBookURL(), POLONIEX);
    }

    @Override
    public void trades() throws IOException {
        commonHttpClient.trades(tradesURL(), POLONIEX);
    }
}
