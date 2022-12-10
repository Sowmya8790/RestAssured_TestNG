package RestAPIXML;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XMLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://chercher.tech/sample/api/books.xml";
		RequestSpecification request =RestAssured.given();
		Response response = request.get();
		
		System.out.println(response.getBody().asString());
		
		// extract all the title in xml
		
		NodeChildrenImpl alltitle = response.then().extract().path("bookstore.book.title");
		// System.out.println(alltitle);   //get all the title
		System.out.println("The First title in xml is :" +alltitle.get(0));  // to get particular title
		System.out.println("The Second title in xml is :" +alltitle.get(1)); 
		
		System.out.println("First book language is : " +alltitle.get(0).getAttribute("lang"));
		System.out.println("Second book language is : " +alltitle.get(0).getAttribute("lang"));
		

	}

}
