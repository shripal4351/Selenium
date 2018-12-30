package com.framework.selenium.common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	public static WebDriver initializeDriver() {

		String platform = ConfigProperties.getConfigProperties().getProperty("platform");
		String browserName = ConfigProperties.getConfigProperties().getProperty("browser");
		String chromeDriverPath;
		String deviceName,appPath;
		DesiredCapabilities capabilities;

		// web platform
		if (StringUtils.lowerCase(platform).equalsIgnoreCase("web")) {
			switch (browserName) {
			case "chrome":
				chromeDriverPath = ConfigProperties.getConfigProperties().getProperty("driver.path.chrome");
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				return new ChromeDriver();
			default:
				chromeDriverPath = ConfigProperties.getConfigProperties().getProperty("driver.path.chrome");
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				return new ChromeDriver();
			}
		} else if (StringUtils.lowerCase(platform).equalsIgnoreCase("mobile")) {
			switch (browserName) {
			case "android":
				capabilities = new DesiredCapabilities();
				deviceName = ConfigProperties.getConfigProperties().getProperty("device.Name");
				appPath = ConfigProperties.getConfigProperties().getProperty("app.Path");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				capabilities.setCapability(MobileCapabilityType.APP,appPath);
				try {
					return new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			default:
				capabilities = new DesiredCapabilities();
				deviceName = ConfigProperties.getConfigProperties().getProperty("device.Name");
				appPath = ConfigProperties.getConfigProperties().getProperty("app.Path");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				capabilities.setCapability(MobileCapabilityType.APP,appPath);
				try {
					return new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
