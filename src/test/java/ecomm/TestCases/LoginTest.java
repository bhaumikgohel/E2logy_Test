package ecomm.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ecomm.Base.TestBase;
import ecomm.Pages.AccountPage;
import ecomm.Pages.HomePage;
import ecomm.Pages.LoginPage;

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

	
	@AfterMethod
	public void Terminate() {
		driver.quit();
	}
}
