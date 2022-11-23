package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.Cancelled_Services_Repo;
import repository.Driver_Information_Repo;

public class Driver_Information 
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
  public void Driver_Information () throws IOException, InterruptedException 
  {
	       //For referring the file we want to open
			File f=new File("Data/Tsrtc.xlsx");

			//For opening the file in read mode
			FileInputStream fis=new FileInputStream(f);

			XSSFWorkbook w=new XSSFWorkbook(fis);

			//For referring the sheet we want to read
			XSSFSheet s=w.getSheet("Driver_Information");		        

			int rowsize=s.getLastRowNum();
			System.out.println("No. of rows are:" +rowsize);

			System.out.println("File opened successfully");
			 driver.get("https://www.tsrtconline.in/oprs-web/services/driverInfo.do");
			 
			 Thread.sleep(4000);
		      
		      for(int i=1; i<=rowsize; i++)
		      {
		     
		     String sn=s.getRow(i).getCell(0).toString();
		     String day=s.getRow(i).getCell(1).toString();
			String mon=s.getRow(i).getCell(2).toString();
			 String yr=s.getRow(i).getCell(3).toString();
			 
			 Driver_Information_Repo.Service_NumberTxt(driver, sn).sendKeys(sn);
			 Driver_Information_Repo.Journey_DateTxt(driver).click();
			 
			 
			 Select month= new Select(Driver_Information_Repo.Month(driver));
			 month.selectByVisibleText(mon);
				
			 Select year= new Select(Driver_Information_Repo.year(driver));
			 year.selectByVisibleText(yr);
				
				Driver_Information_Repo.day(driver, day).click();
				
			// Driver_Information_Repo.Submit_Button(driver).click();
			 Driver_Information_Repo.Service_NumberTxt(driver, sn).clear();
			 
			 System.out.println(sn+" "+day+"  "+mon+"  "+yr);
			 
	  
  }
  }
  
  @AfterTest
  public void afterTest() 
  {
	  
  }

}
