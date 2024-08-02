package ecomm.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ecomm.Base.TestBase;
import ecomm.Pages.AccountPage;
import ecomm.Pages.CheckOutPage;
import ecomm.Pages.HomePage;
import ecomm.Pages.LoginPage;
import ecomm.Pages.ProductDetailPage;
import ecomm.Pages.SalePage;
import ecomm.utils.Util;

public class CheckOutTest extends TestBase{
	
	
	HomePage homepageobj;
	LoginPage loginobj;
	AccountPage accountpageobj;
	SalePage saleobj;
	ProductDetailPage productdetailobj;
	CheckOutPage checkoutobj;
	
	String sheetName = "checkoutdata";
	
	public CheckOutTest() {
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
		checkoutobj = productdetailobj.click_on_add_tobag_button();
	}

	@Test(priority=1)
	public void Check_Check_Out_Page_Title_Test() {
		String CheckOutPageTitle = checkoutobj.VerifyCheckoutPageTitle();
		
		Assert.assertEquals(CheckOutPageTitle, "Checkout - Bee Inspired Clothing");
	}
	
	@Test(priority=2)
	public void CheckOutRequiredFieldValidationTest() throws InterruptedException {
		String[] checkoutvalidation = checkoutobj.CheckRequiredFieldValidationMessage();
		Assert.assertEquals(checkoutvalidation[0], "The email address is not valid");
		Assert.assertEquals(checkoutvalidation[1], "Enter a first name");
		Assert.assertEquals(checkoutvalidation[2], "Enter a last name");
		Assert.assertEquals(checkoutvalidation[3], "Enter an address");
		Assert.assertEquals(checkoutvalidation[4], "Enter a city");
		Assert.assertEquals(checkoutvalidation[5], "Enter a ZIP / postal code");
		Assert.assertEquals(checkoutvalidation[6], "Enter a phone number");
	}
	
	@DataProvider
	public Object[][] getCheckOutData(){
		Object data[][] = Util.AddCheckoutdata(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider = "getCheckOutData")
	public void VerifyCheckOutFunctionalitywithNagativeValueTest(String email, String firstname, String lastname, String address, String city, String pincode, String phonenumber) throws InterruptedException {
		String[] FieldValidation = 	checkoutobj.CheckFieldsValidationsMessagesWithNagativeValue(email, firstname, lastname, address, city, pincode, phonenumber);
		
		Assert.assertEquals(FieldValidation[0], "Enter a valid email");
		Assert.assertEquals(FieldValidation[1], "Enter a valid postal code for Gujarat");
		Assert.assertEquals(FieldValidation[2], "Enter a valid phone number");
		
	}
	
	@AfterMethod
	public void terminate() {
		driver.quit();
	}
}
