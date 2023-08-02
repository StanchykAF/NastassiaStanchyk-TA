package com.epam.tc.hw4;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.steps.IndexPageSteps;
import com.epam.tc.hw4.utils.DtoGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Login")
@Story("Fails")
public class FailedTest extends BaseTest {

    @Test(description = "This test should be failed")
    @Description("This test should be failed")
    public void testLogin() {
        IndexPageSteps indexPageSteps = new IndexPageSteps(driver).openPage();
        assertThat(indexPageSteps.getPageTitle()).isEqualTo("Home Page");
        indexPageSteps.login(DtoGenerator.createUser("user.name", "user.password"));
        assertThat(indexPageSteps.getUsername()).isEqualTo("Roman");
    }
}
