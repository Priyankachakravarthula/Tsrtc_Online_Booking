package testNG_Bus_On_Contract_Page;

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

public class Track_Ticket

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
  public void trackticket() throws InterruptedException, IOException 
  {
	    //For referring the file we want to open
		File f=new File("Data/Tsrtc.xlsx");
		//For opening the file in read mode
		FileInputStream fis=new FileInputStream(f);

		XSSFWorkbook w=new XSSFWorkbook(fis);

		//For referring the sheet we want to read
		XSSFSheet s=w.getSheet("Bus_On_Contract_Trackticket");		        

		int rowsize=s.getLastRowNum();
		System.out.println("No. of rows are:" +rowsize);

		System.out.println("File opened successfully");
		
		Thread.sleep(4000);
		
		driver.get("https://www.tsrtconline.in/oprs-web/special/hire/track.do");
		
		
		
		 for(int i=1; i<=rowsize; i++)
	      {
	      	String tn=s.getRow(i).getCell(0).toString();
	      	String mn=s.getRow(i).getCell(1).toString();
	     	
	    	
	      	WebElement Ticket_Number=driver.findElement(By.id("id"));
	      	Ticket_Number.sendKeys(tn);
	      	

	    	WebElement Mobile_Number=driver.findElement(By.id("mobileNo"));
	    	Mobile_Number.sendKeys(mn);
	      	
	       	Thread.sleep(4000);
	       	
	       	Ticket_Number.clear();
	       	Mobile_Number.clear();
	       	
	       	System.out.println(tn+"  "+mn);
	       	
	       	
	      	
	      	//driver.findElement(By.id("searchBtn")).click();
	      }	
	  
  }

  @AfterTest
  public void afterTest() 
  { 
	  driver.close();
	  
  }
  }


