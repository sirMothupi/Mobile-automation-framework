package org.greyytechnologies.api_steps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class GetRespectiveCurrency
{
    public static void main(String[] args)
    {
        //Mention endpoint
        RestAssured.baseURI = "https://v6.exchangerate-api.com/v6/4ee631bf296375968b750e54/latest/USD";

        //To get existing response from the endpoint, hence we use the get() method
        Response response = RestAssured.get();
        //I want to print response in my console
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        //x.conversation_rates_TWD
        double double1 = jsonPath.getDouble("conversation_rates.TWD");
        System.out.println(double1);
    }
}
