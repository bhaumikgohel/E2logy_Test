package e2logy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import e2logy.Base.TestBase;

public class HomePage extends TestBase{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='account']")
	WebElement Usericon;
	
	public LoginPage Validate_User_icon() {
		
		Usericon.click();
		
		return new LoginPage();
	}
	
	
	public String verify_HomePage_title() {
		String title = driver.getTitle();
		return title;
	}
}
