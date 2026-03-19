package stepDefinition;

import java.io.IOException;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.TestContext;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductCatalogPage;
import pages.ProductDetailsPage;
import utils.ConfigReader;

public class CheckoutSteps {
	TestContext testContext;
	ProductCatalogPage prodCatPage;
	ProductDetailsPage prodDetailsPage;
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	
	public CheckoutSteps(TestContext testContext) {
		this.testContext= testContext;
		this.prodCatPage= testContext.pageObjectManager.getprodCatPO();
		this.prodDetailsPage= testContext.pageObjectManager.getprodDetailsPO();
		this.loginPage= testContext.pageObjectManager.getLoginPO();
		this.homePage= testContext.pageObjectManager.getHomePO();
		this.cartPage= testContext.pageObjectManager.getCartPO();
		this.checkoutPage= testContext.pageObjectManager.getCheckoutPO();
	}
	
	@Given("user has product in cart")
	public void user_has_product_in_cart() throws IOException {
		this.homePage.toLogin();
		String mail= ConfigReader.getUserName("valid_user");
	    if (mail == null) mail = "";
	    this.loginPage.enterMail(mail);
	    String pass= ConfigReader.getPassword("valid_pass");
		if (pass == null) pass = "";
		this.loginPage.enterPassword(pass);
		this.loginPage.clickLogin();
		this.prodCatPage.searchProduct("TCP Self-Paced Training");
	    this.prodCatPage.addProductToCart("TCP Self-Paced Training");
	    this.homePage.toCart();
	    Assert.assertTrue(this.cartPage.isCartNotEmpty());
	}
	
	@When("user enters valid billing and shipping details")
	public void user_enters_valid_billing_and_shipping_details() {
		if(this.checkoutPage.billingDetailsNotPresent()) {
		    this.checkoutPage.enterBillingFname("Yadhu");
		    this.checkoutPage.enterBillingLname("Krishna");
		    this.checkoutPage.enterBillingMail("aaaaaaa@gmail.com");
		    this.checkoutPage.enterBillingCountry("41");
		    this.checkoutPage.enterBillingCity("Kochi");
		    this.checkoutPage.enterBillingAddress("new house");
		    this.checkoutPage.enterBillingZIP("22222");
		    this.checkoutPage.enterBillingPhone("11111111111");
		}
		this.checkoutPage.clickBillingContinue();
		this.checkoutPage.clickShippingContinue();
	}
	
	@When("user selects shipping and payment method")
	public void user_selects_shipping_and_payment_method() {
	    this.checkoutPage.clickPaymentContinue();
	    this.checkoutPage.confirmPaymentInfo();
	}
	
	@When("user confirms the order")
	public void user_confirms_the_order() {
	    this.checkoutPage.confirmPayment();
	}
	
	@Then("order should be placed successfully")
	public void order_should_be_placed_successfully() {
	    this.checkoutPage.orderStatus();
	}
	
	@Given("guest user has product in cart")
	public void guest_user_has_product_in_cart() {
		this.prodCatPage.searchProduct("TCP Self-Paced Training");
	    this.prodCatPage.addProductToCart("TCP Self-Paced Training");
	    this.homePage.toCart();
	    Assert.assertTrue(this.cartPage.isCartNotEmpty());
	}
	
	@Then("system should request login")
	public void system_should_request_login() {
	    Assert.assertTrue(
	    		this.loginPage.inLoginPage(), 
	    		"Not in login page!!");
	}
	
	@When("user leaves mandatory checkout fields empty")
	public void user_leaves_mandatory_checkout_fields_empty() {
		if(!this.checkoutPage.billingDetailsNotPresent()) {			
			this.checkoutPage.chooseNewAddress();
		}
		this.checkoutPage.clickBillingContinue();
	}
	
	@Then("validation errors should appear in checkout")
	public void validation_errors_should_appear_in_checkout() {
		Assert.assertTrue(
				this.checkoutPage.checkFieldValErr(),
				"Errors are missing");
	}
	
	@When("user enters invalid payment details")
	public void user_enters_invalid_payment_details() {
	    this.checkoutPage.selectCredCard();
	    this.checkoutPage.clickPaymentContinue();
	    this.checkoutPage.confirmPaymentInfo();
	}
	
	@Then("payment error message should appear")
	public void payment_error_message_should_appear() {
	    Assert.assertTrue(
	    		this.checkoutPage.checkPaymentErr(),
	    		"The error message not observed!!");
	}
	
}
