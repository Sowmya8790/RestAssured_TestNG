package RestAPI;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequest {
	
	@Test
	public void test7() {
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		hmap.put("salary", "500090");
		
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(hmap).patch("employees/39");
		
		System.out.println(response.getBody().asString());
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

}
