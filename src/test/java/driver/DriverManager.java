package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void setDriver(WebDriver drv) {
		driver.set(drv);
	}
	
	public static void unload() {
		driver.remove();
	}
}
