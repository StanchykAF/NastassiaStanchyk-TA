package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.models.ServiceDropDownMenu;
import com.epam.tc.hw5.pom.elements.ServiceMenu;
import com.epam.tc.hw5.pom.pages.BasePage;
import com.epam.tc.hw5.utils.TestContext;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class BasePageSteps extends BaseSteps {

    @ParameterType(".*")
    public ServiceDropDownMenu serviceDropDownMenu(String value) {
        return ServiceDropDownMenu.valueOf(value.toUpperCase().replace(" ", "_"));
    }

    @When("I click on {string} button in Header")
    public void iClickOnButtonInHeader(String menu) {
        log.info("Click on '" + menu + "' dropdown menu");
        new BasePage(TestContext.getInstance().get("driver", WebDriver.class)).getHeader().getServiceMenu().click();
    }

    @And("I click on {serviceDropDownMenu} button in Service dropdown")
    public void iClickOnButtonInServiceDropdown(ServiceDropDownMenu menuElement) {
        log.info("Click SERVICE dropdown menu element '" + menuElement + "'");
        ServiceMenu serviceMenu = new ServiceMenu(TestContext.getInstance().get("driver", WebDriver.class));
        switch (menuElement) {
            case SUPPORT:
                waitVisibilityOf(serviceMenu.getSupport()).click();
                break;
            case DATES:
                waitVisibilityOf(serviceMenu.getDates()).click();
                break;
            case SEARCH:
                waitVisibilityOf(serviceMenu.getSearch()).click();
                break;
            case DIFFERENT_ELEMENTS:
                waitVisibilityOf(serviceMenu.getDifferentElements()).click();
                break;
            case PERFORMANCE:
                waitVisibilityOf(serviceMenu.getPerformance()).click();
                break;
            default:
                throw new RuntimeException("Something went wrong!");
        }
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String pageName) {
        log.info("Verifying page title");
        assertThat(TestContext.getInstance().get("driver", WebDriver.class).getTitle())
                .isEqualTo(pageName);
    }
}
