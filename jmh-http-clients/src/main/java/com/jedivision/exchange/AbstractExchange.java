package com.jedivision.exchange;

import java.io.IOException;

public interface AbstractExchange {
    // Public APIs
    void ticker() throws IOException;
    void orderBook() throws IOException;
    void trades() throws IOException;
    // Public APIs URLs
    String tickerURL();
    String orderBookURL();
    String tradesURL();
}
