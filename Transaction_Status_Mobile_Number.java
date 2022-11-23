package testNG_Enquiry_Page;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class Transaction_Status_Mobile_Number

{
	WebDriver driver;
	Select sel; //Globally Declaration

	@BeforeTest
	public void beforeTest()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void Transaction_Status_Mobile_Number() throws IOException, InterruptedException
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
			
			System.out.println(mn + " "+day+"  "+mon+" "+yr);
			

			WebElement Mobile_NumberTxt=driver.findElement(By.id("tranxMobileNo"));
			Mobile_NumberTxt.sendKeys(mn);
			
			Thread.sleep(5000);
			
			//click on Booked date textbox
			
			driver.findElement(By.id("tranxDate")).click();
			
			Thread.sleep(5000);
			
			//select month
			Select Month=new Select(driver.findElement(By.className("ui-datepicker-month")));
			Month.selectByVisibleText(mon);
			
			//select year

			Select Year=new Select(driver.findElement(By.className("ui-datepicker-year")));
			Year.selectByVisibleText(yr);
			
			//select day
			
			driver.findElement(By.linkText(day)).click();
			//Thread.sleep(3000);

		
			Thread.sleep(3000);
			WebElement Submit_Button=driver.findElement(By.id("searchBtn"));
			//Submit_Button.click();
			try
			{
				js.executeScript("arguments[0].click();",Submit_Button);
				System.out.println("Clicked on submit button");
				try 
				{
					System.out.println(driver.switchTo().alert().getText());
					Thread.sleep(4000);
					driver.switchTo().alert().accept();
				}
				catch(Exception e)
				{
					
					System.out.println("Alert is not present");
				}
				
			}
			catch(Exception e)
			{
				System.out.println("Exception is: "+e);
			}

			System.out.println();

			Mobile_NumberTxt.clear();
			
			System.out.println("Text field cleared");

			

		}
	}


	@AfterTest
	public void afterTest()
	{
		//driver.close();
	}



}
