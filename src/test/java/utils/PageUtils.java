package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
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
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
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
	
	public void click(WebElement el) {
		getWait().until(ExpectedConditions.elementToBeClickable(el)).click();
	}
	
	public void type(By el, String text) {
		WebElement field= getWait().until(ExpectedConditions.visibilityOfElementLocated(el));
		field.clear();
		field.sendKeys(text);
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
	
	public String getElementText(WebElement el) {
        return getWait().until(
            ExpectedConditions.visibilityOf(el)
            ).getText();
	}
	
	public void selectDropDownByValue(By el, String value) {
		WebElement drpDown= getWait().until(ExpectedConditions.elementToBeClickable(el));
		Select select= new Select(drpDown);
		select.selectByValue(value);
	}
	
	public void selectDropDownByVisibleText(By el, String text) {
		WebElement drpDown= getWait().until(ExpectedConditions.elementToBeClickable(el));
		Select select= new Select(drpDown);
		select.selectByVisibleText(text);
	}
	
	public void alertAccept() {
		Alert myAlert= getWait().until(ExpectedConditions.alertIsPresent());
		myAlert.accept();
	}
	
}
