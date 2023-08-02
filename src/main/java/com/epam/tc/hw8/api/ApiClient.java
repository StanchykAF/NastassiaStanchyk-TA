package com.epam.tc.hw8.api;

import static com.epam.tc.hw8.constants.Constants.DELETE;
import static com.epam.tc.hw8.constants.Constants.GET;
import static com.epam.tc.hw8.constants.Constants.POST;
import static com.epam.tc.hw8.constants.Constants.PUT;
import static io.restassured.RestAssured.given;

import com.epam.tc.hw8.constants.RequestPath;
import com.epam.tc.hw8.utils.PropertiesReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

public abstract class ApiClient {

    public static ApiBuilder withRequestType(String requestType) {
        return new ApiBuilder(requestType);
    }

    @Getter
    public static class ApiBuilder {
        private String requestType;
        private String url;
        private Response response;
        private RequestSpecification build = new RequestSpecBuilder().build();

        RequestSpecification builderRequestSpecification =
                given()
                        .log()
                        .all()
                        .spec(build.headers("Accept", "application/json",
                                "Content-Type", "application/json"));

        public ApiBuilder(String requestType) {
            this.requestType = requestType;
        }

        public ApiBuilder withUrl(RequestPath url) {
            this.url = PropertiesReader.readProperty("base.api.url") + url.getPath();
            this.builderRequestSpecification.when()
                    .log()
                    .all();
            return this;
        }

        public ApiBuilder withBody(Object body) {
            this.builderRequestSpecification.body(body);
            return this;
        }

        public ApiBuilder withBody(String body) {
            this.builderRequestSpecification.body(body);
            return this;
        }

        public ApiBuilder withParam(String key, String value) {
            this.builderRequestSpecification.queryParam(key, value);
            return this;
        }

        public ApiBuilder withPathParam(String key, String value) {
            this.builderRequestSpecification.pathParam(key, value);
            return this;
        }

        public ApiBuilder checkStatusCode(int code) {
            this.response.then().statusCode(code);
            return this;
        }

        public ApiBuilder makeResponse() {
            switch (this.requestType) {
                case GET:
                    this.response = this.builderRequestSpecification
                            .get(this.url);
                    break;

                case POST:
                    this.response = this.builderRequestSpecification
                            .post(this.url);
                    break;

                case DELETE:
                    this.response = this.builderRequestSpecification
                            .delete(this.url);
                    break;

                case PUT:
                    this.response = this.builderRequestSpecification
                            .put(this.url);
                    break;

                default:
                    throw new NullPointerException("Unsupported HTTP method");
            }
            return this;
        }

        public ApiBuilder clearQueryParam() {
            FilterableRequestSpecification filterableRequestSpecification =
                    (FilterableRequestSpecification) builderRequestSpecification;
            filterableRequestSpecification.removeHeaders();
            return this;
        }

        public Response getResponse() {
            return this.response.then().log().all().extract().response();
        }
    }
}
