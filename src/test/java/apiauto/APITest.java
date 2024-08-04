package apiauto;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

    @Test
    public void getUserTest() {
        //Define baseURL
        RestAssured.baseURI = "https://reqres.in";

        //Test GET api/users?page=1 with total data 6 per page
        given().when().get("api/users?page=1")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("page", Matchers.equalTo(1))
                .assertThat().body("data.id",Matchers.hasSize(6));

    }
}
