package com.jedivision.exchange.kraken;

import com.jedivision.exchange.client.UnirestClient;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class UnirestKrakenExchange extends KrakenExchange {

    private final UnirestClient unirestClient;

    public UnirestKrakenExchange(UnirestClient unirestClient) {
        this.unirestClient = unirestClient;
    }

    @Override
    public void ticker() throws UnirestException {
        unirestClient.ticker(tickerURL(), KRAKEN);
    }

    @Override
    public void orderBook() throws UnirestException {
        unirestClient.orderBook(orderBookURL(), KRAKEN);
    }

    @Override
    public void trades() throws UnirestException {
        unirestClient.trades(tradesURL(), KRAKEN);
    }
}
