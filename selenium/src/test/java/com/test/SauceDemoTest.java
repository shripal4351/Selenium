package com.test;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.framework.selenium.AbstractTestBase;
import model.pages.AppPageFactory;
import model.pages.SauceDemoLandingPage;

public class SauceDemoTest extends AbstractTestBase {
	
	//log4j
	//private static Logger log = LogManager.getLogger(SauceDemoTest.class.getName());
	
	@BeforeTest
	public void setup() throws IOException {
		//call method to initialize driver
		//super.initializeDriver();
		driver.get("https://www.saucedemo.com/index.html");
	}
	
	@Test
	public void firstTest(){
		
		SauceDemoLandingPage objSauceDemoLandingPage = (SauceDemoLandingPage)AppPageFactory.getPageObject("sauceDemoLandingPage", driver);
		objSauceDemoLandingPage.setUserName("asdf");//
		objSauceDemoLandingPage.setPassword("asdf");
		objSauceDemoLandingPage.clickLogin();
	}
	
	@AfterTest
	public void cleanup() {
		driver.quit();
	}

}
