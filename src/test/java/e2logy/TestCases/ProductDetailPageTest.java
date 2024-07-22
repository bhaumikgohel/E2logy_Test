package e2logy.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import e2logy.Base.TestBase;
import e2logy.Pages.AccountPage;
import e2logy.Pages.HomePage;
import e2logy.Pages.LoginPage;
import e2logy.Pages.ProductDetailPage;
import e2logy.Pages.SalePage;

public class ProductDetailPageTest extends TestBase{
	
	HomePage homepageobj;
	LoginPage loginobj;
	AccountPage accountpageobj;
	SalePage saleobj;
	ProductDetailPage productdetailobj;
	
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
	}
	
	@Test(priority=1)
	public void Verify_Title() {
		String title = productdetailobj.validateProductDetailPageTitle();
		Assert.assertEquals(title, "Modric Cargo Pant - Black");
		
	}
	
	@Test(priority=2)
	public void Click_on_Sale_Link() {
		productdetailobj.click_on_add_tobag_button();
	}

}
