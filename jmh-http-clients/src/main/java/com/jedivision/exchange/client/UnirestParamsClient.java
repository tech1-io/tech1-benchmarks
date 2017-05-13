package com.jedivision.exchange.client;

import com.mashape.unirest.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class UnirestParamsClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnirestParamsClient.class);

    public void ticker(HttpResponse<String> tickerResponse, String exchangeTitle) {
        InputStream is = tickerResponse.getRawBody();
        String ticker = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [UnirestParams] ticker: " + ticker);
    }

    public void orderBook(HttpResponse<String> orderBookResponse, String exchangeTitle) {
        InputStream is = orderBookResponse.getRawBody();
        String orderBook = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [UnirestParams] orderBook: " + orderBook);
    }

    public void trades(HttpResponse<String> tradesResponse, String exchangeTitle) {
        InputStream is = tradesResponse.getRawBody();
        String trades = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [UnirestParams] trades: " + trades);
    }
}
