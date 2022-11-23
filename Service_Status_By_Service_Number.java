package testNG_Enquiry_Page;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Service_Status_By_Service_Number

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
  public void Service_Status_By_Service_Number () throws IOException, InterruptedException 
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
		
		//click on service status

		driver.findElement(By.id("isTranxSuccess_5")).click();
		Thread.sleep(3000);
		
		//click on by service number
		
		driver.findElement(By.id("serviceStatus_2")).click();
		

		Thread.sleep(4000);

		for(int i=1; i<=rowsize; i++)
		{

			String sn=s.getRow(i).getCell(8).toString();
			String day=s.getRow(i).getCell(9).toString();
			String dm=s.getRow(i).getCell(10).toString();
			String dy=s.getRow(i).getCell(11).toString();
		
			WebElement Service_NumberTxt=driver.findElement(By.id("serviceCode"));
			Service_NumberTxt.sendKeys(sn);
			
			//click on departure date textbox
			
			WebElement Departure_dateTxt=driver.findElement(By.id("txtDepartureDate"));
			 Departure_dateTxt.click();
			 
			 //select departure month
			 
			 Select Month=new Select(driver.findElement(By.className("ui-datepicker-month")));
			Month.selectByVisibleText(dm);
			
			//select departure year

			Select Year=new Select(driver.findElement(By.className("ui-datepicker-year")));
			Year.selectByVisibleText(dy);
			 
			//select departure date

			driver.findElement(By.linkText(day)).click();
			

			System.out.println(sn + " "+day+"  "+dm+"  "+dy);
			
			
			System.out.println("Text field cleared");

			System.out.println();

		}
  }
 

  @AfterTest
  public void afterTest()
  {
	  
  }

}
