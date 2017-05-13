package com.jedivision.exchange.bitfinex;

import com.jedivision.exchange.client.CommonHttpClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CommonHttpClientBitfinexExchange extends BitfinexExchange {

    private final CommonHttpClient commonHttpClient;

    public CommonHttpClientBitfinexExchange(CommonHttpClient commonHttpClient) {
        this.commonHttpClient = commonHttpClient;
    }

    @Override
    public void ticker() throws IOException {
        commonHttpClient.ticker(tickerURL(), BITFINEX);
    }

    @Override
    public void orderBook() throws IOException {
        commonHttpClient.orderBook(orderBookURL(), BITFINEX);
    }

    @Override
    public void trades() throws IOException {
        commonHttpClient.trades(tradesURL(), BITFINEX);
    }
}
