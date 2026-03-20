package stepDefinition;

import io.cucumber.java.en.When;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import managers.TestContext;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.ConfigReader;
import utils.GenericUtils;

import org.testng.Assert;

public class AuthenticationSteps {
	TestContext testContext;
	LoginPage loginPO;
	HomePage homePO;
	RegisterPage regPO;
	GenericUtils gUtils;
	
	public AuthenticationSteps(TestContext testContext){
		this.testContext= testContext;
		this.loginPO= testContext.pageObjectManager.getLoginPO();
		this.homePO= testContext.pageObjectManager.getHomePO();
		this.regPO= testContext.pageObjectManager.getRegPO();
		this.gUtils= testContext.genericUtils;
	}
	
	@When("user enters email {string}")
	public void user_enters_email(String email) throws IOException {
		String mail= (email != null && !email.isEmpty()) ? ConfigReader.getUserName(email) : "";
	    if (mail == null) mail = "";
	    this.loginPO.enterMail(mail);
	}
	
	@When("user enters password {string}")
	public void user_enters_password(String password) throws IOException {
		String pass= (password != null && !password.isEmpty()) ? ConfigReader.getPassword(password): "";
		if (pass == null) pass = "";
		this.loginPO.enterPassword(pass);
	}
	
	@When("user clicks login")
	public void user_clicks_login() {
	    this.loginPO.clickLogin();
	}
	
	@Then("login result should be {string}")
	public void login_result_should_be(String result) {
		Assert.assertEquals(this.loginPO.getStatus(), result, "Expected " + result);
	}
	
	@When("user enters registration details {string} {string} {string}")
	public void user_enters_registration_details(String mail, String pass, String pass_confirm) {
		this.regPO.fillRegForm(
	    		mail.substring(0, 3),
	    		mail.substring(3, 6),
	    		'f', 
	    		mail, 
	    		pass,
	    		pass_confirm);
	}
	
	@Then("{string} should appear")
	public void should_appear(String error_msg) {
		Assert.assertEquals(this.regPO.registerStatus(), error_msg, "Expected failure with" + error_msg);
	}
	
	@When("user enters valid registration details")
	public void user_enters_valid_registration_details() {
		String mail= this.gUtils.generateMail();
		String pass= this.gUtils.generatePassword();
		
	    this.regPO.fillRegForm(
	    		mail.substring(0, 8),
	    		mail.substring(8, 12),
	    		'm', 
	    		mail, 
	    		pass,
	    		pass);
	}
	
	@When("user submits the registration form")
	public void user_submits_the_registration_form() {
	    this.regPO.clickRegister();
	}
	
	@Then("user account should be created successfully")
	public void user_account_should_be_created_successfully() {
	    Assert.assertEquals(this.regPO.registerStatus(), "success", "Expected Sucess register, but failed!!");
	}
	
	@Then("validation errors should appear")
	public void validation_errors_should_appear() {
		Assert.assertEquals(this.regPO.registerStatus(), "mandatory field error", "Expected failure with unfilled mandatory field!");
	}

	@Given("user logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() throws IOException {
	    this.loginPO.enterMail(ConfigReader.getUserName("valid_user"));
	    this.loginPO.enterPassword(ConfigReader.getPassword("valid_pass"));
	    this.loginPO.clickLogin();
	}
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
	    
	}
	
}
