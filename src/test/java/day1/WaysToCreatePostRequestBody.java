package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class WaysToCreatePostRequestBody {
	
	@Test(priority=1)
	void postReqUsingHashmap() {
		
		HashMap hm = new HashMap();
		hm.put("name", "Rushikesh");
		hm.put("job", "Carpenter");
		
		given()
			.contentType("application/json")
			.body(hm)
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Rushikesh"))
			.body("job", equalTo("Carpenter"))
			.log().all();
	}
	
	@Test(priority=2)
	void postReqUsingOrgJson() {
		
		JSONObject data = new JSONObject();
		data.put("name", "Muzammil");
		data.put("job", "Bike washer");
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Muzammil"))
			.body("job", equalTo("Bike washer"))
			.log().all();
	}
	
	
	@Test(priority=3)
	void postReqUsingPOJOClass() {
		
		POJO_PostReq data = new POJO_PostReq();
		data.setName("Me");
		data.setJob("QA");
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Me"))
			.body("job", equalTo("QA"))
			.log().all();
	}
	
	
	@Test(priority=3)
	void postReqUsingjsonfile() throws FileNotFoundException {
		
		File myFile = new File(".\\testbody.json");
		
		FileReader reader = new FileReader(myFile);
		
		JSONTokener jt = new JSONTokener(reader);
		
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Zuckerberg"))
			.body("job", equalTo("Facebook co-founder"))
			.log().all();
	}
	
}
