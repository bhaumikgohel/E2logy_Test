package ecomm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecomm.Base.TestBase;

public class AddtoCartPage extends TestBase{

	public AddtoCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='main_cta']")
	WebElement Addtobag;
	
	
	public String validateProductDetailPageTitle() {
		return driver.getTitle();
	}
	
}
