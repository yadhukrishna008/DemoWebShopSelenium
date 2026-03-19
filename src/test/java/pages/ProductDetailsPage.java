package pages;

import org.openqa.selenium.By;

import utils.PageUtils;

//configuration options
public class ProductDetailsPage {
	PageUtils pageUtils;
	
//	Locators
	private By prod_title= By.cssSelector("div.product-name h1");
	private By prod_description= By.cssSelector("div.full-description p");
	private By hdd_checkbox_320= By.id("product_attribute_16_3_6_18");
	private By add_2_cart_btn= By.xpath("//input[contains(@id,'add-to-cart-button')]");
	private By add2CartSuccessAlert= By.cssSelector("div.bar-notification.success");
	private By add2CartErrorAlert= By.cssSelector("div.bar-notification.error");
	private By processorDrpDown= By.id("product_attribute_16_5_4");
	private By selectRAMDropDown= By.id("product_attribute_16_6_5");
	private By osSelect= By.id("product_attribute_16_4_7_21");
	private By softwareSelect= By.id("product_attribute_16_8_8_24");
	private By out_of_stock= By.cssSelector("div.stock span.value");
	
	public ProductDetailsPage() {
		this.pageUtils= new PageUtils();
	}
	
	public String getProductTitle() {
		return this.pageUtils.getElementText(prod_title).strip();
	}
	
	public String getProdDescription() {
		return this.pageUtils.getElementText(prod_description);
	}
	
	public void selectHddCheckbox() {
		this.pageUtils.click(hdd_checkbox_320);
	}
	
	public void addToCart() {
		this.pageUtils.click(add_2_cart_btn);
	}
	
	public String addToCartStatus() {
		boolean success= this.pageUtils.isVisible(add2CartSuccessAlert);
		boolean error= this.pageUtils.isVisible(add2CartErrorAlert);
		
		if(success) {
			return "success";
		}
		else if(error) {
			return "error";
		}
		return null;
	}
	
	public void selectProcessor() {
		this.pageUtils.selectDropDownByValue(processorDrpDown, "14");
	}
	
	public void selectRAM() {
		this.pageUtils.selectDropDownByValue(selectRAMDropDown, "17");
	}
	
	public void selectOS() {
		this.pageUtils.click(osSelect);
	}
	
	public void selectSoftware() {
		this.pageUtils.click(softwareSelect);
	}
	
	public boolean checkOutOfStock(String availabilty) {
		return this.pageUtils.getElementText(out_of_stock)
				.strip().equals(availabilty);
	}
	
	public boolean add2CartVisibility() {
		return this.pageUtils.isVisible(add_2_cart_btn);
	}
	
}
