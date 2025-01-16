package day3;

import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetUserChaining {
	
	@Test
	void testGetUser(ITestContext context) {
		
		String token = "5e1d25207986ca4303fd55d99b1c519cac84b3103bde34704ab424488ad3226b";
		int id = (Integer) context.getAttribute("user_id");
		
		given()
			.auth()
			.oauth2(token)
			.pathParam("id", id)
			.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
			.then()
			.statusCode(200)
			.log().all();
		
	}

}
