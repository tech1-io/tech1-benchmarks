package com.jedivision.exchange.bitfinex;

import com.jcabi.http.Request;
import com.jcabi.http.request.JdkRequest;
import com.jcabi.http.response.RestResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JcabiBitfinexExchange extends BitfinexExchange {
    private static final Logger LOGGER = LoggerFactory.getLogger(JcabiBitfinexExchange.class);

    @Override
    public void ticker() throws IOException, UnirestException {
        String ticker = new JdkRequest(tickerURL()).method(Request.GET).fetch().as(RestResponse.class).body();
        LOGGER.debug("Bitfinex [Jcabi] ticker: " + ticker);
    }

    @Override
    public void orderBook() throws IOException, UnirestException {
        String orderBook = new JdkRequest(orderBookURL()).method(Request.GET).fetch().as(RestResponse.class).body();
        LOGGER.debug("Bitfinex [Jcabi] orderBook: " + orderBook);
    }

    @Override
    public void trades() throws IOException, UnirestException {
        String trades = new JdkRequest(tradesURL()).method(Request.GET).fetch().as(RestResponse.class).body();
        LOGGER.debug("Bitfinex [Jcabi] trades: " + trades);
    }
}
