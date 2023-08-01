package com.epam.tc.hw8.deleteuserbyusername;

import static com.epam.tc.hw8.constants.Constants.DELETE;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;

import com.epam.tc.hw8.api.ApiClient;
import com.epam.tc.hw8.constants.RequestPath;
import com.epam.tc.hw8.dto.UserResponse;
import com.epam.tc.hw8.utils.JsonObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DeleteUserByUsernameNegativeTests {

    @Test(description = "DELETE /user/{username} endpoint: Check Status 405 Method Not Allowed with empty username")
    public void testWithEmptyUsername() {
        Response response = ApiClient
                .withRequestType(DELETE)
                .withUrl(RequestPath.USER_BY_USERNAME)
                .withPathParam("username", "")
                .makeResponse()
                .checkStatusCode(SC_METHOD_NOT_ALLOWED)
                .getResponse();

        UserResponse userDeletionResponse = JsonObjectMapper
                .generateOneDtoFromJsonBody(response, UserResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userDeletionResponse.getCode(), 405);
        softAssert.assertEquals(userDeletionResponse.getType(), "unknown");
        softAssert.assertAll();
    }

    @Test(description = "DELETE /user/{username} endpoint: "
            + "Check Status 405 Method Not Allowed with non existent username")
    public void testWithNonExistentUsername() {
        ApiClient.withRequestType(DELETE)
                .withUrl(RequestPath.USER_BY_USERNAME)
                .withPathParam("username", "nonExistentUsername")
                .makeResponse()
                .checkStatusCode(SC_NOT_FOUND)
                .getResponse();
    }
}
