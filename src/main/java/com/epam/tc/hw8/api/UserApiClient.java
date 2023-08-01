package com.epam.tc.hw8.api;

import static com.epam.tc.hw8.constants.Constants.DELETE;
import static com.epam.tc.hw8.constants.Constants.GET;
import static com.epam.tc.hw8.constants.Constants.POST;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;

import com.epam.tc.hw8.constants.RequestPath;
import com.epam.tc.hw8.dto.User;
import io.restassured.response.Response;

public class UserApiClient extends ApiClient {

    public static void createUser(User user) {
        withRequestType(POST)
                .withUrl(RequestPath.CREATE_USER)
                .withBody(user)
                .makeResponse()
                .checkStatusCode(SC_OK)
                .getResponse();
    }

    public static void deleteUser(String username) {
        withRequestType(DELETE)
                .withUrl(RequestPath.USER_BY_USERNAME)
                .withPathParam("username", username)
                .makeResponse()
                .checkStatusCode(SC_OK)
                .getResponse();
    }

    public static Response getUserInfo(User user) {
        return withRequestType(GET)
                .withUrl(RequestPath.USER_BY_USERNAME)
                .withPathParam("username", user.getUsername())
                .makeResponse()
                .checkStatusCode(SC_OK)
                .getResponse();
    }
}
