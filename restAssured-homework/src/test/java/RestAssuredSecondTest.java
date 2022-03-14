import io.restassured.RestAssured;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredSecondTest {

    @Test()
    public void lastrecordsname() throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     Date date = new Date();
        RestAssured.given()
                .when()
                .get("https://chercher.tech/sample/api/product/read")
                .then()
                .body("records.name[-1]", equalTo("cherchertech"))
                .body("records.created", everyItem(lessThan(formatter.format(date))));
    }


    @Test
    public void postNewUsers() {

        JSONObject request = new JSONObject();
        request.put("firstname", "Ambartsum");
        request.put("lastname", "Karapetyan");
        request.put("totalprice", 111);
        request.put("depositpaid", true);

        JSONObject bookingDatesMap =new JSONObject();

        request.put("checkin", "2021-01-01");
        request.put("checkout", "2022-03-13");
        request.put("bookingdates", bookingDatesMap);
        request.put("additionalneeds", "Breakfast");

        given().
                body(request.toJSONString())
                .when()
                .post("https://reqres.in/api/users ")
                .then()
                .log().ifStatusCodeIsEqualTo(201);
    }
}


