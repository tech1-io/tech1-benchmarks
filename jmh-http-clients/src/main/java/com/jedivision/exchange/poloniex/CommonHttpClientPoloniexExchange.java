package com.jedivision.exchange.poloniex;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class CommonHttpClientPoloniexExchange extends PoloniexExchange {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonHttpClientPoloniexExchange.class);

    private final HttpClient httpClient;

    public CommonHttpClientPoloniexExchange(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public void ticker() throws IOException, UnirestException {
        GetMethod method = new GetMethod(tickerURL());
        httpClient.executeMethod(method);
        InputStream is = method.getResponseBodyAsStream();
        String ticker = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.info("Poloniex [CommonsHttpClient] ticker: " + ticker);
    }

    @Override
    public void orderBook() throws IOException, UnirestException {
        GetMethod method = new GetMethod(orderBookURL());
        httpClient.executeMethod(method);
        InputStream is = method.getResponseBodyAsStream();
        String orderBook = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug("Poloniex [CommonsHttpClient] orderBook: " + orderBook);
    }

    @Override
    public void trades() throws IOException, UnirestException {
        GetMethod method = new GetMethod(tradesURL());
        httpClient.executeMethod(method);
        InputStream is = method.getResponseBodyAsStream();
        String trades = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug("Poloniex [CommonsHttpClient] trades: " + trades);
    }
}
