package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AppBasedResource;

import java.util.Map;

public class RechargeRefund extends AppBasedResource {
    /**
     * 创建 recharge_refund
     *
     * @param rechargeId
     * @param params
     * @return Refund
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Refund create(String rechargeId, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.POST, String.format("%s/refunds", instanceURL(Recharge.class, rechargeId)),
                params, Refund.class);
    }

    /**
     * 查询 recharge_refund
     *
     * @param rechargeId
     * @param refundId
     * @return Refund
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Refund retrieve(String rechargeId, String refundId)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, String.format("%s/refunds/%s", instanceURL(Recharge.class, rechargeId), refundId),
                null, Refund.class);
    }

    /**
     * 查询 recharge_refund 列表
     *
     * @param rechargeId
     * @param params
     * @return RechargeRefundCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static RechargeRefundCollection list(String rechargeId, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, String.format("%s/refunds", instanceURL(Recharge.class, rechargeId)),
                params, RechargeRefundCollection.class);
    }

    /**
     * 查询 recharge_refund 列表
     *
     * @param rechargeId
     * @return RechargeRefundCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static RechargeRefundCollection list(String rechargeId)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return list(rechargeId, null);
    }
}
