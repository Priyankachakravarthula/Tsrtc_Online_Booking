package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.Bus_On_Contract_Booking_Repo;

public class Bus_On_Contract_Booking 

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
  public void Bus_On_Contract_Booking() throws IOException, InterruptedException 
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
	    	
	    	//click on from location 
	    	Bus_On_Contract_Booking_Repo.From_Location(driver).sendKeys(fl);
	    	
	    	Thread.sleep(4000);
	      	
	      	Bus_On_Contract_Booking_Repo.From_Location(driver).sendKeys(Keys.ARROW_DOWN);
	      	
	      	Bus_On_Contract_Booking_Repo.From_Location(driver).sendKeys(Keys.ARROW_DOWN);
	      	
	      	Bus_On_Contract_Booking_Repo.From_Location(driver).sendKeys(Keys.ENTER);
	       	
	       	Thread.sleep(4000);
	       	
	       	//click on to location
	       	
	    	Bus_On_Contract_Booking_Repo.To_Location(driver).sendKeys(tl);
	    	
	      	Thread.sleep(4000);
	    	
	    	Bus_On_Contract_Booking_Repo.To_Location(driver).sendKeys(Keys.ARROW_DOWN);
		       
	    	Bus_On_Contract_Booking_Repo.To_Location(driver).sendKeys(Keys.ENTER);
	    	
	    	Thread.sleep(4000);
	    	
	    	//click on start journey date textbox
	    	
	    	Bus_On_Contract_Booking_Repo.startJourneydate_txt(driver).click();
	    
	    	
	    	//click on departure date
	    	Bus_On_Contract_Booking_Repo.Departure_Date(driver, dd).click();
	    	
	    	Thread.sleep(4000);
	    	
	    	//select departure time
	    	Select Departure_Time=new Select(Bus_On_Contract_Booking_Repo.Departure_Time(driver));
	    	Departure_Time.selectByIndex(Integer.parseInt(dt));
	    	
	    	
	    	Thread.sleep(4000);
	    	
	    	//click on end journey date
	    	
	    	Bus_On_Contract_Booking_Repo.endjourneydate_txt(driver).click();
	    	
	    	Thread.sleep(4000);
	    	
	    	//click on arrival date
	    	Bus_On_Contract_Booking_Repo.Arrival_Date(driver, ad).click();
	    	
	    	Thread.sleep(4000);
	    	
	    	//click on arrival time
	    	Select Arrival_Time=new Select(Bus_On_Contract_Booking_Repo.Arrival_Time(driver));
	    	Arrival_Time.selectByIndex(Integer.parseInt(at));
	    	
	    	Thread.sleep(4000);
	    	
	    	//click on Return route course button
	    	
	    	Bus_On_Contract_Booking_Repo.Return_Route_Course(driver).click();
	    	
	    	Thread.sleep(4000);
	    	
	    	//click on continue button
	    	Bus_On_Contract_Booking_Repo.Continue_button(driver).click();
	    	
	    	System.out.println(fl+"  "+tl+"  "+dd+"  "+dt+"  "+ad+"  "+at);
	    	
	    	driver.switchTo().alert().accept();
	    	
	    	
	    	
	    	
	      }
  }
  

  @AfterTest
  public void afterTest()
  {
	  
  }

}
