package com.framework.selenium.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

	private static Properties configProperties;

	private ConfigProperties() throws IOException {
		FileInputStream configFile = new FileInputStream("src/main/resources/config.properties");
		configProperties = new Properties();
		configProperties.load(configFile);
	}

	public static synchronized Properties getConfigProperties() {

		if (!(configProperties instanceof Properties)) {
			try {
				new ConfigProperties();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return configProperties;
	}

	public String getValue(String key) {
		return configProperties.getProperty("key");
	}
}
