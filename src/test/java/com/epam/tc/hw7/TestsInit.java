package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.WebSettings.logger;

import com.epam.tc.hw7.site.JdiSite;
import com.epam.tc.hw7.utils.TestNGListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(TestNGListener.class)
public interface TestsInit {

    @BeforeSuite(alwaysRun = true)
    public default void setUp() {
        openSite(JdiSite.class);
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public default void teardown() {
        killAllSeleniumDrivers();
    }
}
