package utils;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.DriverManager;

public class PageUtils {
	Actions myAction= new Actions(DriverManager.getDriver());
	
	private WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }
	
	public void click(By el) {
		int attempts = 0;
	    while (attempts < 3) {
	        try {
	            getWait().until(ExpectedConditions.elementToBeClickable(el)).click();
	            break;
	        } 
	        catch (Exception e) {
	            attempts++;
	        }
	    }
	}
	
	public void type(By el, String text) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(el)).sendKeys(text);
	}
	
	public boolean isVisible(By el) {
		try {
	        return getWait().until(
	            ExpectedConditions.visibilityOfElementLocated(el)
	        ).isDisplayed();
	    } 
	    catch(Exception e) {
	        return false;
	    }
	}
	
	public boolean isVisible(WebElement el) {
		return el.isDisplayed();
	}
	
	public List<WebElement> getElements(By el){
		return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(el));
	}
	
	public void clearInput(By el) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(el)).clear();
	}
	
	public void moveToElement(By el) {
		myAction.moveToElement(getWait().until(ExpectedConditions.elementToBeClickable(el))).perform();
	}
	
	public String getElementText(By el) {
		try {
	        return getWait().until(
	            ExpectedConditions.visibilityOfElementLocated(el)
	        ).getText();
	    } 
	    catch(Exception e) {
	        return "";
	    }
	}
	
	public void selectDropDown(By el, String value) {
		WebElement drpDown= getWait().until(ExpectedConditions.elementToBeClickable(el));
		Select select= new Select(drpDown);
		select.selectByValue(value);
	}
	
}
