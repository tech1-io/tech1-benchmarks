package com.jedivision.exchange.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Component
public class JerseyClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(JerseyClient.class);

    private final Client client;

    public JerseyClient(Client client) {
        this.client = client;
    }

    public void ticker(String tickerURL, String exchangeTitle) throws IOException {
        Response response = client.target(tickerURL).request(MediaType.APPLICATION_JSON_TYPE).get();
        String ticker = response.readEntity(String.class);
        LOGGER.debug(exchangeTitle + " [Jersey] ticker: " + ticker);
    }

    public void orderBook(String orderBookURL, String exchangeTitle) throws IOException {
        Response response = client.target(orderBookURL).request(MediaType.APPLICATION_JSON_TYPE).get();
        String orderBook = response.readEntity(String.class);
        LOGGER.debug(exchangeTitle + " [Jersey] orderBook: " + orderBook);
    }

    public void trades(String tradesURL, String exchangeTitle) throws IOException {
        Response response = client.target(tradesURL).request(MediaType.APPLICATION_JSON_TYPE).get();
        String trades = response.readEntity(String.class);
        LOGGER.debug(exchangeTitle + " [Jersey] trades: " + trades);
    }
}
