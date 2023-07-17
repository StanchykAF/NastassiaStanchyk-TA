package com.epam.tc.hw6;

import com.epam.tc.hw6.driver.DriverFabric;
import com.epam.tc.hw6.models.User;
import com.epam.tc.hw6.utils.DtoGenerator;
import com.epam.tc.hw6.utils.ScreenshotListener;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Log4j2
@Listeners({ScreenshotListener.class})
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

    @BeforeClass()
    @Parameters({"isLocal", "hubAddress", "browserName"})
    public void setup(@Optional("false") final boolean isLocal, final String hubAddress, final String browserName) {
        log.info("Browser setup");
        try {
            driver = DriverFabric.getWebdriver(isLocal, hubAddress, browserName);
            driver.manage().window().maximize();
        } catch (MalformedURLException e) {
            log.error("A malformed URL has occurred: " + e);
        }
        loginUser = DtoGenerator.createUser("user.name", "user.password");
    }

    @BeforeMethod
    public void setContext(ITestContext context) {
        context.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        log.info("Closing browser");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
