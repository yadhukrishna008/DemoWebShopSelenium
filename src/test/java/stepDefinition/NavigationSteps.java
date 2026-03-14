package stepDefinition;

import io.cucumber.java.en.Given;
import managers.TestContext;
import pages.HomePage;
import pages.RegisterPage;

public class NavigationSteps {
	TestContext testContext;
	HomePage homePO;
	RegisterPage regPO;
	
	public NavigationSteps(TestContext testContext){
		this.testContext= testContext;
		this.homePO= testContext.pageObjectManager.getHomePO();
		this.regPO= testContext.pageObjectManager.getRegPO();
	}
	
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
	    this.homePO.toLogin();
	}
	
	@Given("user navigates to registration page")
	public void user_navigates_to_registration_page() {
	    this.homePO.toRegister();
	    this.regPO.clearForm();
	}
	
}
