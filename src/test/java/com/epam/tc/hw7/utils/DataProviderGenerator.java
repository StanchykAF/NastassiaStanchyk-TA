package com.epam.tc.hw7.utils;

import com.epam.tc.hw7.dto.TestData;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class DataProviderGenerator {

    @DataProvider(name = "testData")
    public Object[][] testDataDataProvider() {
        Path filePath = Paths.get("src/test/resources/testdata/JDI_ex8_metalsColorsDataSet.json");
        Map<String, TestData> testDataMap = JsonObjectMapper.generateTestDataMapFromJsonFile(filePath);

        Object[][] data = new Object[testDataMap.size()][1];
        int i = 0;
        for (Map.Entry<String, TestData> entry : testDataMap.entrySet()) {
            data[i][0] = entry.getValue();
            i++;
        }
        return data;
    }
}
