package e2logy.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import e2logy.Base.TestBase;
import e2logy.utils.Util;

public class HomePage extends TestBase{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='account']")
	WebElement Usericon;
	
	//img[@class='search_btn for_desktop_only']
	@FindBy(xpath="//img[@class='search_btn for_desktop_only']")
	WebElement Searchbox;
	
	@FindBy(xpath="//input[@id='boost-sd__search-widget-init-input-0']")
	WebElement Searchtxt;
	
	@FindBy(xpath="//img[@alt='logo']")
	WebElement logo;
	
	@FindBy(xpath="//div[@class='cart_icon not_empty']")
	WebElement MyCartIcon;
	
	@FindBy(xpath="//div[@class='for_desktop_only']")
	WebElement Navigationmenu;
	
	@FindBy(xpath="//a[contains(text(),'NEW RELEASES')]")
	WebElement newrelease;
	
	@FindBy(xpath="//div[@class='footer-top']")
	WebElement footersection;
	
	public LoginPage Validate_User_icon() {
		
		Usericon.click();
		
		return new LoginPage();
	}
	
	public boolean verify_logo() {
		return logo.isDisplayed();
		
	}
	
	public boolean verify_header() {
		return Navigationmenu.isDisplayed();
		
	}
	
	public String verify_HomePage_title() {
		String title = driver.getTitle();
		return title;
	}
	
	public void SearchPageDataUsingDataDriven() throws InterruptedException {
		
		String SearchDataFile = "D:\\Automation\\e2logy\\src\\main\\java\\e2logy\\Resource\\searchdata.xls";
		
		List<String> SearchData = Util.readSearchTermsFromExcel(SearchDataFile);
	     
		Searchbox.click();
		
	     for (String searchTerm : SearchData) {
	    	 
	    	 
	    	 Searchtxt.clear();
	    	 Searchtxt.sendKeys(searchTerm);
	         
	    	 Searchtxt.sendKeys(Keys.ENTER);
	    	 
	    	 Thread.sleep(2000);
	    	 
//	    	 Util.WaitforElement(driver.findElement(By.xpath("//h3[@class='boost-sd__header-item boost-sd__instant-search-product-list-header']")));
	    	 
	         try {
	             Thread.sleep(2000);
	         } catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	         driver.get("https://www.beeinspiredclothing.com/");
	         
	         Searchbox.click();
	     }
	     
		
	}
	
	public boolean verify_footer() {
		return footersection.isDisplayed();
	}
}
