package ecomm.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecomm.Base.TestBase;
import ecomm.utils.Util;

public class ProductDetailPage extends TestBase{

	public ProductDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[@class='main_cta']")
	WebElement Addtobag; 
	
	@FindBy(xpath = "(//div[@class='matt_pcard_bt'])[1]")
	WebElement First_Product; 
	
	@FindBy(xpath = "//div[@class='empty_cart_msg']")
	WebElement Cartmsg; 
	
	@FindBy(xpath = "//img[@class='cart']")
	WebElement Cartbag; 
	
	@FindBy(xpath = "//img[@class='close_cd']")
	WebElement Cartclose; 

	@FindBy(xpath = "//div[@class='checkout']")
	WebElement Checkoutbtn; 
	
	public String validateProductDetailPageTitle() {
		return driver.getTitle();
	}
	
	public CheckOutPage click_on_add_tobag_button() throws InterruptedException {
		
		Util.WaitforElement(Addtobag);
		
		Addtobag.click();
		
		Thread.sleep(3000);
		
		Util.WaitforElement(Checkoutbtn);
		
		Checkoutbtn.click();
		
		return new CheckOutPage();
	}
	
	public boolean Verify_cart_Functionality() {
		
		Cartbag.click();
		
		Util.WaitforElement(Cartclose);
		
		String count = Cartmsg.getText();
		
		System.out.println(count);
		
		boolean bagtext = count.contains("Your bag is currently empty. Not sure where to start?");
		
		
		Cartclose.click();
		
		return bagtext;
		
	}
		
	
		
}
