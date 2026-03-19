package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.PageUtils;

public class HomePage {
	PageUtils pUtils;
	
//	Locators
	private By register= By.cssSelector("a.ico-register");
	private By login= By.cssSelector("a.ico-login");
	private By cart= By.cssSelector("#topcartlink .cart-label");
	private By inAccountLink= By.cssSelector("div.header-links a.account");
	private By myAccnountAddress= By.xpath("//ul[@class='list']//a[contains(text(),'Addresses')]");
	private By savedAddrDltBtn= By.cssSelector("input.delete-address-button");
	
	public HomePage() {
		this.pUtils= new PageUtils();
    }
	
//	Actions
	public void toRegister() {
		this.pUtils.click(register);
	}
	
	public void toLogin() {
		this.pUtils.click(login);
	}
	
	public void toCart() {
		this.pUtils.click(cart);
	}
	
	public void goToAccountDetails() {
		this.pUtils.click(inAccountLink);
	}
	
	public void openAddress() {
		this.pUtils.click(myAccnountAddress);
	}
	
	public void deleteAllAddresses() {
		for(WebElement btn: this.pUtils.getElements(savedAddrDltBtn)) {
			btn.click();
			this.pUtils.alertAccept();
		}
	}
	
}
