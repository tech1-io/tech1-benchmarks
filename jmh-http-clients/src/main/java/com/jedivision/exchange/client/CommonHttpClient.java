package com.jedivision.exchange.client;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class CommonHttpClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonHttpClient.class);

    private final HttpClient httpClient;

    public CommonHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void ticker(String tickerURL, String exchangeTitle) throws IOException {
        GetMethod method = new GetMethod(tickerURL);
        httpClient.executeMethod(method);
        InputStream is = method.getResponseBodyAsStream();
        String ticker = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [CommonsHttpClient] ticker: " + ticker);
    }

    public void orderBook(String orderBookURL, String exchangeTitle) throws IOException {
        GetMethod method = new GetMethod(orderBookURL);
        httpClient.executeMethod(method);
        InputStream is = method.getResponseBodyAsStream();
        String orderBook = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [CommonsHttpClient] orderBook: " + orderBook);
    }

    public void trades(String tradesURL, String exchangeTitle) throws IOException {
        GetMethod method = new GetMethod(tradesURL);
        httpClient.executeMethod(method);
        InputStream is = method.getResponseBodyAsStream();
        String trades = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug(exchangeTitle + " [CommonsHttpClient] trades: " + trades);
    }
}
