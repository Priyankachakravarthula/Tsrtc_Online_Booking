package testcases;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.eTicket_Invalid_Login_Repo;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class eTicket_Invalid_Login_Page 
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
  public void eTicket_Invalid_Login_Page () throws IOException, InterruptedException 
  {
      //For referring the file we want to open
      File f=new File("Data/Tsrtc.xlsx");
      
      //For opening the file in read mode
      FileInputStream fis=new FileInputStream(f);
      
      System.out.println("File opened successfully");
      
      XSSFWorkbook w=new XSSFWorkbook(fis);
      
      //For referring the sheet we want to read
      XSSFSheet s=w.getSheet("Tsrtc_eTicket_Invalid_Login");		        
      
      int rowsize=s.getLastRowNum();
      System.out.println("No. of rows are:" +rowsize);
      
      Thread.sleep(4000);
      driver.get("https://www.tsrtconline.in/oprs-web/login/show.do");
      Thread.sleep(4000);
      
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  for(int i=1; i<=rowsize; i++)
      {
	  String un=s.getRow(i).getCell(0).toString();
      String pwd=s.getRow(i).getCell(1).toString();
      
	  eTicket_Invalid_Login_Repo.username(driver).sendKeys(un);
	  eTicket_Invalid_Login_Repo.password(driver).sendKeys(pwd);
	 
	   eTicket_Invalid_Login_Repo.login(driver).click();
	  
	  if(driver.getPageSource().contains("errorMsg"))
	  {
		  eTicket_Invalid_Login_Repo.username(driver).clear();
		  eTicket_Invalid_Login_Repo.password(driver).clear();
		  
		  System.out.println("username and password field cleared");
		  
		  System.out.println(un+"  "+pwd);
	  }
	   

	  
  }
  }
 

  @AfterTest
  public void afterTest() 
  {
	  
  }

}
