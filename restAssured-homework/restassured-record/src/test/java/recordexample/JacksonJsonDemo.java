package recordexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonDemo {

    public static void main(String[] args) throws JsonProcessingException {
        User user = new User(
                null,
                "potato@gmail.com",
                "John",
                "Brown",
                "https://reqres.in/img/faces/1-image.jpg"
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);
        System.out.println(userJson);
    }
}
