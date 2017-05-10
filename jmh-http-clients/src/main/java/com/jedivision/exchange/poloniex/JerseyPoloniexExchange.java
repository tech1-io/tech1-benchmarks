package com.jedivision.exchange.poloniex;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Service
public class JerseyPoloniexExchange extends PoloniexExchange {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonHttpClientPoloniexExchange.class);

    private final Client client;

    public JerseyPoloniexExchange(Client client) {
        this.client = client;
    }

    @Override
    public void ticker() throws IOException, UnirestException {
        Response response = client.target(tickerURL()).request(MediaType.APPLICATION_JSON_TYPE).get();
        String ticker = response.readEntity(String.class);
        LOGGER.debug("Poloniex [Jersey] ticker: " + ticker);
    }

    @Override
    public void orderBook() throws IOException, UnirestException {
        Response response = client.target(orderBookURL()).request(MediaType.APPLICATION_JSON_TYPE).get();
        String orderBook = response.readEntity(String.class);
        LOGGER.debug("Poloniex [Jersey] orderBook: " + orderBook);
    }

    @Override
    public void trades() throws IOException, UnirestException {
        Response response = client.target(tradesURL()).request(MediaType.APPLICATION_JSON_TYPE).get();
        String trades = response.readEntity(String.class);
        LOGGER.debug("Poloniex [Jersey] trades: " + trades);
    }
}
