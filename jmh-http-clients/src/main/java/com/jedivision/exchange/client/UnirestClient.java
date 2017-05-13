package com.jedivision.exchange.client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class UnirestClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnirestClient.class);

    public void ticker(String tickerURL, String exchangeTitle) throws UnirestException {
        HttpResponse<String> response = Unirest.get(tickerURL).asString();
        InputStream is = response.getRawBody();
        String ticker = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [Unirest] ticker: " + ticker);
    }

    public void orderBook(String orderBookURL, String exchangeTitle) throws UnirestException {
        HttpResponse<String> response = Unirest.get(orderBookURL).asString();
        InputStream is = response.getRawBody();
        String orderBook = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [Unirest] orderBook: " + orderBook);
    }

    public void trades(String tradesURL, String exchangeTitle) throws UnirestException {
        HttpResponse<String> response = Unirest.get(tradesURL).asString();
        InputStream is = response.getRawBody();
        String trades = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [Unirest] trades: " + trades);
    }
}
