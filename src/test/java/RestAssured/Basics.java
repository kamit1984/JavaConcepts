package RestAssured;

import RestAssured.files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/**
 * Create by Amit on 9/23/20
 */
public class Basics {


    public static void main(String[] args) {
        JsonPath jsonPath ;
        String placeId;
        String addressToUpdate = "Sriyash apartments, Pune, 411046";
        // Format for RestAssured test
        // Given - all input details
//        when - submit all details - including HTTP type, path
//        then - validate the response

///       Testing for Add Place POST API.
        RestAssured.baseURI="https://rahulshettyacademy.com";
//        String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
//                .body(payload.AddPlace()).when().post("maps/api/place/add/json")
//                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
//                .header("Server",equalTo("Apache/2.4.18 (Ubuntu)")).extract().response().asString();

        // Use POST request to create data
        String response = given().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payload.AddPlace()).when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server",equalTo("Apache/2.4.18 (Ubuntu)")).extract().response().asString();


        //Lets parse String as JSON
        jsonPath = new JsonPath(response);
        placeId = jsonPath.get("place_id");
        System.out.println("PlaceID = " +  placeId);

        // Use PUT request to update Address field
        String updateMessage = payload.UpdateAddress();
        updateMessage = updateMessage.replaceAll("<PLACE_ID>",placeId);
        updateMessage = updateMessage.replaceAll("<ADDRESS>",addressToUpdate);
        System.out.println("updateMsg = " + updateMessage);
        String updateResponse = given().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(updateMessage).when().put("maps/api/place/update/json")
                .then().assertThat().statusCode(200).extract().response().asString();


        //Lets parse String as JSON
        jsonPath = new JsonPath(updateResponse);
        String msg = jsonPath.get("msg");
        System.out.println("Extracting = " +  msg);

        // Use GET request to retrieve address field

        String getResponse = given().queryParam("key","qaclick123").queryParam("place_id",placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(getResponse);
        jsonPath = new JsonPath(getResponse);
        String actualUpdatedAddress = jsonPath.get("address");
        System.out.println("Extracting = " +  actualUpdatedAddress);
        Assert.assertEquals(actualUpdatedAddress,addressToUpdate);



    }

}
