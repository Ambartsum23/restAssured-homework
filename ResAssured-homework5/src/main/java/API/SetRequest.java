package API;

import Models.Requests.RequestParams;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;

public class SetRequest {
    RequestParams v = new RequestParams();

    @Step("request with succses params ")
    public JSONObject requestWithSuccsesParams() {

        JSONObject request = new JSONObject();
        request.put(v.getEmail(), v.getEmailvalue());
        request.put(v.getPassword(), v.getPasswordvalue());
        return request;
    }

    @Step("request With Bad Params")
    public JSONObject requestWithBadParams() {
        JSONObject requeParams = new JSONObject();
        requeParams.put(v.getEmail(), v.getEmailvaluebad());
        return requeParams;
    }

    @Step("request With Several Params")
    public JSONObject requestWithSeveralParams() {
        JSONObject request = new JSONObject();
        request.put(v.getName(), v.getMorpheus());
        request.put(v.getJob(), v.getLeader());
        return request;
    }

}