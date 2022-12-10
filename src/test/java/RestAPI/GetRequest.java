package RestAPI;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification request = RestAssured.given();
		Response response = request.get("employees");
		System.out.println("here is the reponse : " +response.getBody().asString());
		
		JsonPath jpath = response.jsonPath();
		List<String> names = jpath.get("name");
		List<Integer> salary = jpath.get("salary");
		List jok =jpath.get();
		System.out.println(names.size());
		
		for(int i=0;i<names.size();i++) {
			
			System.out.println(names.get(i) +" " + " Salary is : " + salary.get(i));
		}
		
	
		
	}

}
