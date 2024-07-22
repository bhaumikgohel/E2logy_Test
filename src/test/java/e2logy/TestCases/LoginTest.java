package e2logy.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import e2logy.Base.TestBase;
import e2logy.Pages.AccountPage;
import e2logy.Pages.HomePage;
import e2logy.Pages.LoginPage;
import e2logy.Pages.SalePage;

public class LoginTest extends TestBase{
	
	HomePage homepageobj;
	LoginPage loginobj;
	AccountPage accountpageobj;

	public LoginTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		homepageobj = new HomePage();
		loginobj = homepageobj.Validate_User_icon();
		
	}
	
	@Test(priority=1)
	public void Verify_Title() {
		String title = loginobj.validateLoginPageTitle();
		
		Assert.assertEquals(title, "Account");
	}
	
	@Test(priority=2)
	public void login() throws InterruptedException {
		accountpageobj = loginobj.Validate_loginfunctionality();
	}
	
	@Test(priority=3)
	public void Verify_ProductList() {
		
	}

	
	@AfterTest
	public void Terminate() {
		driver.quit();
	}
}
