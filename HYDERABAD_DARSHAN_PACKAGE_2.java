package testNG_Tourism;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class HYDERABAD_DARSHAN_PACKAGE_2 
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
  public void  HYDERABAD_DARSHAN_PACKAGE_2 () throws InterruptedException, IOException 
  {
	       //For referring the file we want to open
			File f=new File("Data/Tsrtc.xlsx");

			//For opening the file in read mode
			FileInputStream fis=new FileInputStream(f);

			XSSFWorkbook w=new XSSFWorkbook(fis);

			//For referring the sheet we want to read
			XSSFSheet s=w.getSheet("Tourism_HYDERABAD_DARSHAN_PG_2");		        

			int rowsize=s.getLastRowNum();
			System.out.println("No. of rows are:" +rowsize);

			System.out.println("File opened successfully");
			 driver.get("https://www.tsrtconline.in/oprs-web/services/packagetours.do");
			 
			 //click on the book now button
			 driver.findElement(By.xpath("/html/body/div[4]/div/form/div/div[2]/div/div/div[4]/div[2]/span/input")).click();
			 
			
			 Thread.sleep(4000);
		      
			  for(int i=1; i<=rowsize; i++)
		      {
		     
		     String fp=s.getRow(i).getCell(0).toString();
		     String tp=s.getRow(i).getCell(1).toString();
		   
		    
					WebElement From_Place=driver.findElement(By.id("fromPlaceName"));
					From_Place.click();
					
					
				  WebElement To_Place=driver.findElement(By.id("toPlaceName"));
		    
				  To_Place.sendKeys(Keys.ARROW_DOWN);
				  

				  To_Place.sendKeys(Keys.ARROW_DOWN);
				  

				  To_Place.sendKeys(Keys.ARROW_DOWN);
				  
				  To_Place.sendKeys(Keys.ARROW_DOWN);
					
				  To_Place.sendKeys(Keys.ENTER);
				
					
					Thread.sleep(4000);

			   String dd=s.getRow(i).getCell(2).toString();
		       String dm=s.getRow(i).getCell(3).toString();
			   String dy=s.getRow(i).getCell(4).toString();
			   String rd=s.getRow(i).getCell(5).toString();
			   String rm=s.getRow(i).getCell(6).toString();
			   String ry=s.getRow(i).getCell(7).toString();

			//click on depart date textbox
			driver.findElement(By.id("txtJourneyDate")).click();
			
			 //select on depart on date
			WebElement depart_on_date=driver.findElement(By.linkText(dd));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",depart_on_date);
			 
			 Thread.sleep(6000);
			
			
			//click on return on  textbox
			driver.findElement(By.id("txtReturnJourneyDate")).click();
			
			 
			 //select on return on  date
			WebElement Return_on_date=driver.findElement(By.linkText(rd));
			Return_on_date.click();

			   
			 driver.findElement(By.id("searchBtn")).click();
			 
			System.out.println(fp+"    "+tp+" "+dd+"  "+dm+"  "+dy+"  "+rd+"  "+rm+"  "+ry);
				
				
				
	  }
	  
			 
			 
		
	
	  
  }
  
  @AfterTest
  public void afterTest() 
  {
	  
  }

}
