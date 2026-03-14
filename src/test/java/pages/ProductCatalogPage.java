package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.PageUtils;

public class ProductCatalogPage {
PageUtils pageUtils;
	
//	locators
	By productsLocator= By.cssSelector("div.item-box");
	
//	for dynamic loc
	String topMenu= "ul.top-menu > li > a[href='/%s']";
	String subList= "ul.top-menu ul.sublist a[href='/%s']";
	String subCatTitle= "//h1[text()='%s']";
	String productLocator= "//h2[@class='product-title']/a[text()='%s']";
	
	public ProductCatalogPage() {
		this.pageUtils= new PageUtils();
	}
	
	public void hoverProdCategory(String category) {
		By catPath= By.cssSelector(String.format(topMenu, category.toLowerCase()));
		this.pageUtils.moveToElement(catPath);
	}
	
	public void selectSubCategory(String subCategory) {
		By subCatPath= By.cssSelector(String.format(subList, subCategory.toLowerCase()));
		this.pageUtils.click(subCatPath);
	}
	
	public boolean checksubCatTitle(String subCategory) {
		By title= By.xpath(String.format(subCatTitle, subCategory));
		return this.pageUtils.isVisible(title);
	}
	
	public List<WebElement> getAllProducts(){
		return this.pageUtils.getElements(productsLocator);
	}
	
	public void openProduct(String product) {
		By prod= By.xpath(String.format(productLocator, product));
		this.pageUtils.click(prod);
	}
	
}
