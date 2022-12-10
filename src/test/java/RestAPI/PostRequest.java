package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void test3() {
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body("{\r\n"
				+ "    \"name\": \"Sowmya Sri\",\r\n"
				+ "    \"salary\":\"10000000\"\r\n"
				+ "} ").post("employees/create");
		System.out.println(response.getBody().asString());
		int Statuscode = response.getStatusCode();
		Assert.assertEquals(Statuscode, 201);
		
		//String responsebody = response.getBody().asString();
		
	}

}
