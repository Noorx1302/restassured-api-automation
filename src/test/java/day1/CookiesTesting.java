package day1;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesTesting {
	
//	@Test
	void testCookies() {
		
		Response resp = given()
							.when()
								.get("https://www.google.com/");
		
		String cookieAec = resp.getCookie("AEC");
		System.out.println(cookieAec);
		
		Map<String, String> allCookies = resp.getCookies();
		
		for(String k : allCookies.keySet()) {
			String cookie_value = resp.getCookie(k);
			System.out.println(k + " = " + cookie_value);
		}
	}
	
	
//	@Test
	void testHeaders() {
		
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
				.statusCode(200)
				.header("Content-Type", "application/json")
				.body("code", equalTo(321))
				.log().all();
				
	}
	
	
	@Test
	void testBody() {
		
		POJO_PostReq data = new POJO_PostReq();
		data.setId(321);
		data.setUsername("Me123");
		data.setFirstname("MMsws");
		data.setLastname("MMeuixjsws");
		data.setEmail("MM123@gmail.com");
		data.setPassword("MM123!w");
		data.setPhone("9988776655");
		data.setUserstatus(2);
		
		
		
		Response res = given()
						.contentType("application/json")
						.body(data)
						.when()
						.post("https://petstore.swagger.io/v2/user");
		Assert.assertEquals(res.getStatusCode(), 200);
		
		String codeValue = res.jsonPath().get("message");
		
		Assert.assertEquals(codeValue, "321");
		
		
				
	}

}
