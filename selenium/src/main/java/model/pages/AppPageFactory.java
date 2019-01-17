package model.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class AppPageFactory {
	
	public static AbstractPage getPageObject(Class<? extends AbstractPage> pageClass, WebDriver driver) {
		
		AbstractPage classObject = null;
		String pageClassName = pageClass.getSimpleName();
		
		switch(StringUtils.capitalize(pageClassName)) {
		
			case"SauceDemoLandingPage":
				classObject = SauceDemoLandingPage.getPage(driver);
		}
		
		return classObject;
	}
}
