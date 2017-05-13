package com.jedivision.exchange.bitfinex;

import com.jedivision.exchange.client.UnirestClient;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class UnirestBitfinexExchange extends BitfinexExchange {

    private final UnirestClient unirestClient;

    public UnirestBitfinexExchange(UnirestClient unirestClient) {
        this.unirestClient = unirestClient;
    }

    @Override
    public void ticker() throws UnirestException {
        unirestClient.ticker(tickerURL(), BITFINEX);
    }

    @Override
    public void orderBook() throws UnirestException {
        unirestClient.orderBook(orderBookURL(), BITFINEX);
    }

    @Override
    public void trades() throws UnirestException {
        unirestClient.trades(tradesURL(), BITFINEX);
    }
}
