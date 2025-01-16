package day2;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SerializationAndDeserialization {
	
//	@Test
	void convertPojoToJson() throws JsonProcessingException
	{
		
		PojoClassTest data = new PojoClassTest();
		data.setId(102);
		data.setUsername("John102");
		data.setFirstname("John");
		data.setLastname("Wick");
		data.setEmail("John102@gmail.com");
		data.setPassword("John102!");
		data.setPhone("9988776611");
		data.setUserstatus(1);
		
		ObjectMapper obj = new ObjectMapper();
		String jsonData = obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		
		System.out.println(jsonData);
		
	
		
		
		
	}
	
	@Test
	void convertJsonToPojo() throws JsonProcessingException
	{
		String jsonData = "{\r\n"
				+ "  \"id\" : 102,\r\n"
				+ "  \"username\" : \"John102\",\r\n"
				+ "  \"firstname\" : \"John\",\r\n"
				+ "  \"lastname\" : \"Wick\",\r\n"
				+ "  \"email\" : \"John102@gmail.com\",\r\n"
				+ "  \"password\" : \"John102!\",\r\n"
				+ "  \"phone\" : \"9988776611\",\r\n"
				+ "  \"userstatus\" : 1\r\n"
				+ "}";
		
		ObjectMapper obj = new ObjectMapper();
		PojoClassTest pj = obj.readValue(jsonData, PojoClassTest.class);
		System.out.println("email: " + pj.getEmail());
		
	
		
		
		
	}
	
	
}
