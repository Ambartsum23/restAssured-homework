package recordexample;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(
        @JsonProperty("id")
        Long id,
        @JsonProperty("email")
        String email,

        @JsonProperty("first_name")
        String firstName,

        @JsonProperty("last_name")
        String lastName,

        @JsonProperty("avatar")
        String avatar) {
}
