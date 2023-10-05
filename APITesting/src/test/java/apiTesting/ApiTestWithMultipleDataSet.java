package apiTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.TestUtil;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTestWithMultipleDataSet {

	@DataProvider
	public Iterator<Object[]> getTestDataProvider() throws Exception {
		ArrayList<Object[]> data = TestUtil.getTestData();
		return data.iterator();
	}
	
	@Test(dataProvider="getTestDataProvider")	
	public void Test1(String Lat, String Long, String Accuracy, String Name, String PhoneNumber, String Address, String Website, String Language) {
		
		//Post Api
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	String Response1=
	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body(Payload.AddPlace(Lat,  Long,  Accuracy,  Name,  PhoneNumber,  Address,  Website,  Language))
	.when().post("maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
	.extract().response().asString();
	
	JsonPath js = new JsonPath(Response1);
	System.out.println(js.getString("place_id"));
	String Place = js.getString("place_id");
	
	
	
	//Get
			String GetResponse=
			given().queryParams("key", "qaclick123","place id",Place)
			.when().get("maps/api/place/get/json")
			.then().assertThat().statusCode(200)
			.extract().response().asString();
			
			System.out.println(GetResponse);
			JsonPath jsget = new JsonPath(GetResponse);
			
		
			
			System.out.println("Name is :"+Name);
			System.out.println("Address is :"+Address);
			
			assertEquals(jsget.getString("address"),Address);
	}
	
	
	
	
}
