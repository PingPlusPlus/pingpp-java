package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;

import java.util.Map;

public class OrderRefund extends APIResource {

    /**
     * 创建 order_refund
     *
     * @param order
     * @param params
     * @return OrderRefundCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static OrderRefundCollection create(String order, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, String.format("%s/order_refunds", instanceURL(Order.class, order)),
                params, OrderRefundCollection.class);
    }

    /**
     * 查询 order_refund
     *
     * @param order
     * @param refund
     * @return Refund
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Refund retrieve(String order, String refund)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, String.format("%s/order_refunds/%s", instanceURL(Order.class, order), refund),
                null, Refund.class);
    }

    /**
     * 查询 order_refund 列表
     *
     * @param order
     * @param params
     * @return OrderRefundCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static OrderRefundCollection list(String order, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, String.format("%s/order_refunds", instanceURL(Order.class, order)),
                params, OrderRefundCollection.class);
    }

    /**
     * 查询 order_refund 列表
     *
     * @param order
     * @return OrderRefundCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static OrderRefundCollection list(String order)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return list(order, null);
    }
}
