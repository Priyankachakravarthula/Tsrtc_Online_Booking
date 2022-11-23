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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class TTD_SED_DARSHAN_PACKAGE 
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
  public void TTD_SED_DARSHAN_PACKAGE() throws IOException, InterruptedException 
  {
	       //For referring the file we want to open
			File f=new File("Data/Tsrtc.xlsx");

			//For opening the file in read mode
			FileInputStream fis=new FileInputStream(f);

			XSSFWorkbook w=new XSSFWorkbook(fis);

			//For referring the sheet we want to read
			XSSFSheet s=w.getSheet("Tourism_TTD_SED_DARSHAN_PACKAGE");		        

			int rowsize=s.getLastRowNum();
			System.out.println("No. of rows are:" +rowsize);

			System.out.println("File opened successfully");
			 driver.get("https://www.tsrtconline.in/oprs-web/services/packagetours.do");
			 
			 //click on the book now button
			 driver.findElement(By.name("searchBtn")).click();
			 
			
			 Thread.sleep(4000);
		      
			  for(int i=1; i<=rowsize; i++)
		      {
		     
		     String fp=s.getRow(i).getCell(0).toString();
		     String tp=s.getRow(i).getCell(1).toString();
		   
		    
			 
					
					WebElement From_Place=driver.findElement(By.id("fromPlaceName"));
					From_Place.sendKeys(fp);
					
					From_Place.sendKeys(Keys.ARROW_DOWN);
				   	
					From_Place.sendKeys(Keys.ENTER);
					
				  WebElement To_Place=driver.findElement(By.id("toPlaceName"));
		    
				
			 
			  //To_Place.sendKeys(tp);
			 
			  
				//click on depart date textbox
					WebElement Journeydate=driver.findElement(By.id("txtJourneyDate"));

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();",Journeydate);
					
					Thread.sleep(4000);


					
					    String dd=s.getRow(i).getCell(2).toString();
					    String dm=s.getRow(i).getCell(3).toString();
					    String dy=s.getRow(i).getCell(4).toString();
					    String rd=s.getRow(i).getCell(5).toString();
					    String rm=s.getRow(i).getCell(6).toString();
					    String ry=s.getRow(i).getCell(7).toString();

			 //select on journey date
			WebElement Depart_on_date=driver.findElement(By.linkText(dd));
			 Depart_on_date.click();
			 
			 Thread.sleep(6000);
			
			//click on return on  textbox
			driver.findElement(By.id("txtReturnJourneyDate")).click();
			
			
			 //select on journey date
			WebElement Return_on_date=driver.findElement(By.linkText(rd));
			 Return_on_date.click();
			
			
			 driver.findElement(By.id("searchBtn")).click();
			 
			 Thread.sleep(5000);
			 
			 //click on select seats button
			 
				driver.findElement(By.id("SrvcSelectBtnForward0")).click();
				
				
				 Thread.sleep(4000);
				 
				 Select Boarding_Point=new Select(driver.findElement(By.id("ForwardBoardId")));
				 Boarding_Point.selectByIndex(3);
				 
				 Select Dropping_Point=new Select(driver.findElement(By.id("ForwardDroppingId")));
				 Dropping_Point.selectByIndex(1);
				
				Select Concession =new Select(driver.findElement(By.id("concessionId")));
				 Concession.selectByIndex(2);
				 
				//click on show layout button
				 
				 driver.findElement(By.id("fwLtBtn")).click();
				 
				 Thread.sleep(4000);
				 
				 driver.switchTo().alert().accept();
				 
				 Thread.sleep(4000);
				 
				 //click on select seats
				 driver.findElement(By.xpath("/html/body/div[4]/div/form/div/div[3]/div[3]/div[1]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[1]/td/table/tbody/tr[3]/td[2]/div/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td[7]")).click();
				 
				 //Passenger details
				 
				 String card_no=s.getRow(i).getCell(8).toString();
				 String name=s.getRow(i).getCell(9).toString();
				 String mobile_num=s.getRow(i).getCell(10).toString();
				 String email=s.getRow(i).getCell(11).toString();
				 String age=s.getRow(i).getCell(12).toString();
				 
				 //click on Card Number textbox
				 WebElement Card_Number=driver.findElement(By.id("cardNumber"));
				 Card_Number.sendKeys(card_no);
				 
				 //click on booked by name textbox
				 WebElement Booked_By_Name=driver.findElement(By.id("bookedByName"));
				 Booked_By_Name.sendKeys(name);
				 
				 //click on Mobile number textbox
				 WebElement Mobile_Number=driver.findElement(By.id("mobileNo"));
				 Mobile_Number.sendKeys(mobile_num);
				 
				 
				 //click on Email id textbox
				 WebElement Email_Id=driver.findElement(By.id("email"));
				 Email_Id.sendKeys(email);
				 
				 //click on the gender dropdown
				 
				 Select gender=new Select(driver.findElement(By.id("genderCodeIdForward0")));
				 gender.selectByIndex(1);
				 
				 //click on age textbox
				 
				 WebElement Age=driver.findElement(By.id("passengerAgeForward0"));
				 Age.sendKeys(age);
				 
				 //click on Book Return button
				 
				 driver.findElement(By.xpath("/html/body/div[4]/div/form/div/div[3]/div[3]/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td/div/input")).click();

					System.out.println(fp+"    "+tp+" "+dd+"  "+dm+"  "+dy+"  "+rd+"  "+rm+"  "+ry+"  "
					+name+"  "+mobile_num+"  "+email+"  "+age);
					
					
		  }
			 
			 
				
		      
  }
		       

  @AfterTest
  public void afterTest() 
  {
	  //driver.close();
 }

}
