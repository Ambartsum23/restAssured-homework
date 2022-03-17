package Deserializ;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;

@JsonPropertyOrder(alphabetic = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RegistrationFields {
    @JsonProperty("name")
    public String Firstname;
    @JsonProperty("job")
    public String Work;
    @JsonProperty("id")
    public String uniqueid;
    @JsonProperty("createdAt")
    public Date dateCreated;
}