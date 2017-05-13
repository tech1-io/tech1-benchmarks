package com.jedivision.exchange.bitfinex;

import com.jedivision.exchange.AbstractExchange;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public abstract class BitfinexExchange extends AbstractExchange {
    protected static final String BITFINEX = "Bitfinex";
    protected static final String BITFINEX_BASE_URL = "https://api.bitfinex.com/v1";

    public abstract void ticker() throws IOException, UnirestException;
    public abstract void orderBook() throws IOException, UnirestException;
    public abstract void trades() throws IOException, UnirestException;

    @Override
    protected String tickerURL() {
        return BITFINEX_BASE_URL + "/pubticker/ethbtc";
    }

    @Override
    protected String orderBookURL() {
        return BITFINEX_BASE_URL + "/book/ethbtc";
    }

    @Override
    protected String tradesURL() {
        return BITFINEX_BASE_URL + "/trades/ethbtc?limit_trades=100";
    }
}
