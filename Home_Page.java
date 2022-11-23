package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.Home_Page_Repo;

public class Home_Page
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
  public void  Home_Page() throws IOException, InterruptedException 
  {
	       //For referring the file we want to open
			File f=new File("Data/Tsrtc.xlsx");

			//For opening the file in read mode
			FileInputStream fis=new FileInputStream(f);

			XSSFWorkbook w=new XSSFWorkbook(fis);

			//For referring the sheet we want to read
			XSSFSheet s=w.getSheet("Home_Page");		        

			int rowsize=s.getLastRowNum();
			System.out.println("No. of rows are:" +rowsize);

			System.out.println("File opened successfully");
			
			Thread.sleep(4000);
			
			driver.get("https://www.tsrtconline.in/oprs-web/guest/home.do?h=1");
			
			
			 for(int i=1; i<=rowsize; i++)
		      {
		      	String fc=s.getRow(i).getCell(0).toString();
		      	String tc=s.getRow(i).getCell(1).toString();
		     	String dd=s.getRow(i).getCell(2).toString();
		    	String rd=s.getRow(i).getCell(5).toString();
		    	
		    	Home_Page_Repo.From_City(driver, fc).sendKeys(fc);
		    	Home_Page_Repo.From_City(driver, fc).sendKeys(Keys.ARROW_DOWN);
		    	Home_Page_Repo.From_City(driver, fc).sendKeys(Keys.ARROW_DOWN);
		    	Home_Page_Repo.From_City(driver, fc).sendKeys(Keys.ENTER);
		    	Home_Page_Repo.To_City(driver, tc).sendKeys(tc);
		    	Home_Page_Repo.To_City(driver, tc).sendKeys(Keys.ARROW_DOWN);
		    	Home_Page_Repo.To_City(driver, tc).sendKeys(Keys.ENTER);
		    	Home_Page_Repo.Depart_On_DateTxt(driver).click();
		    	Home_Page_Repo.Depart_On_Date(driver, dd).sendKeys(dd);
		    	Home_Page_Repo.Return_On_DateTxt(driver).click();
		    	Home_Page_Repo.Return_On_Date(driver, rd).sendKeys(rd);
		    	//Home_Page_Repo.Search_Button(driver).click();
		    	Home_Page_Repo.From_City(driver, fc).clear();
		    	Home_Page_Repo.To_City(driver, tc).clear();
		    	
		        System.out.println(fc+"  "+tc+"  "+dd+"  "+rd);
  }
  }

  @AfterTest
  public void afterTest() {
  }

}
