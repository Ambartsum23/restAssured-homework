import API.SetRespons;

import Utils.Constants;
import Steps.StepsClass;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({ScreenShooter.class})
public class Tests {
    SetRespons Respons = new SetRespons();
    StepsClass step = new StepsClass();
    Constants constants=new Constants();


    @BeforeClass
    @Epic("BaseURI")
    public void callAPI() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    @Description(" წარმატებული ტესტი ")
    @Severity(SeverityLevel.BLOCKER)



    public void succsessful() {
        Response response = Respons.responsWithSuccsesParams();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(constants.getSuccsesID(), step.deserialisationWithSuccsesParam().id);
        Assert.assertEquals(constants.getSuccsesToken(), step.deserialisationWithSuccsesParam().token);

        System.out.println(step.deserialisationWithSuccsesParam().id);
        System.out.println(step.deserialisationWithSuccsesParam().token);
    }


    @Test
    @Description("წარმუატებელი ტესტი")
    @Story("Story")
    public void badRequest() {
        Response response = Respons.responsWithBadParams();

        Assert.assertEquals(400, response.statusCode());
        Assert.assertEquals(constants.getBadErrorMessage(), step.deserialisationWithBadParam().error);

        System.out.println(step.deserialisationWithBadParam().error);
    }
    @Test
    @Feature("Feature რამდენიმე პარამეტრით")
    @Description("რამდენიმე პარამეტრით")
    public void severalParams() {

        Response response = Respons.responsWithSeveralParams();

        Assert.assertEquals(201, response.statusCode());
        Assert.assertNotNull(step.deserialisationWithSeveralParams().createdAt);
        Assert.assertNotNull(step.deserialisationWithSeveralParams().id);
        Assert.assertEquals(constants.getJob(), step.deserialisationWithSeveralParams().job);
        Assert.assertEquals(constants.getName(), step.deserialisationWithSeveralParams().name);

        System.out.println("createdAt:  " + step.deserialisationWithSeveralParams().createdAt);
        System.out.println("id:  " + step.deserialisationWithSeveralParams().id);
        System.out.println("job:  " + step.deserialisationWithSeveralParams().job);
        System.out.println("name:  " + step.deserialisationWithSeveralParams().name);
    }
}
