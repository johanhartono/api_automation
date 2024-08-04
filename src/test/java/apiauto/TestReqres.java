package apiauto;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
//https://www.liquid-technologies.com/online-json-to-schema-converter

public class TestReqres {
    @Test
    public void testGetListUsers() {
        given().when()
                .get("https://reqres.in/api/users?page-2")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("per_page", Matchers.equalTo( 6))
                .assertThat().body("page", Matchers.equalTo( 1));
    }

    @Test
    public void testPostCreateUsers() {
        String valueName = "Johan";
        String valueJob = "QA";

        JSONObject bodyObj = new JSONObject();
        bodyObj.put("name",valueName);
        bodyObj.put("job",valueJob);

        given().header("Content-Type","application/json")
                .header("Accept","application/json")
                .body(bodyObj.toString())
                .when()
                .post("https://reqres.in/api/users").then().log().all()
                .assertThat().statusCode(201)
                .assertThat().body("name",Matchers.equalTo(valueName));


    }

    @Test
    public void testPutUsers() {
        //Define baseURL
        RestAssured.baseURI = "https://reqres.in";
        int userId = 2;
        String newName = "updatedUser";
        //Test PUT user is 2-> update first name
        //First, get the attribute of user is 2

        String fname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.first_name");
        String lname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.last_name");
        String avatar = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.avatar");
        String email = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.email");
        System.out.println("nama before:" + fname);
        //Change the first name to "updated User"
        //Create body request with hasmap and convert it to json

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id" , userId);
        bodyMap.put("email",email);
        bodyMap.put("first_name",newName);
        bodyMap.put("last_name",lname);
        bodyMap.put("avatar",avatar);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type","application/json")
                .body(jsonObject.toString())
                .put("api/users/"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));


    }
    @Test
    public void testPatchUsers() {
        //Define baseURL
        RestAssured.baseURI = "https://reqres.in";
        int userId = 2;
        String newName = "updatedUser";
        //Test PUT user is 2-> update first name
        //First, get the attribute of user is 2

        String fname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.first_name");
        System.out.println("nama before:" + fname);
        //Change the first name to "updated User"
        //Create body request with hasmap and convert it to json

        HashMap<String, String> bodyMap = new HashMap<>();
        bodyMap.put("first_name",newName);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type","application/json")
                .body(jsonObject.toString())
                .patch("api/users/"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));
    }

    @Test
    public void testDeleteUsers() {
        //Define baseURL
        RestAssured.baseURI = "https://reqres.in";
        //Data to Delete
        int userToDelete = 4;
        //Test DELETE api/user/4
        given().log().all()
                .when().delete("api/users/"+userToDelete)
                .then()
                .log().all()
                .assertThat().statusCode(204);
    }
   /* @Test
    public void testValidateJsonSchemaSingleuser() {
        //Define baseURL
        RestAssured.baseURI = "https://reqres.in";
        //Data to get
        int userToGet = 5;
        //File json Schema to compare
        File file = new File("src/test/resources/jsonSchema/GetSingleUserSchema.json");
        //Test GET api/Users/5
        given().log().all()
                .when().get("api/users/" + userToGet)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));

    } */
    @Test
    public void testSchemaGetListUsers() {
        File jsonSchema = new File("src/test/resources/jsonSchema/GetSingleUserSchema.json");

        RestAssured
                .given().when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("per_page", Matchers.equalTo( 6))
                .assertThat().body("page", Matchers.equalTo( 2))
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}

