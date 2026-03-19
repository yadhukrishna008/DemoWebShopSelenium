package stepDefinition;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.TestContext;
import pages.ProductCatalogPage;
import pages.ProductDetailsPage;
import pages.LoginPage;
import pages.HomePage;

public class ProductSteps {
	TestContext testContext;
	ProductCatalogPage prodCatPage;
	ProductDetailsPage prodDetailsPage;
	LoginPage loginPage;
	HomePage homePage;
	
	public ProductSteps(TestContext testContext) {
		this.testContext= testContext;
		this.prodCatPage= testContext.pageObjectManager.getprodCatPO();
		this.prodDetailsPage= testContext.pageObjectManager.getprodDetailsPO();
		this.loginPage= testContext.pageObjectManager.getLoginPO();
		this.homePage= testContext.pageObjectManager.getHomePO();
	}
	
	@Given("user is on product sub category page {string}")
	public void user_is_on_product_sub_category_page(String subCategory) {
		boolean isVisible= this.prodCatPage.checksubCatTitle(subCategory);
	    Assert.assertTrue(isVisible, "Not in the page currently");
	}
	
	@Then("list of products should be displayed")
	public void list_of_products_should_be_displayed() {
		List<WebElement> products= this.prodCatPage.getAllProducts();
		Assert.assertNotNull(products, "Product list object is null!");
	    Assert.assertTrue(products.size()>0, "No products found on the sub-category page.");
	}
	
	@When("user selects product configuration options")
	public void user_selects_product_configuration_options() {
//	    other options are selected
		this.prodDetailsPage.selectHddCheckbox();
	}
	
	@Then("product should be added successfully")
	public void product_should_be_added_successfully() {
	    Assert.assertEquals(this.prodDetailsPage.addToCartStatus(), "success", "Product is not added succesfully");
	}
	
	@When("user adds product to cart")
	public void user_adds_product_to_cart() {
		this.prodDetailsPage.addToCart();
	}
	@Then("validation error message should appear")
	public void validation_error_message_should_appear() {
		Assert.assertEquals(this.prodDetailsPage.addToCartStatus(), "error", "add to cart error not observed!!");
	}

	@Then("{string} product details page should be displayed")
	public void product_details_page_should_be_displayed(String product) {
	    String prodTitle= this.prodDetailsPage.getProductTitle();
	    Assert.assertEquals(prodTitle, product, "Not in the product page");
	    String descriptionStatus= this.prodDetailsPage.getProdDescription();
	    Assert.assertTrue(
	    		descriptionStatus != null && !descriptionStatus.isEmpty(), 
	    		"Description is invalid!!");
	}
	
	@Given("user opens product {string}")
	public void user_opens_product(String product) {
	    this.prodCatPage.openProduct(product);
	}
	
	@When("user changes product configuration")
	public void user_changes_product_configuration() {
	    this.prodDetailsPage.selectProcessor();
	    this.prodDetailsPage.selectRAM();
	    this.prodDetailsPage.selectOS();
	    this.prodDetailsPage.selectSoftware();
	    this.prodDetailsPage.selectHddCheckbox();
	}
	
	@Then("product price should update accordingly")
	public void product_price_should_update_accordingly() {
		Assert.assertEquals(this.prodDetailsPage.addToCartStatus(), "success", "Product is not added succesfully");
	}
}
