package framework.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base {
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {

		// read config properties file
		FileInputStream fis = new FileInputStream("C:\\shripal\\java\\workspace\\selenium\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		String chromeDriverPath = prop.getProperty("driver.path.chrome");
		int implicitlyWaitTimeOut = Integer.parseInt(prop.getProperty("implicitly.wait.timeout"));

		switch (browserName) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(implicitlyWaitTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;

	}

}
