package com.jedivision.exchange.kraken;

import com.jedivision.exchange.AbstractExchange;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public abstract class KrakenExchange extends AbstractExchange {
    protected static final String KRAKEN = "Kraken";
    protected static final String KRAKEN_BASE_URL = "https://api.kraken.com/0/public";

    public abstract void ticker() throws IOException, UnirestException;
    public abstract void orderBook() throws IOException, UnirestException;
    public abstract void trades() throws IOException, UnirestException;

    @Override
    protected String tickerURL() {
        return KRAKEN_BASE_URL + "/Ticker?pair=DASHEUR";
    }

    @Override
    protected String orderBookURL() {
        return KRAKEN_BASE_URL + "/Depth?pair=DASHEUR&count=100";
    }

    @Override
    protected String tradesURL() {
        return KRAKEN_BASE_URL + "/Trades?pair=DASHEUR";
    }
}
