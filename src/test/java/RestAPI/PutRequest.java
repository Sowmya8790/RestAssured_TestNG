package RestAPI;

import java.io.File;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {

	@Test
	public void test6() {
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("name", "Vyshu_P");
		hmap.put("salary", "500");
		
		
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification request =RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(hmap).put("employees/39");
		
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
	}
}
