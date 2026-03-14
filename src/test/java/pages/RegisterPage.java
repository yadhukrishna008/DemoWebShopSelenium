package pages;

import org.openqa.selenium.By;
import utils.PageUtils;

public class RegisterPage {
	PageUtils pUtils;
	
//	Locators
	private By already_exsit_loc= By.cssSelector("div.message-error li");
	private By register_success= By.cssSelector("div.result");
	private By mandatory_field_err= By.cssSelector("span.field-validation-error > span"); // returns multiple elements
	private By pass_mismatch_err= By.xpath("//span[contains(text(),'password do not match.')]");
	private By wrong_mail_format= By.xpath("//span[contains(text(),'Wrong email')]");
	private By gender_female= By.id("gender-female");
	private By gender_male= By.id("gender-male");
	private By first_name= By.id("FirstName");
	private By last_name= By.id("LastName");
	private By register_mail= By.id("Email");
	private By password= By.id("Password");
	private By confirm_password= By.id("ConfirmPassword");
	private By register_button= By.id("register-button");
	
	
	public RegisterPage(){
		this.pUtils= new PageUtils();
	}
	
	public void fillRegForm(String fName, String lName, char gender, String mail, String pass, String pass2) {
		this.pUtils.type(first_name, fName);
		this.pUtils.type(last_name, lName);
		if(gender == 'M' || gender == 'm') {
			this.pUtils.click(gender_male);
		}
		else if(gender == 'F' || gender == 'f') {
			this.pUtils.click(gender_female);
		}
		this.pUtils.type(register_mail, mail);
		this.pUtils.type(password, pass);
		this.pUtils.type(confirm_password, pass2);
	}
	
	public void clickRegister() {
		this.pUtils.click(register_button);
	}
	
	public void clearForm() {
		this.pUtils.clearInput(first_name);
		this.pUtils.clearInput(last_name);
		this.pUtils.clearInput(register_mail);
		this.pUtils.clearInput(password);
		this.pUtils.clearInput(password);
	}
	
	public String registerStatus() {
		if(this.pUtils.isVisible(register_success)) {
			return "success";
		}
		else if(this.pUtils.isVisible(already_exsit_loc)) {
			return "duplicate email error";
		}
		else if(this.pUtils.isVisible(pass_mismatch_err)) {
			return "password mismatch error";
		}
		else if(this.pUtils.isVisible(wrong_mail_format)) {
			return "email validation error";
		}
		else if(this.pUtils.isVisible(this.pUtils.getElements(mandatory_field_err).get(0))) {
			return "mandatory field error";
		}
		return null;
	}
	
}
