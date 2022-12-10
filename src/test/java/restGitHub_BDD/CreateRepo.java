package restGitHub_BDD;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateRepo {
	
	@Test
	public void test1() {
		
		File tokenfile = new File("GitData.json");
		
		RestAssured.given()
					.auth()
					.oauth2("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")
					.baseUri("https://api.github.com")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(tokenfile)
					.when()
					.post("user/repos")
					.then()
					.log()
					.all()
					.statusCode(201);
					
					
					
		
	}

}
