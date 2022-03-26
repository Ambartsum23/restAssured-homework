package Steps;

import Models.Respons.DeserialisationParam2;
import Models.Respons.DeserialisationParams;
import API.SetRespons;
import io.qameta.allure.Step;

public class StepsClass {

    SetRespons respons = new SetRespons();

    @Step("deserialisation With Succses Param")
    public DeserialisationParams deserialisationWithSuccsesParam() {


        if (respons.responsWithSuccsesParams().statusCode() == 200) {
            DeserialisationParams successRespons = respons.responsWithSuccsesParams().as(DeserialisationParams.class);
            return successRespons;
        } else {
            System.out.println("Not Succses Status Code");
            return null;
        }
    }

    @Step("deserialisation With Bad Param")
    public DeserialisationParams deserialisationWithBadParam() {
        if (respons.responsWithBadParams().statusCode() == 400) {
            DeserialisationParams failureResponse = respons.responsWithBadParams().as(DeserialisationParams.class);
            return failureResponse;
        } else {
            System.out.println("Not Equals status");
            return null;
        }
    }

    @Step("deserialisation With Several Params")
    public DeserialisationParam2 deserialisationWithSeveralParams() {
        if (respons.responsWithSeveralParams().statusCode() == 201) {
            DeserialisationParam2 paramsave = respons.responsWithSeveralParams().as(DeserialisationParam2.class);
            return paramsave;
        } else {
            System.out.println("Not Equals status");
            return null;
        }
    }


}