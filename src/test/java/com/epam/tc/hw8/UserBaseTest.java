package com.epam.tc.hw8;

import com.epam.tc.hw8.api.UserApiClient;
import com.epam.tc.hw8.dto.User;
import org.testng.annotations.AfterMethod;

public class UserBaseTest {

    protected User user;

    @AfterMethod(alwaysRun = true)
    public void cleanTestData() {
        UserApiClient.deleteUser(user.getUsername());
    }
}
