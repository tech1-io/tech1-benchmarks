package com.jedivision.exchange;

public abstract class AbstractExchange {
    // Public APIs URLs
    protected abstract String tickerURL();
    protected abstract String orderBookURL();
    protected abstract String tradesURL();
}
