package day2;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakeDataGenerator {
	
	@Test
	void testFaker() {
		
		Faker fakedata = new Faker();
		PojoClassTest data = new PojoClassTest();
		
		
		data.setId(103);
		data.setUsername(fakedata.name().username());
		data.setFirstname(fakedata.name().firstName());
		data.setLastname(fakedata.name().lastName());
		data.setEmail(fakedata.internet().emailAddress());
		data.setPassword(fakedata.internet().password());
		data.setPhone(fakedata.phoneNumber().cellPhone());
		data.setUserstatus(1);
		
		System.out.println(data);
		
	}
	
	
}
