package Package;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorRecord(
        @JsonProperty("id") int id,
        @JsonProperty("email") String mail,
        @JsonProperty("first_name") String firstname,
        @JsonProperty("last_name") String lastname,
        @JsonProperty("avatar") String avatar,
        @JsonProperty("createdAt") String dateCreated){}








/*
import lombok.Lombok;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class bookingDates {

      bookingDates.
              setCheckIn(guestinfo.checkIn).
             setCheckout(guestInfo.checkOut);
             guest.setFirstName(gusestInfo.firstName)
             .setLastName(guestInfo.lastName).
             setTotalPrice(guestInfo.totalPrice).
             setDepositPaid(guestInfo.depositPaid).
             setBookingDates(BookingDates).
             setAdditionalNeesd(guestInfo.additionalNeeds);
        return this;
    public void guestinfo() {

        JSONObject request = new JSONObject();
        request.put("firstname", "Ambartsum");
        request.put("lastname", "Karapetyan");
        request.put("totalprice", 111);
        request.put("depositpaid", true);

        JSONObject bookingDatesMap = new JSONObject();

        request.put("checkin", "2021-01-01");
        request.put("checkout", "2022-03-13");
        request.put("bookingdates", bookingDatesMap);
        request.put("additionalNeeds", "Breakfast");
    }
    public void lom() {
        Lombok lombok = new Lombok();
        lombok.setAge(15);
        lombok.setName("John");
        lombok.setHeight("175");
        lombok.lastName("Karapetyan");
        System.out.println(lombok.getAge());
    }
}*/