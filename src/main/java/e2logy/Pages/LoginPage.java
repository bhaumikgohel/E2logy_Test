package e2logy.Pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import e2logy.Base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//img[@alt='logo']")
	WebElement logo;
	
	// Page Factory 
	
		@FindBy(xpath="//input[@id='CustomerEmail']")
		WebElement username;
		
		@FindBy(xpath = "//input[@id='CustomerPassword']")
		WebElement password;
		
		
		@FindBy(xpath = "//button[contains(text(),'Login')]")
		WebElement loginbtn;

		
		@FindBy(xpath = "//li[text()='Incorrect email or password.']")
		WebElement validationmessage;
		
		
		//img[@alt='account']
		
		//Actions
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		
		public AccountPage Validate_loginfunctionality() throws InterruptedException {
			
			 try {
		            FileInputStream file = new FileInputStream(new File("D:\\Automation\\e2logy\\src\\main\\java\\e2logy\\Resource\\credentials.xls"));

		            // Create Workbook instance holding reference to .xlsx file
		            Workbook workbook = new HSSFWorkbook(file);

		            // Get first/desired sheet from the workbook
		            Sheet sheet = workbook.getSheetAt(0);

		            // Iterate through each row one by one
		            for (int i = 1; i <= sheet.getLastRowNum(); i++) { 
		                Row row = sheet.getRow(i);
		                
		                if(row != null) {
		                	
		                	 Cell usernameCell = row.getCell(0);
		                     Cell passwordCell = row.getCell(1);
		               
		                
		                String user = (usernameCell != null) ? usernameCell.getStringCellValue() : "";
		                String pass = (passwordCell != null) ? passwordCell.getStringCellValue(): "";
		               
		                username.clear();
		                password.clear();
		                
		                username.sendKeys(user);
		                password.sendKeys(pass);
		                loginbtn.click();

		                // Wait for the result
		                try {
		                    Thread.sleep(2000);
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
			
		            }
		         }      
		
			 }catch (IOException e) {
		            e.printStackTrace();
	   }
			 return new AccountPage();
}
}
		

