package CommonFunctionPackage;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class APICommonFunction {
	
	public static int statusCode(String BaseURI, String resource) 
	{
		RestAssured.baseURI=BaseURI;
		int statusCode= given().header("Content-Type","application/json; charset=utf-8").when().get(resource).then().extract().statusCode();
		return statusCode;
	}
	
	public static String responseBody(String BaseURI, String resource)
	{
		RestAssured.baseURI=BaseURI;
		String responseBody = given().header("Content-Type","application/json; charset=utf-8").when().get(resource).then().extract().response().asString();
		return responseBody;
	}

}
