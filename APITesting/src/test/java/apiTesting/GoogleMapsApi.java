package apiTesting;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GoogleMapsApi {

	//Add place API
	
	//given -- all input details
	//when	--submit the api
	//there	--validate the response
	
	@Test
	public void AddPlace() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Response1=
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.AddPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.extract().response().asString();
		
//		System.out.println(Response1);
		
		JsonPath js = new JsonPath(Response1);
		System.out.println(js.getString("place_id"));
		String Place = js.getString("place_id");
		
		
		//Update
		given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.UpdatePlace(Place))
		.when().put("maps/api/place/update/json")
		.then().assertThat().statusCode(200);
		
		
		//Get
		String GetResponse=
		given().queryParams("key", "qaclick123","place id",Place)
		.when().get("maps/api/place/get/json")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(GetResponse);
		JsonPath jsget = new JsonPath(GetResponse);
		
		String Name = jsget.getString("name");
		String Address = jsget.getString("address");
		
		System.out.println("Name is :"+Name);
		System.out.println("Address is :"+Address);
		
		assertEquals(jsget.getString("address"),"SVR Nivas, Anakapalli");
		
	}
	
	
}
