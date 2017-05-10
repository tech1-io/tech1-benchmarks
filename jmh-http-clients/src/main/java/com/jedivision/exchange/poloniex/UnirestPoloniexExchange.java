package com.jedivision.exchange.poloniex;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UnirestPoloniexExchange extends PoloniexExchange {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnirestPoloniexExchange.class);

    @Override
    public void ticker() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(tickerURL()).asString();
        String ticker = response.getBody();
        LOGGER.debug("Poloniex [Unirest] ticker: " + ticker);
    }

    @Override
    public void orderBook() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(orderBookURL()).asString();
        String ticker = response.getBody();
        LOGGER.debug("Poloniex [Unirest] orderBook: " + ticker);
    }

    @Override
    public void trades() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(tradesURL()).asString();
        String ticker = response.getBody();
        LOGGER.debug("Poloniex [Unirest] trades: " + ticker);
    }
}
