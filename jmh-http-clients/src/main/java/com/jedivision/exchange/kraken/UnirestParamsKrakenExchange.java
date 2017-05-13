package com.jedivision.exchange.kraken;

import com.jedivision.exchange.client.UnirestParamsClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UnirestParamsKrakenExchange extends KrakenExchange {
    private static final String TICKER_URL = KRAKEN_BASE_URL + "/Ticker";
    private static final String ORDER_BOOK_URL = KRAKEN_BASE_URL + "/Depth";
    private static final String TRADES_URL = KRAKEN_BASE_URL + "/Trades";
    private static final String PAIR_QUERY_KEY = "pair";
    private static final String PAIR_QUERY_VALUE = "DASHEUR";

    private final UnirestParamsClient unirestParamsClient;

    public UnirestParamsKrakenExchange(UnirestParamsClient unirestParamsClient) {
        this.unirestParamsClient = unirestParamsClient;
    }

    @Override
    public void ticker() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(TICKER_URL)
                .queryString(PAIR_QUERY_KEY, PAIR_QUERY_VALUE)
                .asString();
        unirestParamsClient.ticker(response, KRAKEN);
    }

    @Override
    public void orderBook() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(ORDER_BOOK_URL)
                .queryString(PAIR_QUERY_KEY, PAIR_QUERY_VALUE)
                .queryString("count", "100")
                .asString();
        unirestParamsClient.orderBook(response, KRAKEN);
    }

    @Override
    public void trades() throws IOException, UnirestException {
        HttpResponse<String> response = Unirest.get(TRADES_URL)
                .queryString(PAIR_QUERY_KEY, PAIR_QUERY_VALUE)
                .asString();
        unirestParamsClient.trades(response, KRAKEN);
    }
}
