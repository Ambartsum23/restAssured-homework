package recordexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserTest {

    @Test
    void testUserPost() throws JsonProcessingException {
        User user = new User(
                null,
                "potato@gmail.com",
                "John",
                "Brown",
                "https://reqres.in/img/faces/1-image.jpg"
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);

        given()
            .contentType("application/json")
            .body(userJson)
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .assertThat()
            .statusCode(201)
            .body("first_name", equalTo(user.firstName()))
            .body("last_name", equalTo(user.lastName()))
            .body("email", equalTo(user.email()))
            .body("avatar", equalTo(user.avatar()));
    }
}
