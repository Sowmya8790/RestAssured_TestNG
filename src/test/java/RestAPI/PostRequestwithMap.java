package RestAPI;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestwithMap {
	
	@Test
	public void test4()
	{
		
		HashMap<String,Object> mapoj = new HashMap<String,Object>();
		mapoj.put("name", "Lavanya");
		mapoj.put("salary", "9000000");
		
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(mapoj).post("/employees/create");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}

}
