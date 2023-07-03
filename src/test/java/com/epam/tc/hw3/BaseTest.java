package com.epam.tc.hw3;

import com.epam.tc.hw3.driver.DriverSingletone;
import com.epam.tc.hw3.models.User;
import com.epam.tc.hw3.utils.DtoGenerator;
import java.util.Arrays;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Log4j2
public class BaseTest {

    protected WebDriver driver;
    protected User loginUser;
    protected List<String> headersMenusNames = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    protected List<String> textsUnderIcons = Arrays.asList(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
    );

    protected List<String> leftSideBarMenu = Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

    protected List<String> expectedLogRows = Arrays.asList(
            "Colors: value changed to Yellow",
            "metal: value changed to Selen",
            "Wind: condition changed to true",
            "Water: condition changed to true"
    );

    @BeforeMethod()
    public void browserSetup() {
        log.info("Browser setup");
        driver = DriverSingletone.getDriver();
        loginUser = DtoGenerator.createUser("user.name", "user.password");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        log.info("Closing browser");
        DriverSingletone.closeDriver();
    }
}
