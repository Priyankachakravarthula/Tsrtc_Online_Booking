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
import repository.ATB_Forgot_Password_Repo;

public class ATB_Forgot_Password 
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
  public void ATB_Forgot_Password () throws IOException, InterruptedException 
  {
	    //For referring the file we want to open
		File f=new File("Data/Tsrtc.xlsx");

		//For opening the file in read mode
		FileInputStream fis=new FileInputStream(f);

		XSSFWorkbook w=new XSSFWorkbook(fis);

		//For referring the sheet we want to read
		XSSFSheet s=w.getSheet("ATB_Forgot_Password");		        

		int rowsize=s.getLastRowNum();
		System.out.println("No. of rows are:" +rowsize);

		System.out.println("File opened successfully");
		
		Thread.sleep(4000);
		
		driver.get("https://www.tsrtconline.in/oprs-web/login/show.do");
		driver.findElement(By.linkText("ATB/OPR Login")).click();
		driver.findElement(By.linkText("Forgot Password")).click();
		
		 for(int i=1; i<=rowsize; i++)
	      {
	      	String email=s.getRow(i).getCell(0).toString();
	      	
	      	ATB_Forgot_Password_Repo.Email(driver).sendKeys(email);
	      	
	       	Thread.sleep(4000);
	      	
	       	ATB_Forgot_Password_Repo.Email(driver).clear();
	       	
	     
	        System.out.println(email);
	    
		
	      }
  }
 

  @AfterTest
  public void afterTest() {
  }

}
