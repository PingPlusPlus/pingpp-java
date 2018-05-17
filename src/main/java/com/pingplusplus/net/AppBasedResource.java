package com.pingplusplus.net;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pingplusplus.PingppAccount;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.model.*;
import com.pingplusplus.serializer.*;

import java.io.UnsupportedEncodingException;

public abstract class AppBasedResource extends APIResource {
    /**
     * @param clazz
     * @return singleClassURL
     * @throws InvalidRequestException
     */
    protected static String singleClassURL(Class<?> clazz) throws InvalidRequestException {
        if (PingppAccount.appId == null) {
            throw new InvalidRequestException("Please set app_id using PingppAccount.appId = <APP_ID>", "app_id", null);
        }
        return String.format("%s/v1/apps/%s/%s", PingppAccount.getApiBase(), PingppAccount.appId, className(clazz));
    }

    /**
     * @param clazz
     * @return classURL
     * @throws InvalidRequestException
     */
    protected static String classURL(Class<?> clazz) throws InvalidRequestException {
        return String.format("%ss", singleClassURL(clazz));
    }

    /**
     * @param clazz
     * @param id
     * @return instanceURL
     * @throws InvalidRequestException
     */
    protected static String instanceURL(Class<?> clazz, String id) throws InvalidRequestException {
        try {
            return String.format("%s/%s", classURL(clazz), urlEncode(id));
        } catch (UnsupportedEncodingException e) {
            throw new InvalidRequestException("Unable to encode parameters to " + CHARSET, null, e);
        }
    }

    /**
     * @param objectName
     * @return customURL
     * @throws InvalidRequestException
     */
    protected static String customURL(String objectName) throws InvalidRequestException {
        if (PingppAccount.appId == null) {
            throw new InvalidRequestException("Please set app_id using PingppAccount.appId = <APP_ID>", "app_id", null);
        }
        return String.format("%s/v1/apps/%s/%s", PingppAccount.getApiBase(), PingppAccount.appId, objectName);
    }
}
