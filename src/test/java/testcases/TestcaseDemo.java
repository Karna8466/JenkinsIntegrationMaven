package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginDemoPage;
import pages.Pracpage;
import utilities.Dataprov;
import utilities.TestListners;
import utilities.Screeshot;

@Listeners(utilities.TestListners.class)
public class TestcaseDemo extends BaseTest {
	
	
	@Test(priority = 0, dataProvider = "Logindata", dataProviderClass = Dataprov.class)
	//@Test(priority = 0)
	public void testLogin(String Username, String Password) {
	//public void testLogin() {
	System.out.println("Username :" +Username+ "Password :" +Password);
		
		System.out.println("This is a test Login.");
		LoginDemoPage login = new LoginDemoPage(driver);
		login.enterusername(Username);
		login.enterpassword(Password);
		login.loginclk();
//		driver.findElement(By.id("username")).sendKeys("student");
//		driver.findElement(By.id("password")).sendKeys("Password123");
//		driver.findElement(By.id("submit")).click();
		//Parctice page
		//Pracpage prac = new Pracpage(driver);
		//prac.practicelk();
		
		
	}
	
	@Test(priority = 1, dependsOnMethods = "testLogin")
	
	public void testprac() {
		System.out.println("This is a test practice.");
		Pracpage prac = new Pracpage(driver);
		prac.practicelk();
		//driver.findElement(By.xpath("//a[text() = 'Practice']")).click();
	}
	@Test(priority = 2, dependsOnMethods = "testLogin")
	public void getTitle() throws InterruptedException {
		System.out.println("The title of the page is: " + driver.getTitle());
		WebElement titleElement = driver.findElement(By.xpath("//h1[text() = 'Practice']"));
		Assert.assertEquals(titleElement.getText(), "Practice", "Title does not match!");
		System.out.println("The title of the page is: " + titleElement.getText());
		
		Thread.sleep(3000);
	}
	@Test(priority = 3, enabled  = true)
	public void testlogout() {
		System.out.println("This is a test Logout.");
		
		driver.findElement(By.xpath("//a[text() = 'Log out']")).click();
	}

}
