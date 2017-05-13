package com.jedivision.exchange.poloniex;

import com.jedivision.exchange.client.UnirestClient;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class UnirestPoloniexExchange extends PoloniexExchange {

    private final UnirestClient unirestClient;

    public UnirestPoloniexExchange(UnirestClient unirestClient) {
        this.unirestClient = unirestClient;
    }

    @Override
    public void ticker() throws UnirestException {
        unirestClient.ticker(tickerURL(), POLONIEX);
    }

    @Override
    public void orderBook() throws UnirestException {
        unirestClient.orderBook(orderBookURL(), POLONIEX);
    }

    @Override
    public void trades() throws UnirestException {
        unirestClient.trades(tradesURL(), POLONIEX);
    }
}
