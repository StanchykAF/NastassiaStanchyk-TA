package com.epam.tc.hw8.postuser;

import static com.epam.tc.hw8.constants.Constants.POST;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;

import com.epam.tc.hw8.api.ApiClient;
import com.epam.tc.hw8.constants.RequestPath;
import com.epam.tc.hw8.dto.UserResponse;
import com.epam.tc.hw8.utils.JsonObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateUserNegativeTests {

    @Test(description = "POST /users endpoint: Check Status 405 Method Not Allowed with empty body")
    public void testCreateUserWithEmptyBody() {
        Response response = ApiClient
                .withRequestType(POST)
                .withUrl(RequestPath.CREATE_USER)
                .withBody("")
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
