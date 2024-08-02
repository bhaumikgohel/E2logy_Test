package ecomm.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecomm.Base.TestBase;
import ecomm.utils.Util;

public class SalePage extends TestBase{

	
	public SalePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//img[@alt='Modric Cargo Pant - Black'])[1]")
	WebElement cargoproduct;
			
	@FindBy(xpath = "(//div[@class='quick_cta_btn'])[1]")
	WebElement Addtobag;
	
	@FindBy(xpath = "//span[contains(text(),'PROCEED TO CHECKOUT')]")
	WebElement Proceedtocheckout;
	
	public String validateSalePageTitle() {
		return driver.getTitle();
	}
	
	public ProductDetailPage Click_on_Product() {
		
		Util.ScrolluptoElement(cargoproduct);
		
		cargoproduct.click();
		
		return new ProductDetailPage();
		
	}
	
}
