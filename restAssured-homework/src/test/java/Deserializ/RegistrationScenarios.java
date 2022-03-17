package Deserializ;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.HashMap;


import static io.restassured.RestAssured.given;

public class RegistrationScenarios {
    @Test
    public void registrationSuccess() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("email", "eve.holt@reqres.in");
        requestParams.put("password", "pistol");

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        Response response = request.post("/api/register");
        ResponseBody body = response.getBody();
        if(response.statusCode() == 200)
        {
            SuccessResponse responseBody = body.as(SuccessResponse.class);
          Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
         Assert.assertEquals("Operation completed successfully", responseBody.Message);
        }

    }
    @Test
    public void UnsuccessfullRegistration() {
        RestAssured.baseURI = "https://reqres.in/api";
        RequestSpecification request = given();

        Map<String,String> jsonBody = new HashMap<String,String>();
        jsonBody.put("email","sydney@fife");
        jsonBody.put("password", null);

        request.header("Content-Type", "application/json");
        request.body(jsonBody);
        Response response = request.post("/register");
        ResponseBody body = response.getBody();
        String str = body.toString();
        int statusCode = response.getStatusCode();
        System.out.print(str);

        if(response.statusCode() == 400)
        {
            FailureResponse responseBody = body.as(FailureResponse.class);
            Assert.assertEquals(responseBody.error,"Missing password");
        }

    }

    @Test
    public void userWithParameters()throws JsonProcessingException {
     /*  Map<String,String> jsonBody = new HashMap<String,String>();
        jsonBody.put("name", "morpheus");
        jsonBody.put("job", "leader");
     RegistrationFields user = given().
                contentType(ContentType.JSON).
                body(body).
                when().
                post("https://reqres.in/api/users").
                then().
                log().ifStatusCodeIsEqualTo(201).
                extract().
                response().
                as(RegistrationFields.class);*/
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("name", "morpheus");
        requestParams.put("job", "leader");

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        Response response = request.post("/api/users");
        ResponseBody body = response.getBody();

        int statusCode = response.getStatusCode();
        System.out.print(statusCode);

    }

}
