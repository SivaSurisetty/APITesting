package apiTesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.TestUtil;
public class LibraryApi {

	@DataProvider
	public Iterator<Object[]> getTestData() throws IOException{
		ArrayList<Object[]> data = TestUtil.LibraryApiTestData();
		return data.iterator();
	}
	
	@Test(dataProvider ="getTestData")
	public void DynamicJson(String name,String isbn,String aisle,String author) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		String Response =given().
		header("Content-Type", "application/json").
		body(Payload.libraryData(name, isbn, aisle, author))
				.post("/Library/Addbook.php").then().assertThat().statusCode(200)
				.extract().response().asString();
		
		System.out.println(Response);
		
		JsonPath js = new JsonPath(Response);
		
		String BookID = js.get("ID");
		
		
		String GetResponse = given().queryParam("ID",BookID).get("/Library/GetBook.php")
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		
		System.out.println(GetResponse);
		
		//Delete Book
		
		String DelResponse = given().header("Content-Type", "application/json").
				body(Payload.libraryDataDelete(BookID))
				.delete("/Library/DeleteBook.php").then()
				.assertThat().statusCode(200)
				.extract().response().asString();
		System.out.println(DelResponse);
		
		GetResponse = given().queryParam("ID",BookID).get("/Library/GetBook.php")
				.then().assertThat().statusCode(404)
				.extract().response().asString();
		
		System.out.println(GetResponse);
	}
}
