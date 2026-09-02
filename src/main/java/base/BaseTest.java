package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		System.out.println("Setting up the test environment.");
		
		ConfigReader.loadProperties();
		//driver = new ChromeDriver();
		String browser = ConfigReader.getProperty("browser");
		String url = ConfigReader.getProperty("url");
		String timeout = ConfigReader.getProperty("timeout");
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(Long.parseLong(timeout)));
		driver.get(url);
		
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if(driver != null) {
		
			driver.quit();
		}
		
	}
	public WebDriver getDriver() {
        return driver;
	}
	

}
