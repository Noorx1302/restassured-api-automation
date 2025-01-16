package day3;

import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateUserChaining {
	
	@Test
	void createUser(ITestContext context) {
		
		Faker fakeData = new Faker();
		PojoClassForReqBody data = new PojoClassForReqBody();
		
		data.setName(fakeData.name().name());
		data.setGender("Male");
		data.setEmail(fakeData.internet().emailAddress());
		data.setStatus("Active");
		
		
		String bearerToken = "5e1d25207986ca4303fd55d99b1c519cac84b3103bde34704ab424488ad3226b";
		
		
		Response resp = given()
			.contentType("application/json")
			.auth()
			.oauth2(bearerToken)
			.body(data)
			
			.when()
			.post("https://gorest.co.in/public/v2/users");
		
		int id = resp.jsonPath().getInt("id");
		System.out.println(id);
		
		context.setAttribute("user_id", id);
		
	}
	
}
