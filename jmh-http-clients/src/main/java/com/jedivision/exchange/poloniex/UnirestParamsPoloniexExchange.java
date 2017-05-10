package com.jedivision.exchange.poloniex;

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
public class UnirestParamsPoloniexExchange extends PoloniexExchange {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnirestParamsPoloniexExchange.class);

    @Override
    public void ticker() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get("https://poloniex.com/public")
                .queryString("command", "returnTicker")
                .asString();
        InputStream is = response.getRawBody();
        String ticker = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug("Poloniex [UnirestParams] ticker: " + ticker);
    }

    @Override
    public void orderBook() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get("https://poloniex.com/public")
                .queryString("command", "returnOrderBook")
                .queryString("currencyPair", "all")
                .queryString("depth", "100")
                .asString();
        InputStream is = response.getRawBody();
        String orderBook = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug("Poloniex [UnirestParams] orderBook: " + orderBook);
    }

    @Override
    public void trades() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get("https://poloniex.com/public")
                .queryString("command", "returnTradeHistory")
                .queryString("currencyPair", "BTC_NXT")
                .queryString("start", "1410158341")
                .queryString("end", "1410158341")
                .asString();
        InputStream is = response.getRawBody();
        String trades = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        LOGGER.debug("Poloniex [UnirestParams] trades: " + trades);
    }
}
