package com.epam.tc.hw8.postuser;

import static com.epam.tc.hw8.constants.Constants.POST;
import static org.apache.http.HttpStatus.SC_OK;

import com.epam.tc.hw8.UserBaseTest;
import com.epam.tc.hw8.api.ApiClient;
import com.epam.tc.hw8.constants.RequestPath;
import com.epam.tc.hw8.dto.UserResponse;
import com.epam.tc.hw8.utils.DtoGenerator;
import com.epam.tc.hw8.utils.JsonObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateUserPositiveTests extends UserBaseTest {

    @Test(description = "POST /users endpoint: Check Status 200 OK with valid data")
    public void testCreateUserWithFullData() {
        user = DtoGenerator.generateDefaultUser();

        Response response = ApiClient
                .withRequestType(POST)
                .withUrl(RequestPath.CREATE_USER)
                .withBody(user)
                .makeResponse()
                .checkStatusCode(SC_OK)
                .getResponse();

        UserResponse userResponse = JsonObjectMapper
                .generateOneDtoFromJsonBody(response, UserResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userResponse.getCode(), 200);
        softAssert.assertEquals(userResponse.getType(), "unknown");
        softAssert.assertNotNull(userResponse.getMessage(),
                "Message must contain something");
        softAssert.assertAll();
    }

    @Test(description = "POST /users endpoint: Check Status 200 OK with only mandatory valid data")
    public void testCreateUserWithOnlyMandatoryData() {
        user = DtoGenerator.generateUserWithOnlyMandatoryFields();

        Response response = ApiClient
                .withRequestType(POST)
                .withUrl(RequestPath.CREATE_USER)
                .withBody(user)
                .makeResponse()
                .checkStatusCode(SC_OK)
                .getResponse();

        UserResponse userResponse = JsonObjectMapper
                .generateOneDtoFromJsonBody(response, UserResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userResponse.getCode(), 200);
        softAssert.assertEquals(userResponse.getType(), "unknown");
        softAssert.assertNotNull(userResponse.getMessage(),
                "Message must contain something");
        softAssert.assertAll();
    }
}
