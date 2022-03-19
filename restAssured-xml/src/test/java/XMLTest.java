import java.util.Arrays;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class XMLTest {
    @BeforeClass
    public static void setup() {
        RestAssured.given().
                contentType("text/xml").
                accept(ContentType.XML);
        baseURI = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByName";
    }
    @Test
    void countNames() {
        Response response = RestAssured.
                get("/ListOfContinentsByName").
                then().extract().response();
        XmlPath xmlPath = response.xmlPath();
        int countsName = xmlPath.getInt("ArrayOftContinent.tContinent.sName.size()");
        System.out.println("count of all 'sName' node is : " + countsName);
        Assert.assertEquals(6, countsName);
    }
    @Test
    void getAllNamesValue() {
        String namesList = given().
            when().get("/ListOfContinentsByName").
            then().extract().asString();

        XmlPath xmlPath = new XmlPath(namesList);
        List<String> responsNameList = xmlPath.getList("ArrayOftContinent.tContinent.sName");
        List<String> constantList = Arrays.asList("Africa", "Antarctica", "Asia", "Europe", "Ocenania", "The Americas");

        System.out.println("respons namelists : " + responsNameList);
        System.out.println("constant list : " + constantList);
        Assert.assertEquals(responsNameList, constantList);
    }
    @Test
    public void getName_AN() {
        Response response = RestAssured.
            get("/ListOfContinentsByName").
            then().extract().response();

        XmlPath xmlPath = response.xmlPath();
        String nameAN = xmlPath.getString("ArrayOftContinent.tContinent.findAll{it.sCode=='AN'}.sName");
        System.out.println(nameAN);
        Assert.assertEquals("Antarctica", nameAN);
    }
    @Test
    public void lastContinetnName() {
        Response response  = RestAssured.
            get("/ListOfContinentsByName").
            then().extract().response();

        XmlPath xmlPath = response.xmlPath();
        String lasContinenttName = xmlPath.getString("ArrayOftContinent.tContinent[-1].sName");
        Assert.assertEquals("The Americas", lasContinenttName);
        System.out.println(lasContinenttName);
    }
}