package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequests {
	
	String id;
	
	@Test(priority=1)
	void singleUser() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users/2")
		
		.then()
			.statusCode(200)
			.body("data.email", equalTo("janet.weaver@reqres.in"))
			.log().all(); 
			
		
	}
	
	@Test(priority=2)
	void createUser() {
		
		HashMap hm = new HashMap();
		hm.put("name", "Khabib");
		hm.put("job", "MMA");
		
		id=given()
			.contentType("application/json")
			.body(hm)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getString("id");
		
/*		.then()
			.statusCode(201)
			.log().all();
*/		
		
	}
	
	@Test(priority=3, dependsOnMethods= {"createUser"})
	void updateUser() {
		
		HashMap hm = new HashMap();
		hm.put("name", "Khabib");
		hm.put("job", "Airlines");
		
		given()
			.contentType("application/json")
			.body(hm)
		
		.when()
			.put("https://reqres.in/api/users/" + id)

		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=4)
	void deleteUser() {
		
		given()
		
		.when() 
			.delete("https://reqres.in/api/users/" + id)
		
		.then()
			.statusCode(204)
			.log().all();
		
	}
	
	
}
