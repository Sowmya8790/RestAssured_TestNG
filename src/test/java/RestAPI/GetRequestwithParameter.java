package RestAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestwithParameter {
	
	@Test
	public void test2() {
		
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification req = RestAssured.given();
		
		Response response=req.param("id", 2).get("employees");
				
		System.out.println(response.getBody().asString());
		int response_code = response.getStatusCode();
		Assert.assertEquals(200, response_code);
		
		System.out.println(response.getHeader("X-Powered-By").toString());
		System.out.println(response.headers());
		
		String reponseBody = response.getBody().asString();
		Assert.assertTrue(reponseBody.contains("David"));
		
		// above we check only the david present in request but we want at particular position we need the david is present or not
		
		JsonPath jpath = response.jsonPath();
		List<String> names = jpath.get("name");
		System.out.println(names.get(0));
		
		Assert.assertEquals(names.get(0), "David");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
