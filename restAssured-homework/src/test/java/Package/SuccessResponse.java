package Package;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SuccessResponse {
    public String id;
    public String token;
}
