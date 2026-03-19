package stepDefinition;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.TestContext;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductCatalogPage;
import pages.RegisterPage;
import utils.ConfigReader;

public class NavigationSteps {
	TestContext testContext;
	HomePage homePO;
	RegisterPage regPO;
	ProductCatalogPage prodCatPage;
	LoginPage loginPage;
	CartPage cartPage;
	
	
	public NavigationSteps(TestContext testContext){
		this.testContext= testContext;
		this.homePO= testContext.pageObjectManager.getHomePO();
		this.regPO= testContext.pageObjectManager.getRegPO();
		this.loginPage= testContext.pageObjectManager.getLoginPO();
		this.prodCatPage= testContext.pageObjectManager.getprodCatPO();
		this.cartPage= testContext.pageObjectManager.getCartPO();
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
	
	@Given("user is logged in to the account")
	public void user_is_logged_in_to_the_account() throws IOException {
		this.homePO.toLogin();
	    this.loginPage.enterMail(ConfigReader.getUserName("valid_user"));
	    this.loginPage.enterPassword(ConfigReader.getPassword("valid_pass"));
	    this.loginPage.clickLogin();
	}
	
	@Given("user hovers over category {string} and select {string}")
	public void user_hovers_over_category_and_select(String category, String subCategory) {
	    this.prodCatPage.hoverProdCategory(category);
	    this.prodCatPage.selectSubCategory(subCategory);
	}
	
	@When("user proceeds to checkout")
	public void user_proceeds_to_checkout() {
	    this.cartPage.toCheckout();
	}
	
}
