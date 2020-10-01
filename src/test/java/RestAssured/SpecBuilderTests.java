package RestAssured;

import RestAssured.files.payload;
import io.restassured.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.AddPlace;
import pojo.GetPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by Amit on 9/27/20
 */
public class SpecBuilderTests {
    private String baseURI = "https://rahulshettyacademy.com";

    @Test
    public void AddBookTest(){

        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
        ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//        JsonPath addBookText = ReusableMethods.getRawToJSON(payload.Addbook());
        RequestSpecification request = given().spec(req).body(payload.Addbook());
        Response response = request.when()
                .log().all().post("/Library/Addbook.php")
                .then().log().all().spec(res)
                .extract().response();
        System.out.println(response);

    }

    @Test
    public void AddPlaceAndVerify(){

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        RequestSpecification req =  new RequestSpecBuilder().setBaseUri(baseURI).setContentType(ContentType.JSON).build();

        String initialAddress = "Sriyash apartments, Pune, 411046";
        // Use POST request to create data
        String response = given().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payload.AddPlace2("Amits Address 1", initialAddress)).when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server",equalTo("Apache/2.4.18 (Ubuntu)")).extract().response().asString();

        //Lets parse String as JSON
        JsonPath jsonPath = ReusableMethods.getRawToJSON(response);
        String placeId = jsonPath.get("place_id");
        System.out.println("PlaceID = " +  placeId);

        String getResponse = given().queryParam("key","qaclick123").queryParam("place_id",placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();

        System.out.println(getResponse);
        jsonPath = ReusableMethods.getRawToJSON(getResponse);
        String actualAddress = jsonPath.get("address");
        System.out.println("Extracting = " +  actualAddress);
        Assert.assertEquals(actualAddress,initialAddress);
    }

    @Test(dataProvider = "addPlaceData")
    public void AddPlaceAndVerifyParametrized(String nameOfPlace,String Address){
        RestAssured.baseURI="https://rahulshettyacademy.com";

//        String initialAddress = "Sriyash apartments, Pune, 411046";
        // Use POST request to create data
        String response = given().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payload.AddPlace2(nameOfPlace, Address)).when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server",equalTo("Apache/2.4.18 (Ubuntu)")).extract().response().asString();

        //Lets parse String as JSON
        JsonPath jsonPath = ReusableMethods.getRawToJSON(response);
        String placeId = jsonPath.get("place_id");
        System.out.println("PlaceID = " +  placeId);

        String getResponse = given().queryParam("key","qaclick123").queryParam("place_id",placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();

//        System.out.println(getResponse);
        jsonPath = ReusableMethods.getRawToJSON(getResponse);
        String actualPlaceName = jsonPath.get("name");
        String actualAddress = jsonPath.get("address");
//        System.out.println("Extracting = " +  actualAddress);
        Assert.assertEquals(actualAddress,Address);
        Assert.assertEquals(actualPlaceName,nameOfPlace);

        // Delete the address using DELETE
        String deleteResponse = given().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payload.deleteAddress(placeId)).when().log().all().delete("/maps/api/place/delete/json")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        jsonPath = ReusableMethods.getRawToJSON(deleteResponse);
        String status = jsonPath.get("status");
        Assert.assertEquals(status,"OK");

    }

    @DataProvider(name = "addPlaceData")
    public Object[][] getData(){
        return new Object[][]{
                {"Amits Address 1", "Address1 str, Munich 80000"},
                {"Amits Address 2", "Address2 str, Stuttgart 80000"},
                {"Amits Address 3", "Address3 str, Berlin 80000"},
        };
    }

    @Test
    public void AddPlaceSerializedAndDeserialized(){
        RestAssured.baseURI="https://rahulshettyacademy.com";

        String initialAddress = "Wasserburger Landstr, Munchen 80000";
        String nameOfAddress = "Amits House Serialized";
        double latitude = -48.383494;
        double longitude = 48.427362;
        // Create Request Object for adding Place
        Location location = new Location();
        location.setLat(latitude);
        location.setLng(longitude);

        List<String> types = new ArrayList<String>();
        types.add("Amit shoe park");
        types.add("Amit shop");

        AddPlace addPlace = new AddPlace();
        addPlace.setLocation(location);
        addPlace.setAccuracy(50);
        addPlace.setName(nameOfAddress);
        addPlace.setPhone_number("(+91) 000 000 0000");
        addPlace.setAddress(initialAddress);
        addPlace.setTypes(types);
        addPlace.setWebsite("http://google.com");
        addPlace.setLanguage("Deutsch");

        // Create an Object to capture response

        GetPlace getPlace = new GetPlace();


        String response = given().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(addPlace).when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server",equalTo("Apache/2.4.18 (Ubuntu)")).extract().response().asString();

        //Lets parse String as JSON
        JsonPath jsonPath = ReusableMethods.getRawToJSON(response);
        String placeId = jsonPath.get("place_id");
        System.out.println("PlaceID = " +  placeId);

        getPlace = given().queryParam("key","qaclick123").queryParam("place_id",placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().as(GetPlace.class);

        String actualAddress = getPlace.getAddress();
        System.out.println("actualAddress = " +  actualAddress);
        Assert.assertEquals(actualAddress,initialAddress);
        String actualPlaceName = getPlace.getName();
        Assert.assertEquals(actualPlaceName,nameOfAddress);
        Assert.assertEquals(getPlace.getLocation().getLatitude(),latitude,0.0);
        Assert.assertEquals(getPlace.getLocation().getLongitude(),longitude,0.0);
    }

}
