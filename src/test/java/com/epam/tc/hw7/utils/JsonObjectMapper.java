package com.epam.tc.hw7.utils;

import com.epam.tc.hw7.dto.TestData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class JsonObjectMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static Map<String, TestData> generateTestDataMapFromJsonFile(Path filePath) {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            String json = new String(Files.readAllBytes(filePath));
            return mapper.readValue(json, new TypeReference<Map<String, TestData>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
