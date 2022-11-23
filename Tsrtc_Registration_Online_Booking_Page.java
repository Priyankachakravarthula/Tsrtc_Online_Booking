package testNG_Registration_Page;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Tsrtc_Registration_Online_Booking_Page 
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
  public void Registration_Page() throws InterruptedException, IOException
  {

	  //For referring the file we want to open
      File f=new File("Data/Tsrtc.xlsx");
      
      //For opening the file in read mode
      FileInputStream fis=new FileInputStream(f);
      
      XSSFWorkbook w=new XSSFWorkbook(fis);
      
      //For referring the sheet we want to read
      XSSFSheet s=w.getSheet("Tsrtc_Registration");		        
      
      int rowsize=s.getLastRowNum();
      System.out.println("No. of rows are:" +rowsize);
      
      //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
      
      
      System.out.println("File opened successfully");
      
      Thread.sleep(4000);
      driver.get("https://www.tsrtconline.in/oprs-web/login/show.do");
      driver.findElement(By.linkText("SignUp")).click();
      
      Thread.sleep(4000);
      
      	WebElement Login_Name=driver.findElement(By.id("loginName"));
        Login_Name.sendKeys("test@123");
      	
      	WebElement Full_Name=driver.findElement(By.id("fullName"));
       Full_Name.sendKeys("Priyankachakravarthula");
      	
      	WebElement Email=driver.findElement(By.id("email"));
      	Email.sendKeys("demouser@gmail.com");
      	
      	sel=new Select(driver.findElement(By.id("genderId")));
      	sel.selectByIndex(1);
      	
      	Thread.sleep(4000);
        
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        
  
       
       String month="Nov";
       String year="2018";
       String day="22";
        driver.findElement(By.id("txtDob")).click();
        
        
       Select Month=new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")));
       Month.selectByVisibleText(month);
       
       Select Year=new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")));
       Year.selectByVisibleText(year);
       
      	
     //Select Date=new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[2]/a")));
     //Date.selectByVisibleText(day);
      
       driver.findElement(By.linkText(day)).click();
      	WebElement Mobile_Number=driver.findElement(By.id("mobileNo"));
     Mobile_Number.sendKeys("9874612300");
      	
      	sel=new Select(driver.findElement(By.id("nationalityId")));
      	sel.selectByIndex(0);
      	
      WebElement City=driver.findElement(By.id("city"));
      	City.sendKeys("Hyderabad");
      	
      	sel=new Select(driver.findElement(By.id("countryCode")));
      	sel.selectByIndex(0);
      	
      	
      	WebElement State=driver.findElement(By.id("stateName"));
      	
       State.sendKeys("Telangana");
       	
      	WebElement Postal_Code=driver.findElement(By.id("zipCode"));
      	Postal_Code.sendKeys("450123");
      	
      	sel=new Select(driver.findElement(By.id("proofTypeId")));
      	sel.selectByIndex(2);
      	
      	WebElement ID_Card_Number=driver.findElement(By.id("idNumber"));
      	ID_Card_Number.sendKeys("78945");
      	
      	WebElement Issuing_Authority=driver.findElement(By.id("idNumber"));
      	sel.selectByIndex(2);
      	
    	WebElement Submit_Button=driver.findElement(By.name("SaveBtn"));
    	Submit_Button.click();
    	
      }
  

  
  

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
