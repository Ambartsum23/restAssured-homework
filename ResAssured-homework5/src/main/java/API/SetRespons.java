package API;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SetRespons {

    SetRequest request = new SetRequest();

    @Step("respons With Succses Params")
    public Response responsWithSuccsesParams() {

        Response response = given().filter(new AllureRestAssured()).
                header("Content-Type", "application/json").
                body(request.requestWithSuccsesParams()).
                post("/register");
        return response;
    }

    @Step("respons With Bad Params")
    public Response responsWithBadParams() {
        Response response = given().filter(new AllureRestAssured())
                .header("Content-Type", "application/json")
                .body(request.requestWithBadParams())
                .post("/users");
        return response;
    }

    @Step("respons With Several Params")
    public Response responsWithSeveralParams() {
        Response response = given().filter(new AllureRestAssured()).
                header("Content-Type", "application/json").
                body(request.requestWithSeveralParams()).
                post("/users");
        return response;
    }
}
