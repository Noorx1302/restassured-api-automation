package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class PathAndQueryParameters {
	
	@Test
	void testQueryAndPathParams()
	{
		given()
			.pathParam("myPath", "users")
			.queryParam("page", 2)
		
		.when()
			.get("https://reqres.in/api/{myPath}")
		
		.then()
			.statusCode(200)
			.log().all();
	}
}
