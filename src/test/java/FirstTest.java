import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

public class FirstTest{

@DataProvider(name="IdAndCountry")
public Object[][] Data() {
    return new Object[][] {

            {"americas","USA"},
            {"hungaroring","Hungary"},
    };
}

    @Test(dataProvider="IdAndCountry")
    public void passCircuitIdValidateCountry(String circuitId, String country) {

        given().
                pathParam("circuitId",circuitId).
                when().
                get("http://ergast.com/api/f1/circuits/{circuitId}.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.Location[0].country",equalTo(country));
    }

    @Test(dataProvider = "IdAndCountry")
    public void test(String circuitId, String country) {
        given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                extract().
                path("MRData.CircuitTable.Circuits.circuitId");

        given().
                pathParam("circuitId",circuitId).
                when().
                get("http://ergast.com/api/f1/circuits/{circuitId}.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.Location[0].country",equalTo(country));
    }

}

