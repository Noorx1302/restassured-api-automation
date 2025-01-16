package day2;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.module.jsv.JsonSchemaValidator;

import org.testng.annotations.Test;

import day1.POJO_PostReq;

public class JSONSchemaValidation {
	
	@Test
	void jsonSchemeValidation() 
	{
		
		POJO_PostReq data = new POJO_PostReq();
		data.setId(321);
		data.setUsername("Me123");
		data.setFirstname("MMsws");
		data.setLastname("MMeuixjsws");
		data.setEmail("MM123@gmail.com");
		data.setPassword("MM123!w");
		data.setPhone("9988776655");
		data.setUserstatus(2);
		
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://petstore.swagger.io/v2/user")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("petstorejsonschema.json"));
		
	}
	
	
}
