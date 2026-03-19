package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.PageUtils;

public class ProductCatalogPage {
PageUtils pageUtils;
	
//	locators
	private By productsLocator= By.cssSelector("div.item-box");
	private By productCards = By.cssSelector("div.product-item");
	private By productTitle = By.cssSelector("h2.product-title a");
	private By addToCartBtn = By.cssSelector("div.product-grid div.buttons input");
	private By searchField= By.id("small-searchterms");
	private By searchBtn= By.className("search-box-button");
	
//	for dynamic loc
	private String topMenu= "ul.top-menu > li > a[href='/%s']";
	private String subList= "ul.top-menu ul.sublist a[href='/%s']";
	private String subCatTitle= "//h1[text()='%s']";
	private String productLocator= "//h2[@class='product-title']/a[text()='%s']";
	
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
	
	public void addProductToCart(String productName) {

	    List<WebElement> products = this.pageUtils.getElements(productCards);

	    for (WebElement product : products) {

	        String name = product.findElement(productTitle).getText();

	        if (name.equalsIgnoreCase(productName)) {

	            WebElement addBtn = product.findElement(addToCartBtn);

	            this.pageUtils.click(addBtn);
	            
	            break;
	        }
	    }
	}
	
	public void searchProduct(String productName) {
		this.pageUtils.type(searchField, productName);
		this.pageUtils.click(searchBtn);
	}
	
	

}
