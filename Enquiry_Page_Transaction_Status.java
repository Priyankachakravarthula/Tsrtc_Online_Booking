package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.Enquiry_Page_Service_Status_By_Ticket_Number_Repo;
import repository.Enquiry_Page_Transaction_Status_Repo;

public class Enquiry_Page_Transaction_Status 
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
  public void Enquiry_Page_Transaction_Status () throws IOException, InterruptedException 
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
			 driver.get("https://www.tsrtconline.in/oprs-web/login/show.do");
		     driver.findElement(By.linkText("Enquiry")).click();
		      
		      Thread.sleep(4000);
		      
		    //click on transaction status
		     driver.findElement(By.id("isTranxSuccess_2")).click();
		      for(int i=1; i<=rowsize; i++)
		      {
		      	String Ob_Ref_Nm=s.getRow(i).getCell(2).toString();
		      	
		      	Enquiry_Page_Transaction_Status_Repo.Ob_Reference_NumberTxt(driver, Ob_Ref_Nm).sendKeys(Ob_Ref_Nm);
		      	//Enquiry_Page_Transaction_Status_Repo.Submit_Button(driver).click();
		      	Enquiry_Page_Transaction_Status_Repo.Ob_Reference_NumberTxt(driver, Ob_Ref_Nm).clear();
		      	
		      	System.out.println(Ob_Ref_Nm+" ");
		    	

  }
  }
 

  @AfterTest
  public void afterTest() {
  }

}
