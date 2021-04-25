package mydataproviders;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

import testbase.TestBase;

public class CustomDataProviders {

	@DataProvider
	public static Object[][] dataTestSuiteA(Method m) throws IOException {
		HashMap<String, String> datarow = new HashMap<String, String>();

		TestBase base = new TestBase();
		datarow = base.ReadExcelFile(System.getProperty("user.dir") + "\\src\\test\\resources", "data.xlsx", "Data",1);
		Object data[][] = null;

		System.out.println(m.getName().toUpperCase());

		if (m.getName().equalsIgnoreCase("verifyPiloNameEmail")) {

			data = new Object[1][4];
			

			// Getting data from Xls file.
			String name = datarow.get("Name");
			String email = datarow.get("Email");
			String mobile = datarow.get("Mobile");
			String description = datarow.get("Description");

			data[0][0] = name;
			data[0][1] = email;
			data[0][2] = mobile;
			data[0][3] = description;

			return data;

		} else if (m.getName().toUpperCase().equalsIgnoreCase("verifyPilomobile")) {

			data = new Object[1][4];
			

			// Getting data from Xls file.
			String name = datarow.get("Name");
			String email = datarow.get("Email");
			String mobile = datarow.get("Mobile");
			String description = datarow.get("Description");

			data[0][0] = name;
			data[0][1] = email;
			data[0][2] = mobile;
			data[0][3] = description;

			return data;

		} else if (m.getName().toUpperCase().equalsIgnoreCase("verifyPilomobile")) {

			data = new Object[1][4];


			// Getting data from Xls file.
			String name = datarow.get("Name");
			String email = datarow.get("Email");
			String mobile = datarow.get("Mobile");
			String description = datarow.get("Description");

			data[0][0] = name;
			data[0][1] = email;
			data[0][2] = mobile;
			data[0][3] = description;

			return data;
		
		
		} else {
			data = new Object[1][4];


			// Getting data from Xls file.
			String name = datarow.get("Name");
			String email = datarow.get("Email");
			String mobile = datarow.get("Mobile");
			String description = datarow.get("Description");

			data[0][0] = name;
			data[0][1] = email;
			data[0][2] = mobile;
			data[0][3] = description;
			
			return data;
		}
		

	}

}
