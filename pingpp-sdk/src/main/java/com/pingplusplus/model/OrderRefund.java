package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.Map;

public class OrderRefund extends APIResource {

    /**
     * 创建 order_refund
     *
     * @param orderId
     * @param params
     * @return OrderRefundCollection
     * @throws PingppException
     */
    public static OrderRefundCollection create(String orderId, Map<String, Object> params)
            throws PingppException {
        return create(orderId, params, null);
    }

    /**
     * 创建 order_refund
     *
     * @param orderId
     * @param params
     * @param options the specific options
     * @return OrderRefundCollection
     * @throws PingppException
     */
    public static OrderRefundCollection create(String orderId, Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, String.format("%s/order_refunds", instanceURL(Order.class, orderId)),
                params, OrderRefundCollection.class, options);
    }

    /**
     * 查询 order_refund
     *
     * @param orderId
     * @param refundId
     * @return Refund
     * @throws PingppException
     */
    public static Refund retrieve(String orderId, String refundId)
            throws PingppException {
        return retrieve(orderId, refundId, null);
    }

    /**
     * 查询 order_refund
     *
     * @param orderId
     * @param refundId
     * @param options the specific options
     * @return Refund
     * @throws PingppException
     */
    public static Refund retrieve(String orderId, String refundId, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, String.format("%s/order_refunds/%s", instanceURL(Order.class, orderId), refundId),
                null, Refund.class, options);
    }

    /**
     * 查询 order_refund 列表
     *
     * @param orderId
     * @param params
     * @return OrderRefundCollection
     * @throws PingppException
     */
    public static OrderRefundCollection list(String orderId, Map<String, Object>params)
            throws PingppException {
        return list(orderId, params, null);
    }

    /**
     * 查询 order_refund 列表
     *
     * @param orderId
     * @return OrderRefundCollection
     * @throws PingppException
     */
    public static OrderRefundCollection list(String orderId)
            throws PingppException {
        return list(orderId, null, null);
    }

    /**
     * 查询 order_refund 列表
     *
     * @param orderId
     * @param options the specific options
     * @return OrderRefundCollection
     * @throws PingppException
     */
    public static OrderRefundCollection list(String orderId, RequestOptions options)
            throws PingppException {
        return list(orderId, null, options);
    }

    /**
     * 查询 order_refund 列表
     *
     * @param orderId
     * @param params
     * @param options the specific options
     * @return OrderRefundCollection
     * @throws PingppException
     */
    public static OrderRefundCollection list(String orderId, Map<String, Object>params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, String.format("%s/order_refunds", instanceURL(Order.class, orderId)),
                params, OrderRefundCollection.class, options);
    }
}
