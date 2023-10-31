package apiTesting;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;


public class JiraTest {

	
	public String loginTest() {
		
		RestAssured.baseURI = "http://localhost:8080/";
		
		String Response =given().header("content-type","application/json")
		.body(Payload.JiraLogin()).when().post("rest/auth/1/session")
		.then().assertThat().statusCode(200).extract()
		.response().asString();
		
		System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		String Cookie =js.get("session.value");
//		System.out.println(Value);
		return Cookie;
		
		
	}
	
	@Test
	public void AddComment() {
		String Cookie = loginTest();
		System.out.println(Cookie);
		RestAssured.baseURI = "http://localhost:8080/";
		String Response = given()
				.header("content-type","application/json","Cookie", "jsessionID="+Cookie+"").log().all()
				.body(Payload.JiraAddComment()).when().post("rest/api/2/issue/10110/comment")
				.then().assertThat().statusCode(201).extract().response().asString();
		
		System.out.println(Response);
	}
	@Test
	public void Addcomment2() {
		
		RestAssured.baseURI = "http://localhost:8080/";
		SessionFilter session = new SessionFilter();
		
		given().header("content-type","application/json")
		.body(Payload.JiraLogin()).filter(session)
		.when().post("rest/auth/1/session")
		.then().assertThat().statusCode(200);
		
		String Response = given()
				.header("content-type","application/json").log().all().pathParam("key", "10110")
				.body(Payload.JiraAddComment()).filter(session).when().post("rest/api/2/issue/{key}/comment")
				.then().assertThat().statusCode(201).extract().response().asString();
		
		//Attachemnt
		
		given().header("X-Atlassian-Token","no-check").filter(session).pathParam("key", "10110").log().all()
		.multiPart("file",new File("C:\\Users\\Admin\\git\\APITesting1\\APITesting\\src\\test\\java\\files\\Test.txt"))
		.when().post("rest/api/2/issue/{key}/attachments")
		.then().assertThat().statusCode(200);
		
		
		
		
		
	}
}
