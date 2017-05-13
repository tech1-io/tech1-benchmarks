package com.jedivision.exchange.client;

import com.jcabi.http.Request;
import com.jcabi.http.request.JdkRequest;
import com.jcabi.http.response.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JcabiClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(JcabiClient.class);

    public void ticker(String tickerURL, String exchangeTitle) throws IOException {
        String ticker = new JdkRequest(tickerURL).method(Request.GET).fetch().as(RestResponse.class).body();
        LOGGER.debug(exchangeTitle + " [Jcabi] ticker: " + ticker);
    }

    public void orderBook(String orderBookURL, String exchangeTitle) throws IOException {
        String orderBook = new JdkRequest(orderBookURL).method(Request.GET).fetch().as(RestResponse.class).body();
        LOGGER.debug(exchangeTitle + " [Jcabi] orderBook: " + orderBook);
    }

    public void trades(String tradesURL, String exchangeTitle) throws IOException {
        String trades = new JdkRequest(tradesURL).method(Request.GET).fetch().as(RestResponse.class).body();
        LOGGER.debug(exchangeTitle + " [Jcabi] trades: " + trades);
    }
}
