package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDemoPage {
	
	WebDriver driver;
	
	public LoginDemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username")
	WebElement usernameField;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(id = "submit")
	WebElement submitBtn;
	
	
	public void enterusername(String user) {
		usernameField.sendKeys(user);		
	}
	public void enterpassword(String pass) {
		passwordField.sendKeys(pass);
	}
	public void loginclk() {
		submitBtn.click();
	}

}
