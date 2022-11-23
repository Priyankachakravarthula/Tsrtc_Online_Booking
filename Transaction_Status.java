package testNG_Enquiry_Page;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Transaction_Status
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
  public void Transaction_Status() throws IOException, InterruptedException 
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
	    	
	      	Thread.sleep(4000);
	      	WebElement Ob_Reference_NumberTxt=driver.findElement(By.id("bankRefNo"));
	      	Ob_Reference_NumberTxt.sendKeys(Ob_Ref_Nm);
	      	
	      	Ob_Reference_NumberTxt.clear();
	      	
	      	System.out.println(Ob_Ref_Nm + "    " );
	      	
	      	//click on submit button
	      	
	      //	driver.findElement(By.id("searchBtn")).click();
	    	 
	    
	      }

  }
  

  @AfterTest
  public void afterTest() 
  {
	 // driver.close();
  }

}
