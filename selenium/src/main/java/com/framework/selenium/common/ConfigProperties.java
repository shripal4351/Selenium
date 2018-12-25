package com.framework.selenium.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	
	private static Properties configProperties;
	
	private ConfigProperties() throws IOException{
		FileInputStream configFile = new FileInputStream("src/main/resources/config.properties");
		configProperties = new Properties();
		configProperties.load(configFile);
	}
	
	public static Properties getConfigProperties() throws IOException{
		
		if(!(configProperties instanceof Properties)) {
			new ConfigProperties();
		}
		
		return configProperties;
	}
}
