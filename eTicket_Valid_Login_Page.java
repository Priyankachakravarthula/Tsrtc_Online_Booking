package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.eTicket_Invalid_Login_Repo;
import repository.eTicket_Valid_Login_Repo;

public class eTicket_Valid_Login_Page 
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
  public void eTicket_Valid_Login_Page() throws IOException, InterruptedException 
  {
	  //For referring the file we want to open
      File f=new File("Data/Tsrtc.xlsx");
      
      //For opening the file in read mode
      FileInputStream fis=new FileInputStream(f);
      
      System.out.println("File opened successfully");
      
      XSSFWorkbook w=new XSSFWorkbook(fis);
      
      //For referring the sheet we want to read
      XSSFSheet s=w.getSheet("Tsrtc_eTicket_Valid_Login");		        
      
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
      
	  eTicket_Valid_Login_Repo.username(driver).sendKeys(un);
	  eTicket_Valid_Login_Repo.password(driver).sendKeys(pwd);
	 
	  eTicket_Valid_Login_Repo.login(driver).click();
	  
	  
	   String fp=s.getRow(i).getCell(2).toString();
	   String tp=s.getRow(i).getCell(3).toString();	  
	   String dd=s.getRow(i).getCell(4).toString();
	   String dm=s.getRow(i).getCell(5).toString();
	   String dy=s.getRow(i).getCell(6).toString();
	   String rd=s.getRow(i).getCell(7).toString();
	   String rm=s.getRow(i).getCell(8).toString();
	   String ry=s.getRow(i).getCell(9).toString();
	   
	   
	   eTicket_Valid_Login_Repo.From_Place(driver).sendKeys(fp);

       eTicket_Valid_Login_Repo.From_Place(driver).sendKeys(Keys.ARROW_DOWN);
       
       eTicket_Valid_Login_Repo.From_Place(driver).sendKeys(Keys.ENTER);
       
	   eTicket_Valid_Login_Repo.To_Place(driver).sendKeys(tp);
	  
	 eTicket_Valid_Login_Repo.To_Place(driver).sendKeys(Keys.ARROW_DOWN);
	  
	  eTicket_Valid_Login_Repo.To_Place(driver).sendKeys(Keys.ENTER);
	  
	    eTicket_Valid_Login_Repo.Journey_date_txt(driver).click();
		eTicket_Valid_Login_Repo.depart_on_date(driver,dd).click();
		eTicket_Valid_Login_Repo.Return_Journeydate_txt(driver).click();
		eTicket_Valid_Login_Repo.return_on_date(driver, rd).click();
		//eTicket_Valid_Login_Repo.Submit_button(driver).click();
		//driver.navigate().back();
		//eTicket_Valid_Login_Repo.New_Booking(driver).click();
		
		System.out.println(fp+" "+tp+"  "+dd+"  "+dm+"  "+dy+"  "+rd+"  "+rm+"  "+ry);
		
		
  }
  }
 
  
 

  @AfterTest
  public void afterTest() {
  }

}
