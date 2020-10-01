package RestAssured.files;

/**
 * Create by Amit on 9/23/20
 */
public class payload {

    public static String AddPlace(){
        return "{\n" +
        "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Amits House in Germany\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"Einsteinstr. Munchen 81800\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }

    public static String AddPlace2(String name, String address){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \""+ name +"\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \""+ address +"\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }

    public static String UpdateAddress(){
       return  "{\n" +
                "\"place_id\":\"<PLACE_ID>\",\n" +
                "\"address\":\"<ADDRESS>>\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }

    public static String deleteAddress(String placeID){
        return "{\n" +
                "    \"place_id\":\""+placeID+"\"\n" +
                "}";
    }

    public static String ComplexJsonObject(){
       return "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 910,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";
    }


    public static String Addbook(){
        String text = "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java - Amit2\",\n" +
                "\"isbn\":\"xxxX\",\n" +
                "\"aisle\":\"250\",\n" +
                "\"author\":\"Amit K\"\n" +
                "}\n";
        return text;
    }


}
