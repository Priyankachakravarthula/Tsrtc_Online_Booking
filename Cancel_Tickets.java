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
import repository.Cancel_Tickets_Repo;

public class Cancel_Tickets 

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
  public void Cancel_Tickets () throws IOException, InterruptedException 
  {
	        //For referring the file we want to open
			File f=new File("Data/Tsrtc.xlsx");

			//For opening the file in read mode
			FileInputStream fis=new FileInputStream(f);

			XSSFWorkbook w=new XSSFWorkbook(fis);

			//For referring the sheet we want to read
			XSSFSheet s=w.getSheet("Cancel_Tickets");		        

			int rowsize=s.getLastRowNum();
			System.out.println("No. of rows are:" +rowsize);

			System.out.println("File opened successfully");
			 driver.get("https://www.tsrtconline.in/oprs-web/guest/ticket/cancel.do");
			 
			
			 Thread.sleep(4000);
		      
		      for(int i=1; i<=rowsize; i++)
		      {
		     
		     String tn=s.getRow(i).getCell(0).toString();
		    String un=s.getRow(i).getCell(1).toString();
		    String mn=s.getRow(i).getCell(2).toString();
		    
		    Cancel_Tickets_Repo.Ticket_NumberTxt(driver, tn).sendKeys(tn);
		    Cancel_Tickets_Repo.UID_NumberTxt(driver, un).sendKeys(un);
		    Cancel_Tickets_Repo.Mobile_NumberTxt(driver, mn).sendKeys(mn);
		    Cancel_Tickets_Repo.Ticket_NumberTxt(driver, tn).clear();
		    Cancel_Tickets_Repo.UID_NumberTxt(driver, un).clear();
		    Cancel_Tickets_Repo.Mobile_NumberTxt(driver, mn).clear();
		    
		   System.out.println(tn+" "+un+" "+mn);
		   
	 
  }
  }
  

  @AfterTest
  public void afterTest() {
  }

}
