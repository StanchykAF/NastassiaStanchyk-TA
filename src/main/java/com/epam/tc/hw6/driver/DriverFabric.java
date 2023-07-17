package com.epam.tc.hw6.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@Log4j2
public class DriverFabric {

    public WebDriver getWebdriver(final boolean isLocal, final String hubAddress, @NonNull final String browserName)
            throws MalformedURLException {
        if (isLocal) {
            log.info("Local run");
            return WebDriverManager.getInstance(browserName).create();
        } else {
            Capabilities capabilities = null;
            if (browserName.toUpperCase(Locale.ROOT).equals("CHROME")) {
                capabilities = new ChromeOptions();
            } else if (browserName.toUpperCase(Locale.ROOT).equals("FIREFOX")) {
                capabilities = new FirefoxOptions();
            } else {
                System.err.println("The browser name '%s' is not recognized: " + browserName);
            }
            log.info("Capabilities: {}", capabilities);
            return new RemoteWebDriver(new URL(hubAddress), capabilities);
        }
    }
}
