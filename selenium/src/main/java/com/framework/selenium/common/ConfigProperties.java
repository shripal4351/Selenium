package com.framework.selenium.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	
	private static Properties configProperties;
	
	private ConfigProperties() throws IOException{
		synchronized(this) {
			if(!(configProperties instanceof Properties)) {
				FileInputStream configFile = new FileInputStream(System.getProperty("propertyFilePath") + File.separator + System.getProperty("propertyFileName"));
				configProperties = new Properties();
				configProperties.load(configFile);
			}
		}
	}
	
	public static Properties getConfigProperties() throws IOException{	
		if(!(configProperties instanceof Properties)) {
			new ConfigProperties();
		}
		return configProperties;
	}
}
