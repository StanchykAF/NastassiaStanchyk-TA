package com.epam.tc.hw5.hooks;

import com.epam.tc.hw5.driver.DriverSingletone;
import com.epam.tc.hw5.models.User;
import com.epam.tc.hw5.utils.DtoGenerator;
import com.epam.tc.hw5.utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class BaseHooks {

    private WebDriver driver;
    private User loginUser;

    @Before
    public void browserSetup() {
        log.info("Browser setup");
        driver = DriverSingletone.getDriver();
        TestContext.getInstance().set("driver", driver);
        loginUser = DtoGenerator.createUser("user.name", "user.password");
        TestContext.getInstance().set("loginUser", loginUser);
    }

    @After
    public void browserTearDown() {
        log.info("Closing browser");
        DriverSingletone.closeDriver();
        TestContext.getInstance().clear();
    }
}
