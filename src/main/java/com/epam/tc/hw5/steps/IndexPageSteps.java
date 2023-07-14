package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.models.User;
import com.epam.tc.hw5.pom.pages.BasePage;
import com.epam.tc.hw5.pom.pages.IndexPage;
import com.epam.tc.hw5.utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class IndexPageSteps {

    // TODO: переведи степы из hw4 с использованием TestContext. Там все должно быть просто, я в тебя верю. Просто
    //  сделай это, пожалуйста
    @Given("I open JDI GitHub site")
    public void openPage() {
        log.info("Open Index page");
        TestContext.getInstance().get("driver", WebDriver.class).navigate().to(BasePage.BASE_URL + IndexPage.PAGE_URL);
    }

    @And("I login as user {string}")
    public void iLoginAsUser(String userName) {
        log.info("Log in as user " + userName);
        IndexPage indexPage = new IndexPage(TestContext.getInstance().get("driver", WebDriver.class));
        User user = TestContext.getInstance().get("loginUser", User.class);
        indexPage.clickProfileMenuButton();
        indexPage.enterUsername(user.getUsername());
        indexPage.enterPassword(user.getPassword());
        indexPage.clickEnterButton();
    }

}
