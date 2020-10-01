package RestAssured;

import io.restassured.path.json.JsonPath;

/**
 * Create by Amit on 9/24/20
 */
public class ReusableMethods {

    public static JsonPath getRawToJSON(String text){

        JsonPath jsonText = new JsonPath(text);
        return jsonText;
    }
}
