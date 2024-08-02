package ecomm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecomm.Base.TestBase;

public class AccountPage extends TestBase{

	public AccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='s_lnk sale_link']")
	WebElement Sale;
	
	
	public String verify_AccountPage_title() {
		String title = driver.getTitle();
		return title;
	}
	
	public SalePage Verify_SalePage_Link() {
		Sale.click();
		
		return new SalePage();
	}
}
