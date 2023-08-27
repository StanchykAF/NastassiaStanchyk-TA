package com.epam.tc.hw7.tests;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.epam.tc.hw7.entities.HeaderMenuData.METALS_AND_COLORS;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsPage.metalsAndColorsForm;
import static com.epam.tc.hw7.utils.PropertiesReader.readProperty;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.tc.hw7.TestsInit;
import com.epam.tc.hw7.dto.TestData;
import com.epam.tc.hw7.entities.MetalsAndColors;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.site.JdiSite;
import com.epam.tc.hw7.site.pages.MetalsAndColorsPage;
import com.epam.tc.hw7.utils.DataProviderGenerator;
import com.epam.tc.hw7.utils.TestNGListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class MetalsAndColorsFormTest implements TestsInit {

    @BeforeClass
    public void login() {
        User user = new User(
                readProperty("user.name"),
                readProperty("user.password"),
                readProperty("user.profile.name"));
        JdiSite.homePage.login(user);
        JdiSite.headerMenu.select(METALS_AND_COLORS);
    }

    @Test(dataProvider = "testData", dataProviderClass = DataProviderGenerator.class)
    public void metalsAndColorsFormTest(TestData testData) throws InterruptedException {

        MetalsAndColors metalsAndColors = new MetalsAndColors().set(c -> {
            c.metals = testData.getMetals();
            c.colors = testData.getColor();
            c.elements = testData.getElements().toArray(new String[0]);
            c.odds = testData.getSummary().get(0).toString();
            c.evens = testData.getSummary().get(1).toString();
            c.vegetables = testData.getVegetables().toString().replaceAll("[\\[\\]]", "");
        });

        metalsAndColorsForm.elements.select(metalsAndColors.elements);

        metalsAndColorsForm.submit(metalsAndColors);
        Thread.sleep(2000);
        List<String> results = MetalsAndColorsPage.results.stream().map(IsText::getText).collect(Collectors.toList());
        results.forEach(System.out::println);

        int sum = testData.getSummary().get(0) + testData.getSummary().get(1);
        List<String> expectedResults = Arrays.asList(
                "Summary: " + sum,
                "Elements: " + testData.getElements().toString().replaceAll("[\\[\\]]", ""),
                "Color: " + testData.getColor(),
                "Metal: " + testData.getMetals(),
                "Vegetables: " + testData.getVegetables().toString().replaceAll("[\\[\\]]", "")
        );
        assertThat(results.stream().allMatch(r -> expectedResults.stream().anyMatch(r::contains)))
                .withFailMessage("Actual results " + results + " don't match with expected results " + expectedResults)
                .isTrue();
        refresh();
    }
}
