package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.PageUtils;

// list of products
public class CheckoutPage {
	PageUtils pageUtils;
	
//	Locators
	private By billing_fname= By.id("BillingNewAddress_FirstName");
	private By billing_lname= By.id("BillingNewAddress_LastName");
	private By billing_email= By.id("BillingNewAddress_Email");
	private By billing_country= By.id("BillingNewAddress_CountryId");
	private By billing_city= By.id("BillingNewAddress_City");
	private By billing_address= By.id("BillingNewAddress_Address1");
	private By postal_code= By.id("BillingNewAddress_ZipPostalCode");
	private By phone_number= By.id("BillingNewAddress_PhoneNumber");
	private By billing_details= By.id("billing-address-select");
	private By billing_continue_btn= By.cssSelector("div#billing-buttons-container input");
	private By shipping_continue_btn= By.cssSelector("div#shipping-buttons-container input");
	private By shipping_continue_btn2= By.cssSelector("div#shipping-method-buttons-container input");
	private By credit_option= By.id("paymentmethod_2");
	private By payment_continue_btn= By.cssSelector("div#payment-method-buttons-container input");
	private By payment_continue_btn2= By.cssSelector("div#payment-info-buttons-container input");
	private By confirm_order= By.cssSelector("div#confirm-order-buttons-container input");
	private By order_status= By.cssSelector("div.center-1 div.title strong");
	private By field_val_error= By.cssSelector(".field-validation-error");
	private By payment_error= By.cssSelector("div.message-error");
	
	
	public CheckoutPage() {
		this.pageUtils= new PageUtils();
	}
	
	public boolean billingDetailsNotPresent() {
		return !this.pageUtils.isVisible(billing_details);
	}
	
	public void chooseNewAddress() {
		this.pageUtils.selectDropDownByVisibleText(billing_details, "New Address");
	}
	
	public void enterBillingFname(String fname) {
		this.pageUtils.type(billing_fname, fname);
	}
	
	public void enterBillingLname(String lname) {
		this.pageUtils.type(billing_lname, lname);
	}
	
	public void enterBillingMail(String mail) {
		this.pageUtils.type(billing_email, mail);
	}
	
	public void enterBillingCountry(String country) {
		this.pageUtils.selectDropDownByValue(billing_country, country);
	}
	
	public void enterBillingCity(String city) {
		this.pageUtils.type(billing_city, city);
	}
	
	public void enterBillingAddress(String address) {
		this.pageUtils.type(billing_address, address);
	}
	
	public void enterBillingZIP(String zip) {
		this.pageUtils.type(postal_code, zip);
	}
	
	public void enterBillingPhone(String number) {
		this.pageUtils.type(phone_number, number);
	}
	
	public void clickBillingContinue() {
		this.pageUtils.click(billing_continue_btn);
	}
	
	public void clickShippingContinue() {
		this.pageUtils.click(shipping_continue_btn);
		this.pageUtils.click(shipping_continue_btn2);
	}
	
	public void clickPaymentContinue() {
		this.pageUtils.click(payment_continue_btn);
	}
	
	public void confirmPaymentInfo() {
		this.pageUtils.click(payment_continue_btn2);
	}
	
	public void confirmPayment() {
		this.pageUtils.click(confirm_order);
	}
	
	public boolean orderStatus() {
		return this.pageUtils.getElementText(order_status).contains("successfully processed!");
	}
	
	public boolean checkFieldValErr() {
		List<WebElement> errors = this.pageUtils.getElements(field_val_error);
		return errors.size()>0;
	}
	
	public void selectCredCard() {
		this.pageUtils.click(credit_option);
	}
	
	public boolean checkPaymentErr() {
		return this.pageUtils.isVisible(payment_error);
	}
	
}
