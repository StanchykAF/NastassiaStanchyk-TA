package com.epam.tc.hw8.deleteuserbyusername;

import static com.epam.tc.hw8.constants.Constants.DELETE;
import static org.apache.http.HttpStatus.SC_OK;

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

public class DeleteUserByUsernamePositiveTests {

    @Test(description = "DELETE /user/{username} endpoint: Check Status 200 OK with valid username")
    public void testDeleteUserByValidUsername() {
        User user = DtoGenerator.generateUserWithOnlyMandatoryFields();
        UserApiClient.createUser(user);

        Response response = ApiClient
                .withRequestType(DELETE)
                .withUrl(RequestPath.USER_BY_USERNAME)
                .withPathParam("username", user.getUsername())
                .makeResponse()
                .checkStatusCode(SC_OK)
                .getResponse();

        UserResponse userDeletionResponse = JsonObjectMapper
                .generateOneDtoFromJsonBody(response, UserResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userDeletionResponse.getCode(), 200);
        softAssert.assertEquals(userDeletionResponse.getType(), "unknown");
        softAssert.assertEquals(userDeletionResponse.getMessage(), user.getUsername());
        softAssert.assertAll();
    }
}
