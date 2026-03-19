package pages;

import org.openqa.selenium.By;
import utils.PageUtils;

public class LoginPage {
	PageUtils pUtils;
	
	private By mail= By.cssSelector("input#Email");
	private By password= By.cssSelector("input#Password");
	private By login_btn= By.cssSelector("input.button-1.login-button");
	private By no_customer_error= By.xpath("//li[contains(text(), 'No customer')]");
	private By cred_error= By.xpath("//li[contains(text(), 'The credentials')]");
	private By inAccountLink= By.cssSelector("div.header-links a.account");
	private By welcome_title= By.cssSelector("div.page-title h1");
	
	public LoginPage(){
		this.pUtils= new PageUtils();
	}
	
	public void enterMail(String email) {
		this.pUtils.type(mail, email);
	}
	
	public void enterPassword(String pass) {
		this.pUtils.type(password, pass);
	}
	
	public void clickLogin() {
		this.pUtils.click(login_btn);
	}
	
	public String getStatus() {
		if(this.pUtils.isVisible(inAccountLink)) {
			return "success";
		}
		else if(this.pUtils.isVisible(no_customer_error)) {
			return "no_customer_err";
		}
		else if(this.pUtils.isVisible(cred_error)) {
			return "invalid_cred";
		}
		return null;
	}
	
	public boolean inLoginPage() {
		return this.pUtils.getElementText(welcome_title).contains("Please Sign In!");
	}
}
