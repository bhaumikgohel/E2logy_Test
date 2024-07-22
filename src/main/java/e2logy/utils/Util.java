package e2logy.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import e2logy.Base.TestBase;

public class Util extends TestBase{

	
	public static List<String> readSearchTermsFromExcel(String filePath) {
        List<String> searchTerms = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new HSSFWorkbook(fis)) {
             
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null) {
                    searchTerms.add(cell.getStringCellValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return searchTerms;
    }
	
	public static void WaitforElement(WebElement e) {
		FluentWait f = new FluentWait(driver);
		
		f.withTimeout(Duration.ofSeconds(15));
		f.pollingEvery(Duration.ofSeconds(2));
		f.withMessage("Element not found");
		f.ignoring(Exception.class);
		
		f.until(ExpectedConditions.visibilityOf(e));
		
	}
	
	public static void ScrolluptoElement(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", e);
	}
	
}
