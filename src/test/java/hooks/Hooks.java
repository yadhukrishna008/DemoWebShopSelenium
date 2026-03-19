package hooks;

import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import driver.DriverManager;
import driver.TestBase;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void setUp() throws IOException {
		TestBase.initDriver();
		DriverManager.getDriver().get(ConfigReader.getUrl());
	}
	
	@After
	public void tearDown() {
		try {
	        WebDriver driver = DriverManager.getDriver();
	        if (driver != null) {
	            driver.quit();
	        }
	    } catch (Exception e) {
	        System.out.println("Driver quit failed: " + e.getMessage());
	    } finally {
	        DriverManager.unload();
	    }
	}
	
	@AfterStep
	public void screenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			try {
	            byte[] screenshot = ((TakesScreenshot)DriverManager.getDriver())
	                    .getScreenshotAs(OutputType.BYTES);

	            scenario.attach(screenshot, "image/png", "error");

	        } catch(Exception e) {
	            System.out.println("Screenshot failed: " + e.getMessage());
	        }
		}
	}
}
