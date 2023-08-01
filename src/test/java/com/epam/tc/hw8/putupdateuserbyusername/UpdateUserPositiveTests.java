package com.epam.tc.hw8.putupdateuserbyusername;

import static com.epam.tc.hw8.constants.Constants.PUT;
import static org.apache.http.HttpStatus.SC_OK;

import com.epam.tc.hw8.UserBaseTest;
import com.epam.tc.hw8.api.ApiClient;
import com.epam.tc.hw8.api.UserApiClient;
import com.epam.tc.hw8.constants.RequestPath;
import com.epam.tc.hw8.dto.User;
import com.epam.tc.hw8.utils.DtoGenerator;
import com.epam.tc.hw8.utils.JsonObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UpdateUserPositiveTests extends UserBaseTest {

    /*
    Here is a bug (for both tests):
    user data is updated after the DELETE request only (you can see this behavior also in the Swagger UI)
     */
    @Test(description = "PUT /user/{username} endpoint: Check Status 200 OK with valid data")
    public void testUpdateUserWithFullData() {
        user = DtoGenerator.generateDefaultUser();
        UserApiClient.createUser(user);

        User updatedUser = user.toBuilder()
                .firstName("NewFirstName")
                .phone("5678901234")
                .build();

        ApiClient.withRequestType(PUT)
                .withUrl(RequestPath.USER_BY_USERNAME)
                .withPathParam("username", updatedUser.getUsername())
                .withBody(updatedUser)
                .makeResponse()
                .checkStatusCode(SC_OK);

        Response response = UserApiClient.getUserInfo(updatedUser);
        User userInfoResponse = JsonObjectMapper.generateOneDtoFromJsonBody(response, User.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userInfoResponse.getFirstName(), updatedUser.getFirstName());
        softAssert.assertEquals(userInfoResponse.getPhone(), updatedUser.getPhone());
        softAssert.assertAll();
    }

    @Test(description = "PUT /user/{username} endpoint: Check Status 200 OK with valid data")
    public void testUpdateUserWithOnlyMandatoryFields() {
        user = DtoGenerator.generateUserWithOnlyMandatoryFields();
        UserApiClient.createUser(user);

        User updatedUser = user.toBuilder()
                .firstName("NewFirstName")
                .userStatus(3)
                .build();

        ApiClient.withRequestType(PUT)
                .withUrl(RequestPath.USER_BY_USERNAME)
                .withPathParam("username", user.getUsername())
                .withBody(updatedUser)
                .makeResponse()
                .checkStatusCode(SC_OK);

        Response response = UserApiClient.getUserInfo(user);
        User userInfoResponse = JsonObjectMapper.generateOneDtoFromJsonBody(response, User.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userInfoResponse.getFirstName(), updatedUser.getFirstName());
        softAssert.assertEquals(userInfoResponse.getUserStatus(), updatedUser.getUserStatus());
        softAssert.assertAll();
    }
}
