package RestAssured;

import RestAssured.files.payload;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Create by Amit on 9/24/20
 */
public class JsonParsing {

    public static void main(String[] args) {

/*
        1. Print No of courses returned by API

        2.Print Purchase Amount

        3. Print Title of the first course

        4. Print All course titles and their respective Prices

        5. Print no of copies sold by RPA Course

        6. Verify if Sum of all Course prices matches with Purchase Amount
*/

        String msg = payload.ComplexJsonObject();
        JsonPath path = new JsonPath(msg);
//        System.out.println(path.get("courses").toString());

        int numberOfCourse = path.get("courses.size()");
        System.out.println("Number of Courses returned = " + numberOfCourse);

        System.out.println("Purchase Amount = " + path.get("courses[0].price"));
        ArrayList<LinkedHashMap> courses = path.get("courses");

//        3. Print Title of the first course
        System.out.println("Title of the first course = " + path.get("courses[0].title"));

//        4. Print All course titles and their respective Prices
        for (int i = 0; i < numberOfCourse ; i++) {
            System.out.println("Course = " + path.get("courses["+i+"].title") + ", its price = " + path.get("courses["+i+"].price"));
        }

//        5. Print no of copies sold by RPA Course
        for (int i = 0; i < numberOfCourse ; i++) {
            int totalPrice =  Math.multiplyExact(path.get("courses["+i+"].price"), path.get("courses["+i+"].copies"));
            String Title = path.get("courses["+i+"].title");
            if(Title.equals("RPA")){
                System.out.println("Number of Copies sold of RPA = " + path.get("courses["+i+"].copies"));
                break;
            }
        }

//        6. Verify if Sum of all Course prices matches with Purchase Amount

        int expectedTotalPurchaseAmount = path.get("dashboard.purchaseAmount");
        int totalPurchaseAmount = 0;
        for (int i = 0; i < numberOfCourse ; i++) {
            int totalPrice =  Math.multiplyExact(path.get("courses["+i+"].price"), path.get("courses["+i+"].copies"));
            totalPurchaseAmount += totalPrice;
        }
        System.out.println("totalPurchaseAmount =  " + totalPurchaseAmount);
        Assert.assertEquals(expectedTotalPurchaseAmount,totalPurchaseAmount);


//        for(LinkedHashMap<String,String> element: courses){
//            System.out.println("Title = " + element.get("title"));
//            System.out.println( element.get("price"));
//        }


    }
}
