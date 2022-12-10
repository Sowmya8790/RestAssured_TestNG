package RestAPIXML;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class XmlExample {

	@Test
	public void test1() {
		
		RestAssured.baseURI = "https://chercher.tech/sample/api/books.xml";
		RequestSpecification request =RestAssured.given();
		Response response = request.get();
		
		System.out.println(response.getBody().asString());
	
		
		
	}
}
