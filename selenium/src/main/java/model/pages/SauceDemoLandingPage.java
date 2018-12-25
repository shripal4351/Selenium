package model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLandingPage extends AbstractPage{

	private WebDriver driver;
	
	private static SauceDemoLandingPage demoPage;
	
	private SauceDemoLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement txtUserName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@type='submit' and @value='LOGIN']")
	private WebElement btnLogin;
	
	public void setUserName(String strUserName) {
		txtUserName.sendKeys(strUserName);
	}
	
	public void setPassword(String strPassword) {
		txtPassword.sendKeys(strPassword);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public static SauceDemoLandingPage getPage(WebDriver driver) {
		if(!(demoPage instanceof SauceDemoLandingPage)) {
			demoPage = new SauceDemoLandingPage(driver);
		}
		return demoPage;
	}
}
