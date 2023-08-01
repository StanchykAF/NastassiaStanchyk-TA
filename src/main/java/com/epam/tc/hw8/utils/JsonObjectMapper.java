package com.epam.tc.hw8.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class JsonObjectMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T generateOneDtoFromJsonBody(Response response, Class<T> objectClass) {
        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        try {
            return mapper.readValue(response.body().asPrettyString(), objectClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
