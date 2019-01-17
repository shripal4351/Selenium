package com.test;

import java.io.IOException;
import org.testng.annotations.AfterTest;
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
		super.initializeDriver();
		super.driver.get("https://www.saucedemo.com/index.html");
	}
	
	@Test
	public void firstTest(){
		
		SauceDemoLandingPage objSauceDemoLandingPage = (SauceDemoLandingPage)AppPageFactory.getPageObject(SauceDemoLandingPage.class, super.driver);
		objSauceDemoLandingPage.setUserName("asdf");//
		objSauceDemoLandingPage.setPassword("asdf");
		objSauceDemoLandingPage.clickLogin();
	}
	
	@AfterTest
	public void cleanup() {
		super.driver.quit();
	}

}
