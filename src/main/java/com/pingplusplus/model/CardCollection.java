package com.pingplusplus.model;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.*;

import java.util.Map;

public class CardCollection extends PingppCollectionAPIResource<Card> {

    public Card retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException {
        String url = String.format("%s%s/%s", Pingpp.getApiBase(), this.getURL(), id);
        return request(RequestMethod.GET, url, null, Card.class);
    }

    public CardCollection all(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException {

        String url = String.format("%s%s", Pingpp.getApiBase(), this.getURL());
        return request(RequestMethod.GET, url, params, CardCollection.class);
    }

    public Card create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException {

        String url = String.format("%s%s", Pingpp.getApiBase(), this.getURL());
        return request(RequestMethod.POST, url, params, Card.class);
    }
}
