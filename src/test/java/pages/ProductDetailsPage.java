package pages;

import org.openqa.selenium.By;

import utils.PageUtils;

//configuration options
public class ProductDetailsPage {
	PageUtils pageUtils;
	
//	Locators
	By prod_title= By.cssSelector("div.product-name h1");
	By prod_description= By.cssSelector("div.full-description p");
	By hdd_checkbox_320= By.id("product_attribute_16_3_6_18");
	By add_2_cart_btn= By.id("add-to-cart-button-16");
	By add2CartSuccessAlert= By.cssSelector("div.bar-notification.success");
	By add2CartErrorAlert= By.cssSelector("div.bar-notification.error");
	By processorDrpDown= By.id("product_attribute_16_5_4");
	By selectRAMDropDown= By.id("product_attribute_16_6_5");
	By osSelect= By.id("product_attribute_16_4_7_21");
	By softwareSelect= By.id("product_attribute_16_8_8_24");
	
	
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
		this.pageUtils.selectDropDown(processorDrpDown, "14");
	}
	
	public void selectRAM() {
		this.pageUtils.selectDropDown(selectRAMDropDown, "17");
	}
	
	public void selectOS() {
		this.pageUtils.click(osSelect);
	}
	
	public void selectSoftware() {
		this.pageUtils.click(softwareSelect);
	}
	
}
