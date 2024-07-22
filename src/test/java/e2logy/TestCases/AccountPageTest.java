package e2logy.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import e2logy.Base.TestBase;
import e2logy.Pages.AccountPage;
import e2logy.Pages.HomePage;
import e2logy.Pages.LoginPage;
import e2logy.Pages.SalePage;

public class AccountPageTest extends TestBase{
	
	HomePage homepageobj;
	LoginPage loginobj;
	AccountPage accountpageobj;
	SalePage saleobj;
	
	public AccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initilization();
		homepageobj = new HomePage();
		loginobj = homepageobj.Validate_User_icon();
		accountpageobj = loginobj.Validate_loginfunctionality();
	}
	
	@Test(priority=1)
	public void Verify_Title() {
		String title = accountpageobj.verify_AccountPage_title();
		Assert.assertEquals(title, "Account");
		
	}
	
	@Test(priority=2)
	public void Click_on_Sale_Link() {
		saleobj =  accountpageobj.Verify_SalePage_Link();
	}
	
	@AfterMethod
	public void terminate() {
		driver.quit();
	}
}
