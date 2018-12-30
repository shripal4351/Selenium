package com.framework.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.framework.selenium.common.ConfigProperties;
import com.framework.selenium.common.DriverFactory;

/**
 * This class is responsible for creating webdriver instance as per the desired
 * browser type. All the test classes will extend it to get the driver object
 */

public class AbstractTestBase {

	//protected WebDriver driver;
	
	protected WebDriver driver = DriverFactory.initializeDriver();

	/*public WebDriver initializeDriver() throws IOException {

		String browserName = ConfigProperties.getConfigProperties().getProperty("browser");
		String chromeDriverPath = ConfigProperties.getConfigProperties().getProperty("driver.path.chrome");
		int implicitlyWaitTimeOut = Integer
				.parseInt(ConfigProperties.getConfigProperties().getProperty("implicitly.wait.timeout"));

		if (StringUtils.lowerCase(browserName).equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.geco.driver", chromeDriverPath);
			this.driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			this.driver = new ChromeDriver();
		}

		this.driver.manage().timeouts().implicitlyWait(implicitlyWaitTimeOut, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();

		return driver;
	}*/

}
