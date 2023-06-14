package CommonFunctionPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.AfterTest;

public class UtilityCommonFunction {
@AfterTest
	public static void evidencefilecreator(String filename, String responseBody) throws IOException {
		File newfile = new File("C:\\Users\\HP\\Documents\\RestAssuredFramework\\RestAssuredPractice\\"+filename+".doc");
		System.out.println("A new file created: "+newfile.getName());
		
		FileWriter datawrite = new FileWriter(newfile);
		datawrite.write("Response Body: " +responseBody);
		datawrite.close();
	}

}
