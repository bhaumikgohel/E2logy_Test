package e2logy.Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import e2logy.Base.TestBase;
import e2logy.utils.Util;

public class CheckOutPage extends TestBase{

	public CheckOutPage() {
	PageFactory.initElements(driver, this);
	}
	
	// Input boxes for checkout page
	
	@FindBy(xpath="//input[@id='email']")
	WebElement inputEmailid;
	
	@FindBy(xpath="//p[@id='error-for-email']")
	WebElement Emailvalidationtext;
	
	@FindBy(xpath="//select[@id='Select0']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='TextField0']")
	WebElement inputFirstName;
	
	@FindBy(xpath="//p[@id='error-for-TextField0']")
	WebElement Firstnamevalidationtext;
	
	@FindBy(xpath="//input[@id='TextField1']")
	WebElement inputLastName;
	
	@FindBy(xpath="//p[@id='error-for-TextField1']")
	WebElement Lastnamevalidationtext;
	
	
	@FindBy(xpath="//input[@id='shipping-address1']")
	WebElement inputAddress;
	
	@FindBy(xpath="//p[@id='error-for-shipping-address1']")
	WebElement AddressValidationtext;
	
	@FindBy(xpath="//input[@id='TextField3']")
	WebElement inputCity;
	
	@FindBy(xpath="//p[@id='error-for-TextField3']")
	WebElement CityValidationtext;
	
	@FindBy(xpath="//input[@id='TextField4']")
	WebElement inputPincode;
	
	@FindBy(xpath="//p[@id='error-for-TextField4']")
	WebElement PincodeValidationtext;
	
	@FindBy(xpath="//input[@id='TextField5']")
	WebElement inputPhone;
	
	@FindBy(xpath="//p[@id='error-for-TextField5']")
	WebElement Phonevalidation;
	
	@FindBy(xpath="//input[@id='basic-More Payment Options']")
	WebElement morepayment;
			
	@FindBy(xpath="//input[@id='billing_address_selector-shipping_address']")
	WebElement options;
	
	
	@FindBy(xpath="//input[@id='ReductionsInput4']")
	WebElement inputCouponcode;
	
	@FindBy(xpath="//button[@class='_1m2hr9ge _1fragemvz _1fragemo1 _1fragemq2 _1fragem32 _1fragemvf _1fragemvq _1fragemvu _1fragemvk _1fragempw _1m2hr9g16 _1fragemrg _1fragemre _1fragemri _1fragemrc _1fragemsc _1fragems8 _1fragemsg _1fragems4 _1fragemc3 _1fragembe _1fragemcs _1fragemap _1fragemvk _1m2hr9g1q _1m2hr9g1o _1m2hr9g10 _1m2hr9gx _1fragemvg _1m2hr9g25']")
	WebElement CouponApplyBtn;
	
	@FindBy(xpath="//button[@id='checkout-pay-button']")
	WebElement Paynowbtn;

	
	
	public String VerifyCheckoutPageTitle() {
		return driver.getTitle();
	}
	
	public String[] CheckRequiredFieldValidationMessage() throws InterruptedException {
		
	
		Util.ScrolluptoElement(morepayment);
		
		Thread.sleep(3000);
		
		morepayment.click();
		
		
		Thread.sleep(3000);
		
		Paynowbtn.click();
		
		Thread.sleep(3000);
		
		String emailvalidation = Emailvalidationtext.getText();
		String Firstnamevalidation = Firstnamevalidationtext.getText();
		String Lastnamevalidation = Lastnamevalidationtext.getText();
		String AddressValidation = AddressValidationtext.getText();
		String CityValidation = CityValidationtext.getText();
		String pincodeValidation = PincodeValidationtext.getText();
		String phonenumbervalidation = Phonevalidation.getText();
		
		return new String[] {emailvalidation,Firstnamevalidation,Lastnamevalidation,AddressValidation,CityValidation,pincodeValidation,phonenumbervalidation};
		
	}
	
	public String[] CheckFieldsValidationsMessagesWithNagativeValue(String email, String firstname, String lastname, String Address, String city, String pincode, String mobileno) throws InterruptedException {
		
		Util.ScrolluptoElement(morepayment);
		
		Thread.sleep(3000);
		
		inputEmailid.sendKeys(email);
		inputFirstName.sendKeys(firstname);
		inputLastName.sendKeys(lastname);
		inputAddress.sendKeys(Address);
		inputCity.sendKeys(city);
		inputPincode.sendKeys(pincode);
		inputPhone.sendKeys(mobileno);
		
		Paynowbtn.click();
		
		Thread.sleep(5000);
		
		
		String emailvalidation = Emailvalidationtext.getText();
		String pincodeValidation = PincodeValidationtext.getText();
		String phonenumbervalidation = Phonevalidation.getText();
		
		return new String[] {emailvalidation,pincodeValidation,phonenumbervalidation};
		
		
	}
}
