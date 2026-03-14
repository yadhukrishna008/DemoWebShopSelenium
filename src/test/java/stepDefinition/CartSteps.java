package stepDefinition;

import managers.TestContext;
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
	
	public CartSteps(TestContext testContext) {
		this.testContext= testContext;
		this.prodCatPage= testContext.pageObjectManager.getprodCatPO();
		this.prodDetailsPage= testContext.pageObjectManager.getprodDetailsPO();
		this.loginPage= testContext.pageObjectManager.getLoginPO();
		this.homePage= testContext.pageObjectManager.getHomePO();
	}
}
