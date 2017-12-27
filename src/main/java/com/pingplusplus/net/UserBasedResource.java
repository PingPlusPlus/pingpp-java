package com.pingplusplus.net;

import com.pingplusplus.PingppAccount;
import com.pingplusplus.exception.InvalidRequestException;

import java.io.UnsupportedEncodingException;

public abstract class UserBasedResource extends AppBasedResource {

    /**
     * @param clazz
     * @param userId
     * @return singleClassURL
     * @throws InvalidRequestException
     */
    protected static String singleClassURL(Class<?> clazz, String userId) throws InvalidRequestException {
        if (PingppAccount.appId == null) {
            throw new InvalidRequestException("Please set app_id using PingppAccount.appId = <APP_ID>", "app_id", null);
        }
        return String.format("%s/v1/apps/%s/users/%s/%s", PingppAccount.getApiBase(), PingppAccount.appId, userId, className(clazz));
    }

    /**
     * @param clazz
     * @param userId
     * @return classURL
     * @throws InvalidRequestException
     */
    protected static String classURL(Class<?> clazz, String userId) throws InvalidRequestException {
        return String.format("%ss", singleClassURL(clazz, userId));
    }

    /**
     * @param clazz
     * @param id
     * @param userId
     * @return instanceURL
     * @throws InvalidRequestException
     */
    protected static String instanceURL(Class<?> clazz, String userId, String id) throws InvalidRequestException {
        try {
            return String.format("%s/%s", classURL(clazz, userId), urlEncode(id));
        } catch (UnsupportedEncodingException e) {
            throw new InvalidRequestException("Unable to encode parameters to " + CHARSET, null, e);
        }
    }
}
