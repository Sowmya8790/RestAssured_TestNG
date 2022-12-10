package APIBDD;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	
	@Test
	public void Test2(){
		
		HashMap<String, Object> hmap = new HashMap<String,Object>();
		hmap.put("name", "ajiii");
		hmap.put("salary", "30000");
		
		RestAssured.given()
					.baseUri("http://localhost:3000")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(hmap)
					.when()
					.post("employees/create")
					.then()
					.log()
					.all()
					.statusCode(201)
					.body("name", Matchers.equalTo("ajiii"));
					
		
	}

}
