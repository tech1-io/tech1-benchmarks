package com.jedivision.exchange.bitfinex;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class UnirestParamsBitfinexExchange extends BitfinexExchange {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnirestParamsBitfinexExchange.class);

    private static final String TRADES_URL = "https://api.bitfinex.com/v1/trades/ethbtc";

    @Override
    public void ticker() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(tickerURL())
                .asString();
        InputStream is = response.getRawBody();
        String ticker = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug("Bitfinex [UnirestParams] ticker: " + ticker);
    }

    @Override
    public void orderBook() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(orderBookURL())
                .asString();
        InputStream is = response.getRawBody();
        String orderBook = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug("Bitfinex [UnirestParams] orderBook: " + orderBook);
    }

    @Override
    public void trades() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(TRADES_URL)
                .queryString("limit_trades", "100")
                .asString();
        InputStream is = response.getRawBody();
        String trades = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug("Bitfinex [UnirestParams] trades: " + trades);
    }
}
