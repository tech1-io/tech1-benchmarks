package com.jedivision.exchange.poloniex;

import com.jedivision.exchange.AbstractExchange;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public abstract class PoloniexExchange extends AbstractExchange {
    protected static final String POLONIEX = "Poloniex";
    protected static final String POLONIEX_BASE_URL = "https://poloniex.com/public";

    public abstract void ticker() throws IOException, UnirestException;
    public abstract void orderBook() throws IOException, UnirestException;
    public abstract void trades() throws IOException, UnirestException;

    @Override
    protected String tickerURL() {
        return POLONIEX_BASE_URL + "?command=returnTicker";
    }

    @Override
    protected String orderBookURL() {
        return POLONIEX_BASE_URL + "?command=returnOrderBook&currencyPair=all&depth=100";
    }

    @Override
    protected String tradesURL() {
        return POLONIEX_BASE_URL + "?command=returnTradeHistory&currencyPair=BTC_NXT&start=1410158341&end=1410499372";
    }
}
