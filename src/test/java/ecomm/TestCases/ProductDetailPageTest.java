package ecomm.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ecomm.Base.TestBase;
import ecomm.Pages.AccountPage;
import ecomm.Pages.CheckOutPage;
import ecomm.Pages.HomePage;
import ecomm.Pages.LoginPage;
import ecomm.Pages.ProductDetailPage;
import ecomm.Pages.SalePage;

public class ProductDetailPageTest extends TestBase{
	
	HomePage homepageobj;
	LoginPage loginobj;
	AccountPage accountpageobj;
	SalePage saleobj;
	ProductDetailPage productdetailobj;
	CheckOutPage checkoutobj;
	
	public ProductDetailPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initilization();
		homepageobj = new HomePage();
		loginobj = homepageobj.Validate_User_icon();
		accountpageobj = loginobj.Validate_loginfunctionality();
		saleobj = accountpageobj.Verify_SalePage_Link();
		productdetailobj=saleobj.Click_on_Product();
	}
	
	@Test(priority=1)
	public void Verify_Title() {
		String title = productdetailobj.validateProductDetailPageTitle();
		Assert.assertEquals(title, "Modric Cargo Pant - Black");
		
	}
	
	@Test(priority=2)
	public void Verify_Cart_Functionality() {
		boolean isbagempty = productdetailobj.Verify_cart_Functionality();
		
		Assert.assertTrue(isbagempty);
	}
	
	@Test(priority=3)
	public void Click_on_Addtobag_Button() throws InterruptedException {
		checkoutobj = productdetailobj.click_on_add_tobag_button();
	}
	
	@AfterMethod
	public void Terminate() {
		driver.quit();
	}
	
}
