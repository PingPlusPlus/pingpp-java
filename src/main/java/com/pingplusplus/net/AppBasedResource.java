package com.pingplusplus.net;

import com.pingplusplus.Pingpp;

public abstract class AppBasedResource extends APIResource {
    /**
     * @param clazz the class of object
     * @return singleClassURL
     */
    protected static String singleClassURL(Class<?> clazz) {
        return String.format("%s/v1/apps/%s/%s", Pingpp.getApiBase(), APIResource.URIAppIdHolder, className(clazz));
    }

    /**
     * @param clazz the class of object
     * @return classURL
     */
    protected static String classURL(Class<?> clazz) {
        return String.format("%ss", singleClassURL(clazz));
    }

    /**
     * @param clazz the class of object
     * @param id the id of object
     * @return instanceURL
     */
    protected static String instanceURL(Class<?> clazz, String id) {
        return String.format("%s/%s", classURL(clazz), urlEncode(id));
    }
}
