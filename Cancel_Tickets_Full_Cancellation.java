package testNG_Bus_On_Contract_Page;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Cancel_Tickets_Full_Cancellation 
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
  public void Cancel_Tickets_Full_Cancellation () throws  IOException, InterruptedException 
  {
	

	        //For referring the file we want to open
			File f=new File("Data/Tsrtc.xlsx");

			//For opening the file in read mode
			FileInputStream fis=new FileInputStream(f);

			XSSFWorkbook w=new XSSFWorkbook(fis);

			//For referring the sheet we want to read
			XSSFSheet s=w.getSheet("BOC_CT_Full_Cancellation");		        

			int rowsize=s.getLastRowNum();
			System.out.println("No. of rows are:" +rowsize);

			System.out.println("File opened successfully");
			
			Thread.sleep(4000);
			
			driver.get("https://www.tsrtconline.in/oprs-web/hire/cancelTicket.do");
			
			//click on full cancellation 
			
			driver.findElement(By.id("searchType_1")).click();
			
			
			
			  for(int i=1; i<=rowsize; i++)
		      {
		     
		     String tn=s.getRow(i).getCell(0).toString();
		    String un=s.getRow(i).getCell(1).toString();
		    String mn=s.getRow(i).getCell(2).toString();
		    
				WebElement Ticket_NumberTxt=driver.findElement(By.id("id"));
				Ticket_NumberTxt.sendKeys(tn);
				
			  WebElement UID_NumberTxt=driver.findElement(By.id("uidNumber"));
			 UID_NumberTxt.sendKeys(un);
			 
			 WebElement Mobile_NumberTxt=driver.findElement(By.id("mobileNo"));
			 Mobile_NumberTxt.sendKeys(mn);
			 
			 WebElement Search_Button=driver.findElement(By.id("searchBtn"));
			 Search_Button.click();
			
			System.out.println(tn+"  "+un+"  "+mn);
			 
			 driver.findElement(By.id("resetBtn")).click();
			 
			 
			 try
				{
				
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

			 
			 
				
			    Ticket_NumberTxt.clear(); 
			    UID_NumberTxt.clear();
				Mobile_NumberTxt.clear();
				System.out.println("Text field cleared");
				
				

				System.out.println();

			}
  }
		      
		  
	  
  
  

  @AfterTest
  public void afterTest() 
  {
	  
  }

}
