package com.jedivision.exchange;

public abstract class AbstractExchange {
    // Public APIs URLs
    abstract protected String tickerURL();
    abstract protected String orderBookURL();
    abstract protected String tradesURL();
}
