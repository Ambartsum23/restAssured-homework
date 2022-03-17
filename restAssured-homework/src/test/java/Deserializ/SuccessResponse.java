package Deserializ;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SuccessResponse {
    public String SuccessCode;
    public String Message;
}
