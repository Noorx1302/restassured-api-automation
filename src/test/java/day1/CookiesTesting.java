package day1;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesTesting {
	
	@Test
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

}
