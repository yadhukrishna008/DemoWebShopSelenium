package driver;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.ConfigReader;

public class TestBase {
	
	@SuppressWarnings("deprecation")
	public static WebDriver initDriver() throws IOException {
		String myBrowser= ConfigReader.getBrowser();
		
		if(DriverManager.getDriver() == null) {
			WebDriver driver;
			MutableCapabilities options;
			switch (myBrowser.toLowerCase()) {
			case "chrome":
				options= new ChromeOptions();
				options.setCapability("browserName", "chrome");
				options.setCapability("browserVersion", "128.0");
				break;
			case "edge":
				options= new EdgeOptions();
				options.setCapability("browserName", "microsoftedge");
				options.setCapability("browserVersion", "127.0");
				break;
			case "firefox":
				options = new FirefoxOptions();
				options.setCapability("browserName", "firefox");
				options.setCapability("browserVersion", "125.0");
				break;
			case "opera":
				// Use ChromeOptions because modern Opera is Chromium-based
			    ChromeOptions operaOptions = new ChromeOptions();
//				options = new ChromeOptions(); // Opera uses ChromeOptions in Selenium 4
			    operaOptions.setCapability("browserName", "opera");
			    operaOptions.setCapability("browserVersion", "109.0");
//			    operaOptions.setCapability(
//						"operaOptions", 
//						Map.of("args", java.util.List.of())
//				);
			    options= operaOptions;
				break;
			default:
                throw new RuntimeException("Invalid Browser: " + myBrowser);
			}
			// Selenoid specific capabilities
			options.setCapability("selenoid:options", Map.of(
		            "enableVNC", true,
		            "enableVideo", true
		    ));
            
            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    options
            );
			driver.manage().window().maximize();
			DriverManager.setDriver(driver);
		}
		return DriverManager.getDriver();
	}

}
