package RestAssuredTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
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
    @Test
    void test4(){
        String season = "2017";

        given().
                pathParam("raceSeason",season).
                when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().
                body("MRData.CircuitTable.Circuits.circuitName[0,1]",
                        anyOf(
                                hasItems("Albert Park Grand Prix Circuit",
                                        "Circuit of the Americas")
                                ,hasItems("123","888")));


    }
}
//java.lang.NoSuchMethodError: 'org.hamcrest.core.AnyOf org.hamcrest.core.AnyOf.anyOf(org.hamcrest.Matcher[])'
  /*  @Test
    void test4(){
        String season = "2017";

        given().
                pathParam("raceSeason",season).
                when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().
                body("MRData.CircuitTable.Circuits.circuitName[0,1]",
                        anyOf(
                                hasItems("Albert Park Grand Prix Circuit",
                                        "Circuit of the Americas")
                                ,hasItems("123","888")));


    }
*/

