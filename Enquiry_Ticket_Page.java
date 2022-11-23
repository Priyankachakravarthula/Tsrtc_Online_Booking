package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.Enquiry_Ticket_Page_Repo;

public class Enquiry_Ticket_Page 
{
	       WebDriver driver;
	
	@BeforeTest
	  public void beforeTest() 
	{

		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
	  }
  @Test
  public void Enquiry_Ticket_Page () throws IOException, InterruptedException 
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
	      	
	      	Enquiry_Ticket_Page_Repo.Ticket_Numbertxt(driver, tn).sendKeys(tn);
	      	Enquiry_Ticket_Page_Repo.Mobile_Numbertxt(driver, mn).sendKeys(mn);
	      	//Enquiry_Ticket_Page_Repo.Submit_Button(driver).click();
	      	Enquiry_Ticket_Page_Repo.Ticket_Numbertxt(driver, tn).clear();
	      	Enquiry_Ticket_Page_Repo.Mobile_Numbertxt(driver, mn).clear();
	      	
  }
  }
  

  @AfterTest
  public void afterTest() {
  }

}
