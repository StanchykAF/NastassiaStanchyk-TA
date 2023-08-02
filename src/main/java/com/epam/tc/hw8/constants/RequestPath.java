package com.epam.tc.hw8.constants;

import lombok.Getter;

@Getter
public enum RequestPath {

    CREATE_USER("/user"),
    USER_BY_USERNAME("/user/{username}");

    public final String path;

    RequestPath(String path) {
        this.path = path;
    }
}
