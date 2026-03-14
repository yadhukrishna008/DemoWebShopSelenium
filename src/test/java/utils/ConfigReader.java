package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
	String myApp;
	static String browser_properties, browser_maven;
	private static Properties prop= new Properties();
	static String config_path= System.getProperty("user.dir") + "/src/test/resources/configs/";
	
	static {
		try {		
			FileInputStream config_fis = new FileInputStream(config_path + "global.properties");
			prop.load(config_fis);
			config_fis.close();
		} catch (Exception e) {
			System.out.println("Config file not found. Skipping...");
		}
		
		try {
			FileInputStream cred_fis = new FileInputStream(config_path + "credentials.properties");
			prop.load(cred_fis);
			cred_fis.close();		
		} catch (Exception e) {
			System.out.println("Credentials file not found. Skipping...");
		}
	}
	
	
    public static String getBrowser() throws IOException {
    	browser_properties= prop.getProperty("browser");
		browser_maven= System.getProperty("browser");
		
		return browser_maven==null?browser_properties:browser_maven;
    }
     
    public static String getUrl() {
    	return prop.getProperty("QAUrl");
    }
    
    public static String getUserName(String user) throws IOException {
    	return prop.getProperty(user);
    }
    
    public static String getPassword(String password) throws IOException {
    	return prop.getProperty(password);
    }
    
}
