package Package;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.experimental.Accessors;

@JsonPropertyOrder(alphabetic = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public @Data @Accessors(chain = true)
class RegistrationFields {
    @JsonProperty
    private String Firstname;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String totalPrice;
    @JsonProperty
    private String depositPaid;
   // @JsonProperty
   // private  BookingDates bookingDates;
    @JsonProperty
    private String aditionalNeeds;
}