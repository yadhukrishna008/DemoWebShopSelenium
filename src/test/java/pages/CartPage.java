package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.PageUtils;

public class CartPage {
	PageUtils pageUtils;
	
//	Locators
	private By remove_checkbox_loc_all= By.cssSelector(".remove-from-cart input");
	private By update_cart_btn= By.cssSelector("input.update-cart-button");
	private By cart_prod_rows= By.cssSelector("tr.cart-item-row");
	private By prod_in_row= By.cssSelector("td.product a");
	private By prod_qty_in_row= By.cssSelector("td.qty.nobr input");
	private By prod_price_in_row= By.cssSelector("span.product-unit-price");
	private By final_prices_loc= By.cssSelector("table.cart-total .product-price");
	private By cart_empty_flag= By.cssSelector("div.order-summary-content");
	private By cart_not_empty_flag= By.cssSelector("div.order-summary-content form");
	private By checkout_btn= By.id("checkout");
	private By checkout_country= By.id("CountryId");
	private By checkout_terms= By.id("termsofservice");
	
	public CartPage() {
		this.pageUtils= new PageUtils();
	}
	
	public void emptyTheCart() {
		List<WebElement> checkboxes= this.pageUtils.getElements(remove_checkbox_loc_all);
		for(WebElement checkbox: checkboxes) {
			if(!checkbox.isSelected()) {
				this.pageUtils.click(remove_checkbox_loc_all);
			}
		}
		this.pageUtils.click(update_cart_btn);
	}
	
	public String getProdQuantityInCart(String productName) {
		List<WebElement> rows= this.pageUtils.getElements(cart_prod_rows);
		for(WebElement row: rows) {
			String prod_name= this.pageUtils.getElementText(
					row.findElement(prod_in_row)
					);
			if(productName.equals(prod_name.strip())) {
				return row.findElement(prod_qty_in_row).getAttribute("value");
			}
		}
		return "";
	}
	
	public String getProdPriceInCart(String productName) {
		List<WebElement> rows= this.pageUtils.getElements(cart_prod_rows);
		for(WebElement row: rows) {
			String prod_name= this.pageUtils.getElementText(
					row.findElement(prod_in_row)
					);
			if(productName.equals(prod_name.strip())) {
				return row.findElement(prod_price_in_row).getText();
			}
		}
		return "";
	}
	
	public void changeQuantityTo(String productName, String newQuantity) {
		List<WebElement> rows= this.pageUtils.getElements(cart_prod_rows);
		for(WebElement row: rows) {
			String prod_name= this.pageUtils.getElementText(
					row.findElement(prod_in_row)
					);
			if(productName.equals(prod_name)) {
				row.findElement(prod_qty_in_row).clear();
				row.findElement(prod_qty_in_row).sendKeys(newQuantity);
			}
		}
		this.pageUtils.click(update_cart_btn);
	}
	
	public String getSubTotalPrice() {
		return this.pageUtils.getElements(final_prices_loc).get(0).getText().strip();
	}
	
	public boolean isCartEmpty(String string) {
		return this.pageUtils.getElementText(cart_empty_flag).strip().equals(string);
	}
	
	public boolean isCartNotEmpty() {
		return this.pageUtils.isVisible(cart_not_empty_flag);
	}
	
	public void toCheckout() {
		this.pageUtils.selectDropDownByValue(checkout_country, "41");
		this.pageUtils.click(checkout_terms);
		this.pageUtils.click(checkout_btn);
	}
	
	
}
