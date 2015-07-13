package com.pingplusplus.model;

import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;

import java.util.Map;

/**
 * Common interface for Pingpp objects that can store metadata.
 */
public interface MetadataStore<T> {
	Map<String, String> getMetadata();
	void setMetadata(Map<String, String> metadata);

	MetadataStore<T> update(Map<String, Object> params) throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ChannelException;
	MetadataStore<T> update(Map<String, Object> params, String apiKey) throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ChannelException;
}
