package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.Bus_On_Contract_Track_Ticket_Repo;

public class Bus_On_Contract_Track_Ticket 
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
  public void Bus_On_Contract_Track_Ticket() throws IOException, InterruptedException 
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
		      	
		      	Bus_On_Contract_Track_Ticket_Repo.Ticket_NumberTxt(driver, tn).sendKeys(tn);
		      	Bus_On_Contract_Track_Ticket_Repo.Mobile_NumberTxt(driver, mn).sendKeys(mn);
		      	//Bus_On_Contract_Track_Ticket_Repo.Search_Button(driver).click();
		      	
		      	Bus_On_Contract_Track_Ticket_Repo.Ticket_NumberTxt(driver, tn).clear();
		      	Bus_On_Contract_Track_Ticket_Repo.Mobile_NumberTxt(driver, mn).clear();
		      	
		      	System.out.println(tn+"  "+mn);
		     	
  }
  }
 

  @AfterTest
  public void afterTest() {
  }

}
