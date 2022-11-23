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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Tsrtc_Ticket_Enquiry_Page 

{
	WebDriver driver;
	Select sel; //Globally Declaration
	
	 @BeforeTest
	  public void beforeTest()
	 {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
	  }
  @Test
  public void f() throws IOException, InterruptedException 
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

			Thread.sleep(4000);
			driver.get("https://www.tsrtconline.in/oprs-web/login/show.do");
			driver.findElement(By.linkText("Enquiry")).click();
			
			 
		      for(int i=1; i<=rowsize; i++)
		      {
		      	String tn=s.getRow(i).getCell(0).toString();
		      	String mn=s.getRow(i).getCell(1).toString();
		      	
		      	System.out.println(tn + "    "   +mn);
		      	
		      	
		      	
		      	WebElement Ticket_Numbertxt=driver.findElement(By.id("id"));
		      	Ticket_Numbertxt.sendKeys(tn);
		      	
		      	WebElement Mobile_Numbertxt=driver.findElement(By.id("mobileNo"));
		      	Mobile_Numbertxt.sendKeys(mn);
		      	
		      	Ticket_Numbertxt.clear();
		      	Mobile_Numbertxt.clear();
	
		      	//driver.findElement(By.id("searchBtn")).click();
				
		      	
		      }	
		      
		      
  }
  
 

  @AfterTest
  public void afterTest()
  {
	  driver.close();
  }

}
