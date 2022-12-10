package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deleterequest {
	
	@Test
	public void test8()
	{
		
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request =RestAssured.given();
		Response response = request.delete("employees/3");
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 404);
	}
}
