package com.jedivision.exchange.poloniex;

import com.jedivision.exchange.client.UnirestParamsClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UnirestParamsPoloniexExchange extends PoloniexExchange {
    private static final String COMMAND_QUERY_KEY = "command";

    private final UnirestParamsClient unirestParamsClient;

    public UnirestParamsPoloniexExchange(UnirestParamsClient unirestParamsClient) {
        this.unirestParamsClient = unirestParamsClient;
    }

    @Override
    public void ticker() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(POLONIEX_BASE_URL)
                .queryString(COMMAND_QUERY_KEY, "returnTicker")
                .asString();
        unirestParamsClient.ticker(response, POLONIEX);
    }

    @Override
    public void orderBook() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(POLONIEX_BASE_URL)
                .queryString(COMMAND_QUERY_KEY, "returnOrderBook")
                .queryString("currencyPair", "all")
                .queryString("depth", "100")
                .asString();
        unirestParamsClient.orderBook(response, POLONIEX);
    }

    @Override
    public void trades() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(POLONIEX_BASE_URL)
                .queryString(COMMAND_QUERY_KEY, "returnTradeHistory")
                .queryString("currencyPair", "BTC_NXT")
                .queryString("start", "1410158341")
                .queryString("end", "1410158341")
                .asString();
        unirestParamsClient.trades(response, POLONIEX);
    }
}
