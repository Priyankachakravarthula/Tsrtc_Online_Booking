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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Booking 

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
  public void Bus_On_Contract() throws InterruptedException, IOException 
  {
	        //For referring the file we want to open
			File f=new File("Data/Tsrtc.xlsx");

			//For opening the file in read mode
			FileInputStream fis=new FileInputStream(f);

			XSSFWorkbook w=new XSSFWorkbook(fis);

			//For referring the sheet we want to read
			XSSFSheet s=w.getSheet("Bus_On_Contract_Booking_Page");		        

			int rowsize=s.getLastRowNum();
			System.out.println("No. of rows are:" +rowsize);

			System.out.println("File opened successfully");
			
			Thread.sleep(4000);
			
			driver.get("https://www.tsrtconline.in/oprs-web/login/show.do");
			driver.findElement(By.linkText("Bus on Contract")).click();
			
			 for(int i=1; i<=rowsize; i++)
		      {
		      	String fl=s.getRow(i).getCell(0).toString();
		      	String tl=s.getRow(i).getCell(1).toString();
		     	String dd=s.getRow(i).getCell(2).toString();
		    	String dt=s.getRow(i).getCell(3).toString();
		    	String ad=s.getRow(i).getCell(4).toString();
		    	String at=s.getRow(i).getCell(5).toString();
		    	
		      	WebElement From_Location=driver.findElement(By.id("origin-input"));
		      	From_Location.sendKeys(fl);
		      	

		       	Thread.sleep(4000);
		      	
		      	From_Location.sendKeys(Keys.ARROW_DOWN);

		      	From_Location.sendKeys(Keys.ARROW_DOWN);
		      	
		       	From_Location.sendKeys(Keys.ENTER);
		       	
		       	Thread.sleep(4000);
		      	
		  
		      	WebElement To_Location=driver.findElement(By.id("destination-input"));
		       To_Location.sendKeys(tl);
		       
		     	Thread.sleep(4000);
		       
		       
		       To_Location.sendKeys(Keys.ARROW_DOWN);
		       
		       To_Location.sendKeys(Keys.ENTER);
		       
		       Thread.sleep(4000);
		     
		       try
				{
					
					System.out.println("Clicked on from location ");
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

			
			 
			 //Click on departure date textbox

		       driver.findElement(By.id("startTxtJourneyDate")).click();
		       
		       // click on specific departure date 

		    	WebElement Departure_Date=driver.findElement(By.linkText(dd));
		        Departure_Date.click();
		      
		      
		    	//click on departure time
		    	
		    	Select Departure_Time=new Select(driver.findElement(By.id("startTime")));
		    	Departure_Time.selectByIndex(Integer.parseInt(dt));
		    	
		    	//click on  arrival date textbox
		    	
		    	driver.findElement(By.id("endTxtJourneyDate")).click();
		    	
		    	//click on specific arrival date
		    	
		    	
		    	WebElement Arrival_Date=driver.findElement(By.linkText(ad));
		        Arrival_Date.click();
		      	
		      //click on arrival time
		    	Select  Arrival_Time=new Select(driver.findElement(By.id("endTime")));
		    	 Arrival_Time.selectByIndex(Integer.parseInt(at));
		    
		    	
			Thread.sleep(4000);
						
			//click on return route course 
					
			driver.findElement(By.id("returnStopOversdiv")).click();
			
			//click on continue button
  

			driver.findElement(By.id("searchBtn")).click();
				
			
			 driver.switchTo().alert().accept();
			 
			 Thread.sleep(4000);
			 
			 driver.navigate().back();
			 
			 Thread.sleep(4000);
		      }
  
  }


  @AfterTest
  public void afterTest() 
  {
	  //driver.close();
  }

}
