package managers;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.ProductCatalogPage;
import pages.ProductDetailsPage;
import pages.CartPage;
import pages.CheckoutPage;


public class PageObjectManager {
	
	public HomePage getHomePO() {
		return new HomePage();
	}
	
	public LoginPage getLoginPO() {
		return new LoginPage();
	}
	
	public RegisterPage getRegPO() {
		return new RegisterPage();
	}
	
	public ProductCatalogPage getprodCatPO() {
		return new ProductCatalogPage();
	}
	
	public ProductDetailsPage getprodDetailsPO() {
		return new ProductDetailsPage();
	}
	
	public CartPage getCartPO() {
		return new CartPage();
	}
	
	public CheckoutPage getCheckoutPO() {
		return new CheckoutPage();
	}
	
}
