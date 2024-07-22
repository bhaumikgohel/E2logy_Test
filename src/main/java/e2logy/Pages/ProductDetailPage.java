package e2logy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import e2logy.Base.TestBase;
import e2logy.utils.Util;

public class ProductDetailPage extends TestBase{

	public ProductDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[@class='main_cta']")
	WebElement Addtobag;
	
	
	public String validateProductDetailPageTitle() {
		return driver.getTitle();
	}
	
	public void click_on_add_tobag_button() {
		
		Util.WaitforElement(Addtobag);
		
		Addtobag.click();
	}
	
}
