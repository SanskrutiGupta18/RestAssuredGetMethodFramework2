package TestCasePackage;
import CommonFunctionPackage.APICommonFunction;
import CommonFunctionPackage.UtilityCommonFunction;
import RequestRepository.Get_Method_Repository;
import io.restassured.path.json.JsonPath;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Get_TestClass {
	@Test
	public static void execute() throws IOException {
			
		for(int i=0; i<5; i++)
	{
		int statusCode = APICommonFunction.statusCode(Get_Method_Repository.BaseURI(),Get_Method_Repository.resource());
		System.out.println("Status Code: "+statusCode);
		if(statusCode==200)
		{
		String responseBody = APICommonFunction.responseBody(Get_Method_Repository.BaseURI(),Get_Method_Repository.resource());
		System.out.println("Response Body: "+responseBody);
		Get_TestClass.validator(responseBody);
		UtilityCommonFunction.evidencefilecreator("GetRequestEvidence", responseBody);
		break;
		}
		else
		{
			System.out.println("Status Code found is incorrect therefore retrying the API");
		}
	}
}
		public static void validator(String responseBody) {
			
			JsonPath jsp = new JsonPath(responseBody);
			int productssize = jsp.getList("products").size();
			//System.out.println(productssize);
			
			for(int i=0; i<productssize; i++)
			{
				String id = jsp.getString("products["+i+"].id");
				String title = jsp.getString("products["+i+"].title");
				String description = jsp.getString("products["+i+"].description");
				String price = jsp.getString("products["+i+"].price");
				String discountPercentage = jsp.getString("products["+i+"].discountPercentage");
				String rating = jsp.getString("products["+i+"].rating");
				String stock = jsp.getString("products["+i+"].stock");
				String brand = jsp.getString("products["+i+"].brand");
				String category = jsp.getString("products["+i+"].category");
				String thumbnail = jsp.getString("products["+i+"].thumbnail");
				String images = jsp.getString("products["+i+"].images");
			
				Assert.assertNotNull(id);
				Assert.assertNotNull(title);
				Assert.assertNotNull(description);
				Assert.assertNotNull(price);
				Assert.assertNotNull(discountPercentage);
				Assert.assertNotNull(rating);
				Assert.assertNotNull(stock);
				Assert.assertNotNull(brand);
				Assert.assertNotNull(category);
				Assert.assertNotNull(thumbnail);
				Assert.assertNotNull(images);
				
				Assert.assertTrue(Integer.parseInt(id)>=1 && Integer.parseInt(id)<=5);
				Assert.assertTrue(thumbnail.contains("https://i.dummyjson.com/data/products/"));
			}
			
		}

}
