package e2logy.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import e2logy.Base.TestBase;
import e2logy.Pages.HomePage;
import e2logy.Pages.LoginPage;


public class HomePageTest extends TestBase{
	
	HomePage homepageobj;
	LoginPage loginpageobj;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initilization();
		homepageobj = new HomePage();
	}
	
	@Test(priority=1)
	public void Verify_HomepageTitle() {
		
		String title = homepageobj.verify_HomePage_title();
		
		Assert.assertEquals(title, "Bee Inspired | To Achieve More Than You Ever Thought Possible.");
	}
	
	@Test(priority=2)
	public void Verify_user_icon() {
		loginpageobj = homepageobj.Validate_User_icon();
	}
	
	@AfterMethod
	public void Terminate() {
		driver.quit();
	}
}
