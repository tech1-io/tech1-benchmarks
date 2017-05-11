package com.jedivision.exchange.bitfinex;

import com.jedivision.exchange.AbstractExchange;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public abstract class BitfinexExchange extends AbstractExchange {

    public abstract void ticker() throws IOException, UnirestException;
    public abstract void orderBook() throws IOException, UnirestException;
    public abstract void trades() throws IOException, UnirestException;

    @Override
    protected String tickerURL() {
        return "https://api.bitfinex.com/v1/pubticker/ethbtc";
    }

    @Override
    protected String orderBookURL() {
        return "https://api.bitfinex.com/v1/book/ethbtc";
    }

    @Override
    protected String tradesURL() {
        return "https://api.bitfinex.com/v1/trades/ethbtc?limit_trades=100";
    }
}
