package utilities;

import org.testng.annotations.DataProvider;

public class Dataprov {
	@DataProvider(name = "Logindata")

	public Object[][] Logindata() {
		return new Object[][] {
			{"Student1", "Student1256" }, 
			{"Student2", "Student33"},
			{"student", "Password123"}
		};
		
	}

}
