package com.epam.tc.hw8.constants;

import lombok.Getter;

@Getter
public enum RequestTypes {

    GET("get"),
    POST("post"),
    DELETE("delete"),
    PUT("put");

    private final String requestType;

    RequestTypes(String requestType) {
        this.requestType = requestType;
    }
}
