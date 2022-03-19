package Package;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
public class Fields {


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder(alphabetic = true)

@JsonProperty("id")
public int uniqueid;

    @JsonProperty("email")
    public String mail;

    @JsonProperty("first_name")
    public String firstname;

    @JsonProperty("last_name")
    public String lastname;

    @JsonProperty("avatar")
    public String avatar;

    @JsonProperty("createdAt")
    public String dateCreated;

}