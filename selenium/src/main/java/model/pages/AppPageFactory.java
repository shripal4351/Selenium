package model.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class AppPageFactory {
	
	public static AbstractPage getPageObject(String className, WebDriver driver) {
		
		AbstractPage classObject = null;
		switch(StringUtils.capitalize(className)) {
		
			case"SauceDemoLandingPage":
				classObject = SauceDemoLandingPage.getPage(driver);
		}
		
		return classObject;
	}
}
