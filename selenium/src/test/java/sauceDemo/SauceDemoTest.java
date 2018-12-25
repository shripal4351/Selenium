package sauceDemo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.selenium.Base;
import pageObjects.SauceDemoLandingPage;

public class SauceDemoTest extends Base {
	
	//log4j
	//private static Logger log = LogManager.getLogger(SauceDemoTest.class.getName());
	
	@Test
	public void firstTest() throws IOException, InterruptedException {
		
		//call method to initialize driver
		initializeDriver();

		// launch browser
		driver.get("https://www.saucedemo.com/index.html");

		// wait for 5 seconds
		Thread.sleep(5000);

		//create object for saucedemolandingpage class
		SauceDemoLandingPage objSauceDemoLandingPage = new SauceDemoLandingPage(driver);
		
		objSauceDemoLandingPage.setUserName("asdf");
		objSauceDemoLandingPage.setPassword("asdf");
		objSauceDemoLandingPage.clickLogin();
		
		// driver.close();
		// driver.quit();
	}

}
