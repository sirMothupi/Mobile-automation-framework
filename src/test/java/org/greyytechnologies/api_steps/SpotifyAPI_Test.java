package org.greyytechnologies.api_steps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SpotifyAPI_Test
{
    public static void main(String[] args)
    {
        //Mention endpoint
        RestAssured.baseURI = "https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc";

        //To get existing response from the endpoint, hence we use the get() method
        Response response = RestAssured.get();
        //I want to print response in my console
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

    }
}
