package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.TestContext;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductCatalogPage;
import pages.ProductDetailsPage;

public class CartSteps {
	TestContext testContext;
	ProductCatalogPage prodCatPage;
	ProductDetailsPage prodDetailsPage;
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	public CartSteps(TestContext testContext) {
		this.testContext= testContext;
		this.prodCatPage= testContext.pageObjectManager.getprodCatPO();
		this.prodDetailsPage= testContext.pageObjectManager.getprodDetailsPO();
		this.loginPage= testContext.pageObjectManager.getLoginPO();
		this.homePage= testContext.pageObjectManager.getHomePO();
		this.cartPage= testContext.pageObjectManager.getCartPO();
	}

	@When("user adds the product {string} to the cart")
	public void user_adds_the_product_to_the_cart(String productName) {
	    this.prodCatPage.addProductToCart(productName);
	}
	
	@Then("the cart should display {string} with quantity {string}")
	public void the_cart_should_display_with_quantity(String productName, String quantity) {
	    this.homePage.toCart();
	    Assert.assertEquals(
	    		this.cartPage.getProdQuantityInCart(productName), 
	    		quantity,
	    		"The product quantity is not right!!!");
	}
	
	@Given("user has {string} item of {string} in the cart at ${string}")
	public void user_has_item_of_in_the_cart_at_$(String quantity, String product, String price) {
	    this.prodCatPage.searchProduct(product);
	    this.prodCatPage.addProductToCart(product);
	    this.homePage.toCart();
	    String actual_quantity= this.cartPage.getProdQuantityInCart(product);
	    String actual_price= this.cartPage.getProdPriceInCart(product);
	    
	    Assert.assertEquals(actual_price, price, "Default price mismatch!!!");
	    Assert.assertEquals(actual_quantity, quantity, "Default quantity mismatch!!!");
	}
	
	@When("user updates the quantity of {string} to {string}")
	public void user_updates_the_quantity_of_to(String product, String quantity) {
	    this.cartPage.changeQuantityTo(product, quantity);
	}
	
	@Then("the Sub-Total should display ${string}")
	public void the_sub_total_should_display_$(String price) {
	    ;
	    Assert.assertEquals(
	    		this.cartPage.getSubTotalPrice(), 
	    		price, 
	    		"The price is not matching!!!");
	}
	
	@Given("user has {string} item of {string} in the cart")
	public void user_has_item_of_in_the_cart(String quantity, String product) {
		this.prodCatPage.searchProduct(product);
	    this.prodCatPage.addProductToCart(product);
	    this.homePage.toCart();
	    Assert.assertEquals(
	    		this.cartPage.getProdQuantityInCart(product), 
	    		quantity, 
	    		"Product or quantity mismatch!!");
	}
	
	@When("user removes the item from the cart")
	public void user_removes_the_item_from_the_cart() {
	    this.cartPage.emptyTheCart();
	}
	
	@Then("the message {string} should be displayed")
	public void the_message_should_be_displayed(String string) {
	    Assert.assertTrue(
	    		this.cartPage.isCartEmpty(string), 
	    		"Your Shopping Cart is empty! message not observed...");
	}
	
	@Given("user search and opens product {string}")
	public void user_search_and_opens_product(String product) {
	    this.prodCatPage.searchProduct(product);
	    this.prodCatPage.openProduct(product);
	}
	
	@Then("the {string} button should be disabled")
	public void the_button_should_be_disabled(String string) {
	    Assert.assertFalse(
	    		this.prodDetailsPage.add2CartVisibility(),
	    		"button is available in the prod page!!");
	    
	}
	
	@Then("an {string} label should be visible")
	public void an_label_should_be_visible(String availabilty) {
	    Assert.assertTrue(
	    		this.prodDetailsPage.checkOutOfStock(availabilty), 
	    		"The out of stock status is not visible!!");
	}
	
}
