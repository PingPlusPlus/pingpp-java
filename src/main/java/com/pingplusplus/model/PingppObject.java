package com.pingplusplus.model;

import java.lang.reflect.Field;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class PingppObject {
	
	public static final Gson PRETTY_PRINT_GSON = new GsonBuilder().
		setPrettyPrinting().
		serializeNulls().
		setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).
		create();
	
	@Override public String toString() {
//		return String.format(
//			"<%s@%s id=%s> JSON: %s",
//			this.getClass().getName(),
//			System.identityHashCode(this),
//			this.getIdString(),
//			PRETTY_PRINT_GSON.toJson(this));
        return PRETTY_PRINT_GSON.toJson(this);
	}

	private Object getIdString() {
		try {
			Field idField = this.getClass().getDeclaredField("id");
			return idField.get(this);
		} catch (SecurityException e) {
			return "";
		} catch (NoSuchFieldException e) {
			return "";
		} catch (IllegalArgumentException e) {
			return "";
		} catch (IllegalAccessException e) {
			return "";
		}
	}
}
