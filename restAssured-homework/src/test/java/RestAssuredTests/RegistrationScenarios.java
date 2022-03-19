package RestAssuredTests;

import Package.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.HashMap;


import static io.restassured.RestAssured.given;

public class RegistrationScenarios {
    @Test
    public void registrationSuccess() {
        Map<String, Object> successRequestMap = new HashMap<>();

        successRequestMap.put("email", "eve.holt@reqres.in");
        successRequestMap.put("password", "pistol");

        RestAssured.baseURI = "https://reqres.in";
        JSONObject successRequest = new JSONObject(successRequestMap);
        Response response = given()
                .contentType(ContentType.JSON).and().body(successRequest.toJSONString())
                .when().post("https://reqres.in/api/register");
        validateResponse(response);
    }



    @Test
    public void UnsuccessfullRegistration() {
        Map<String, Object> failureRequestMap = new HashMap<>();
        failureRequestMap.put("email","sydney@fife");

        JSONObject failureRequest = new JSONObject(failureRequestMap);

        Response response = given()
                .contentType(ContentType.JSON).and().body(failureRequest.toJSONString())
                .when().post("https://reqres.in/api/register");
        validateResponse(response);
    }
    @Test
    public void userWithParameters()throws JsonProcessingException {
     Map<String,Object> successRequestMap = new HashMap<>();
        successRequestMap.put("name", "morpheus");
        successRequestMap.put("job", "leader");
        JSONObject successRequest = new JSONObject(successRequestMap);
        Response response = RestAssured.given().
                contentType(ContentType.JSON).
                and().
                body(successRequest.toJSONString()).
                when().
                post("https://reqres.in/api/users");

      RegistrationFields registrationFields = response.body().as(RegistrationFields.class);
        System.out.println(new ObjectMapper().writeValueAsString(registrationFields));


    }

    public void  validateResponse(@NotNull Response response){
        if(response.statusCode()==200){
            SuccessResponse successResponse= response.body().as(SuccessResponse.class);
           // Assert.assertEquals(4, successResponse.id);
            Assert.assertEquals("QpwL5tke4Pnpja7X4", successResponse.token);
        }
        else if(response.statusCode()==400){
            FailureResponse failureResponse = response.body().as(FailureResponse.class);
            Assert.assertEquals("Missing password", failureResponse.error);
        }
    }

   /* public void Serialization createGuestBody() {
        bookingDates.
                serCheckIn(guestinfo.checkIn).
                setCheckout(guestInfo.checkOut);
        guest.
                setFirstName(gusestInfo.firstName)
                .setLastName(guestInfo.lastName).
                setTotalPrice(guestInfo.totalPrice).
                setDepositPaid(guestInfo.depositPaid).
                setBookingDates(BookingDates).
                setAdditionalNeesd(guestInfo.additionalNeeds);
        return this;*/
}
