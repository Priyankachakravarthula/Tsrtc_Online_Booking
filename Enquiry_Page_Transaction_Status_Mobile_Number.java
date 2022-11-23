package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.Driver_Information_Repo;
import repository.Enquiry_page_Transaction_Status_Mobile_Number_Repo;

public class Enquiry_Page_Transaction_Status_Mobile_Number 
{
	     WebDriver driver;
	
	@BeforeTest
	  public void beforeTest() 
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		
	  }
  @Test
  public void Enqiry_Page_Transaction_Status_Mobile_Number() throws IOException, InterruptedException 
  {
	       //For referring the file we want to open
			File f=new File("Data/Tsrtc.xlsx");

			//For opening the file in read mode
			FileInputStream fis=new FileInputStream(f);

			XSSFWorkbook w=new XSSFWorkbook(fis);

			//For referring the sheet we want to read
			XSSFSheet s=w.getSheet("Tsrtc_Enquiry");		        

			int rowsize=s.getLastRowNum();
			System.out.println("No. of rows are:" +rowsize);

			System.out.println("File opened successfully");
			driver.get("https://www.tsrtconline.in/oprs-web/ticket/waitlist.do");

			driver.findElement(By.id("isTranxSuccess_2")).click();
			Thread.sleep(3000);
			WebElement Mobile_No=driver.findElement(By.id("TransactionStatus_2"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",Mobile_No);


			Thread.sleep(4000);

			for(int i=1; i<=rowsize; i++)
			{

				String mn=s.getRow(i).getCell(3).toString();
				String day=s.getRow(i).getCell(4).toString();
				String mon=s.getRow(i).getCell(5).toString();
				String yr=s.getRow(i).getCell(6).toString();
				
				Enquiry_page_Transaction_Status_Mobile_Number_Repo.Mobile_Number_Txt(driver).sendKeys(mn);
				Enquiry_page_Transaction_Status_Mobile_Number_Repo.Transaction_date_Txt(driver).click();
				
				 Select month= new Select(Enquiry_page_Transaction_Status_Mobile_Number_Repo.Month(driver));
				 month.selectByVisibleText(mon);
					
				 Select year= new Select(Enquiry_page_Transaction_Status_Mobile_Number_Repo.year(driver));
				 year.selectByVisibleText(yr);
				 
				Enquiry_page_Transaction_Status_Mobile_Number_Repo.day(driver, day).click();
				
				Enquiry_page_Transaction_Status_Mobile_Number_Repo.Mobile_Number_Txt(driver).clear();
				
				System.out.println(mn + " "+day+"  "+mon+" "+yr);
  }
  }
  

  @AfterTest
  public void afterTest() {
  }

}
