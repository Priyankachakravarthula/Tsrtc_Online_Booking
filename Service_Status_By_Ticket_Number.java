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

public class Service_Status_By_Ticket_Number 

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
  public void Service_Status_By_Ticket_Number() throws IOException, InterruptedException 
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
			
			//click on by ticket number
			
			driver.findElement(By.id("serviceStatus_1")).click();
			

			Thread.sleep(4000);

			for(int i=1; i<=rowsize; i++)
			{

				String tn=s.getRow(i).getCell(7).toString();
			
				
				System.out.println(tn + " ");
				

				WebElement Ticket_NumberTxt=driver.findElement(By.id("id1"));
				Ticket_NumberTxt.sendKeys(tn);
				
				
				Ticket_NumberTxt.clear();
				
				System.out.println("Text field cleared");

				System.out.println();
	  
			}
				
				
  }
  
  @AfterTest
  public void afterTest()
  {
	  
  }

}
