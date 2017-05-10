package com.jedivision.exchange.poloniex;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UnirestParamsPoloniexExchange extends PoloniexExchange {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnirestParamsPoloniexExchange.class);

    @Override
    public void ticker() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get("https://poloniex.com/public")
                .queryString("command", "returnTicker")
                .asString();
        String ticker = response.getBody();
        LOGGER.debug("Poloniex [UnirestParams] ticker: " + ticker);
    }

    @Override
    public void orderBook() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get("https://poloniex.com/public")
                .queryString("command", "returnOrderBook")
                .queryString("currencyPair", "all")
                .queryString("depth", "100")
                .asString();
        String ticker = response.getBody();
        LOGGER.debug("Poloniex [UnirestParams] orderBook: " + ticker);
    }

    @Override
    public void trades() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get("https://poloniex.com/public")
                .queryString("command", "returnTradeHistory")
                .queryString("currencyPair", "BTC_NXT")
                .queryString("start", "1410158341")
                .queryString("end", "1410158341")
                .asString();
        String ticker = response.getBody();
        LOGGER.debug("Poloniex [UnirestParams] trades: " + ticker);
    }
}
