package pages;

import org.openqa.selenium.By;
import utils.PageUtils;

public class HomePage {
	PageUtils pUtils;
	
//	Locators
	private By register= By.cssSelector("a.ico-register");
	private By login= By.cssSelector("a.ico-login");
	
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
}
