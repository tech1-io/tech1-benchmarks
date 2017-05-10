package com.jedivision.exchange.poloniex;

import com.jedivision.exchange.AbstractExchange;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public abstract class PoloniexExchange extends AbstractExchange {

    public abstract void ticker() throws IOException, UnirestException;
    public abstract void orderBook() throws IOException, UnirestException;
    public abstract void trades() throws IOException, UnirestException;

    @Override
    protected String tickerURL() {
        return "https://poloniex.com/public?command=returnTicker";
    }

    @Override
    protected String orderBookURL() {
        return "https://poloniex.com/public?command=returnOrderBook&currencyPair=all&depth=100";
    }

    @Override
    protected String tradesURL() {
        return "https://poloniex.com/public?command=returnTradeHistory&currencyPair=BTC_NXT&start=1410158341&end=1410499372";
    }
}
