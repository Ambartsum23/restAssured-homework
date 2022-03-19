import Package.AuthorRecord;
import Package.Fields;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {
ObjectMapper objmp;
    @Test
    public void record() throws JsonProcessingException {

        AuthorRecord record = new AuthorRecord(7,"michael.lawson@reqres.in", "Michael","Lawson",   "https://reqres.in/img/faces/7-image.jpg","2022-03-13");
        objmp = new ObjectMapper();

        System.out.println(objmp.writeValueAsString(record));

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .with().post("https://reqres.in/api/users");

        Fields fields = response.body().as(Fields.class);
        Assert.assertEquals(record.avatar(), fields.avatar);
        Assert.assertEquals(record.id(), fields.uniqueid);
        Assert.assertEquals(record.mail(), fields.mail);
        Assert.assertEquals(record.firstname(), fields.firstname);
        Assert.assertEquals(record.lastname(), fields.lastname);


        System.out.println(new ObjectMapper().writeValueAsString(fields));
    }

}




