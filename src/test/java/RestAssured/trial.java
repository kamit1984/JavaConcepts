package RestAssured;

import RestAssured.files.payload;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/**
 * Create by Amit on 9/23/20
 */
public class trial {


    public static void main(String[] args) {

        // Format for RestAssured test
        // Given - all input details
//        when - submit all details - including HTTP type, path
//        then - validate the response

///       Testing for Add Place POST API.
        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payload.AddPlace()).when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server",equalTo("Apache/2.4.18 (Ubuntu)"));

    }

}
