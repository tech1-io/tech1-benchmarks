package com.jedivision.exchange.bitfinex;

import com.jedivision.exchange.client.UnirestParamsClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class UnirestParamsBitfinexExchange extends BitfinexExchange {
    private static final String TRADES_URL = BITFINEX_BASE_URL + "/trades/ethbtc";

    private final UnirestParamsClient unirestParamsClient;

    public UnirestParamsBitfinexExchange(UnirestParamsClient unirestParamsClient) {
        this.unirestParamsClient = unirestParamsClient;
    }

    @Override
    public void ticker() throws UnirestException {
        HttpResponse<String> response = Unirest.get(tickerURL())
                .asString();
        unirestParamsClient.ticker(response, BITFINEX);
    }

    @Override
    public void orderBook() throws UnirestException {
        HttpResponse<String> response = Unirest.get(orderBookURL())
                .asString();
        unirestParamsClient.orderBook(response, BITFINEX);
    }

    @Override
    public void trades() throws UnirestException {
        HttpResponse<String> response = Unirest.get(TRADES_URL)
                .queryString("limit_trades", "100")
                .asString();
        unirestParamsClient.trades(response, BITFINEX);
    }
}
