package com.epam.tc.hw8.putupdateuserbyusername;

import static com.epam.tc.hw8.constants.Constants.PUT;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;

import com.epam.tc.hw8.UserBaseTest;
import com.epam.tc.hw8.api.ApiClient;
import com.epam.tc.hw8.api.UserApiClient;
import com.epam.tc.hw8.constants.RequestPath;
import com.epam.tc.hw8.dto.User;
import com.epam.tc.hw8.dto.UserResponse;
import com.epam.tc.hw8.utils.DtoGenerator;
import com.epam.tc.hw8.utils.JsonObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UpdateUserNegativeTests extends UserBaseTest {

    /*
    Here is a bug:
    SC 200 OK for the PUT request with invalid username
     */
    @Test(description = "PUT /user/{username} endpoint: Check Status 404 Not Found with invalid username")
    public void testUpdateUserWithInvalidUsername() {
        user = DtoGenerator.generateDefaultUser();
        UserApiClient.createUser(user);

        User updatedUser = user.toBuilder()
                .firstName("NewFirstName")
                .phone("5678901234")
                .build();

        ApiClient.withRequestType(PUT)
                .withUrl(RequestPath.USER_BY_USERNAME)
                .withPathParam("username", "invalidUsername")
                .withBody(updatedUser)
                .makeResponse()
                .checkStatusCode(SC_NOT_FOUND)
                .getResponse();
    }

    @Test(description = "PUT /user/{username} endpoint: Check Status 405 Method Not Allowed with empty username")
    public void testUpdateUserWithEmptyUsername() {
        user = DtoGenerator.generateDefaultUser();
        UserApiClient.createUser(user);

        User updatedUser = user.toBuilder()
                .firstName("NewFirstName")
                .phone("5678901234")
                .build();

        Response response = ApiClient
                .withRequestType(PUT)
                .withUrl(RequestPath.USER_BY_USERNAME)
                .withPathParam("username", "")
                .withBody(updatedUser)
                .makeResponse()
                .checkStatusCode(SC_METHOD_NOT_ALLOWED)
                .getResponse();

        UserResponse userResponse = JsonObjectMapper
                .generateOneDtoFromJsonBody(response, UserResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userResponse.getCode(), 405);
        softAssert.assertEquals(userResponse.getType(), "unknown");
        softAssert.assertAll();
    }

    @Test(description = "PUT /user/{username} endpoint: Check Status 405 Method Not Allowed without body")
    public void testUpdateUserWithoutBody() {
        user = DtoGenerator.generateDefaultUser();
        UserApiClient.createUser(user);

        Response response = ApiClient
                .withRequestType(PUT)
                .withUrl(RequestPath.USER_BY_USERNAME)
                .withPathParam("username", user.getUsername())
                .makeResponse()
                .checkStatusCode(SC_METHOD_NOT_ALLOWED)
                .getResponse();

        UserResponse userResponse = JsonObjectMapper
                .generateOneDtoFromJsonBody(response, UserResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userResponse.getCode(), 405);
        softAssert.assertEquals(userResponse.getType(), "unknown");
        softAssert.assertEquals(userResponse.getMessage(), "no data");
        softAssert.assertAll();
    }
}
