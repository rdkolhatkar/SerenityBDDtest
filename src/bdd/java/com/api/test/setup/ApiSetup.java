package com.api.test.setup;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiSetup {

    public static String readJsonFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public void invokeAddPlaceApi() throws IOException {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String jsonFilePath = "src/bdd/resources/Data/AddPlaceApi.json";

        // Read JSON file content as a String
        String requestBody = readJsonFile(jsonFilePath);

       String response =  given().log().all().queryParam("key","qaclick123")
                .header("Content-Type", "application/json")
                .body(requestBody).when().post("/maps/api/place/add/json")
                // Validating the API Response body
                .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
                // Validation of Response Headers
                .header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

        System.out.println(response);
        // Now we have to parse the extracted Json response to retrieve the placeID
        JsonPath jsonPath = new JsonPath(response); //JsonPath method is used to Parse the Json
        String placeIdValue = jsonPath.getString("place_id");
        System.out.println("place_id = "+placeIdValue);
    }

    // Add Place and Update Place and then validate if new address is present in response or not



}
