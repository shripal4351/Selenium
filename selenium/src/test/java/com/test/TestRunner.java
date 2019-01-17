package com.test;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.framework.selenium.common.ExcelUtil;

public class TestRunner {
	
	public static void main(String[] args){
		
		System.out.println("####################################################");
		System.out.println("value is ---" + System.getProperty("myproperty"));
		
		//The below example can be understood from http://testng.org/doc/documentation-main.html#running-testng-programmatically
		XmlSuite suite = new XmlSuite();
		suite.setName("TestSuite");//it will create <suite name="TestSuite" >
		
		XmlTest test = new XmlTest(suite);
		test.setName("Test");// it will create <test name="Test">
		
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.test.SauceDemoTest"));
		test.setXmlClasses(classes);//it will create <class name="test.failures.Child"  /> under <classes>
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
		
		/*ExcelUtil excel = new ExcelUtil();
		excel.setExcelPath("D:/Technical/Projects/Selenium/selenium/src/main/resources/Test.xlsx");
		excel.setExcelSheetName("testing");
		excel.getExcelData();*/
	}
}
