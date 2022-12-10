package RestAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestwithFileDatadriven {
	
	@Test
	public void test5() throws IOException {
		
	//	byte[] datafile = Files.readAllBytes(Paths.get("data.json")); // can use any of the option to access the file
		
		File datafile = new File("Data.json");
		
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification request =RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(datafile).post("employees/create");
		
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 201);
	}

}
