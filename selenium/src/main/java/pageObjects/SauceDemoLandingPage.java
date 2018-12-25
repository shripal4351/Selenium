package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLandingPage {

	WebDriver driver;

	public SauceDemoLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement txtUserName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@type='submit' and @value='LOGIN']")
	WebElement btnLogin;
	
	public void setUserName(String strUserName) {
		txtUserName.sendKeys(strUserName);
	}
	
	public void setPassword(String strPassword) {
		txtPassword.sendKeys(strPassword);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
}
