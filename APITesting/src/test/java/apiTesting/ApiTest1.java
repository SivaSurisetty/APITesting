package apiTesting;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ApiTest1 {

	
	@Test
	public void Test1() {
		
		JsonPath js = new JsonPath(Payload.Test());
		
		System.out.println(js.getString("dashboard.purchaseAmount"));
		System.out.println(js.getString("dashboard.website"));
		
		System.out.println(js.getInt("dashboard.purchaseAmount"));
		
		//print courses count
		
		int Coursecount = js.getInt("courses.size()");
		System.out.println("Courses : "+Coursecount);
		
		//Print first course Name
		
		System.out.println(js.getString("courses[0].title"));
		
		//print all course titles and their respective prices
		
		for(int i=0;i<Coursecount;i++) {
			System.out.println(js.getString("courses["+i+"].title"));
		}
		
		//print no of copies sold by RPA course
		
		for(int i=0;i<Coursecount;i++) {
			if(js.getString("courses["+i+"].title").equals("RPA")) {
				System.out.println(js.getInt("courses["+i+"].copies"));
			}
		}
		
		//Verify sum
		int sum =0;
		int a,b;
		for(int i=0;i<Coursecount;i++) {
			a= js.getInt("courses["+i+"].price");
			b= js.getInt("courses["+i+"].copies");
			sum = sum+(a*b);
		}
//		System.out.println(sum);
		
		assertTrue(sum == js.getInt("dashboard.purchaseAmount"));
		
				
		
		
		
	}
}
