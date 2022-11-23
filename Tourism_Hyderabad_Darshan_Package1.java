package testcases;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.Tourism_Hyderabad_Darshan_Package1_Repo;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Tourism_Hyderabad_Darshan_Package1 
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
  public void Tourism_Hyderabad_Darshan_Package1 () throws IOException, InterruptedException 
  {
	       //For referring the file we want to open
			File f=new File("Data/Tsrtc.xlsx");

			//For opening the file in read mode
			FileInputStream fis=new FileInputStream(f);

			XSSFWorkbook w=new XSSFWorkbook(fis);

			//For referring the sheet we want to read
			XSSFSheet s=w.getSheet("Tourism_HYDERABAD_DARSHAN_PG_1");		        

			int rowsize=s.getLastRowNum();
			System.out.println("No. of rows are:" +rowsize);

			System.out.println("File opened successfully");
			 driver.get("https://www.tsrtconline.in/oprs-web/services/packagetours.do");
			 
			 //click on the book now button
			 driver.findElement(By.xpath("//*[@id=\"pkg-bookingMyList\"]/div/div/div[2]/div[2]/span/input")).click();
			 
			
			 Thread.sleep(4000);
		      
			  for(int i=1; i<=rowsize; i++)
		      {
		     
		     String fp=s.getRow(i).getCell(0).toString();
		     String tp=s.getRow(i).getCell(1).toString();
		     String dd=s.getRow(i).getCell(2).toString();
			 String dm=s.getRow(i).getCell(3).toString();
			 String dy=s.getRow(i).getCell(4).toString();
			 String rd=s.getRow(i).getCell(5).toString();
			 String rm=s.getRow(i).getCell(6).toString();
			 String ry=s.getRow(i).getCell(7).toString();

		     
	       // Tourism_Hyderabad_Darshan_Package1_Repo.From_Place(driver, fp).sendKeys(fp);
	        Thread.sleep(4000);
	        Tourism_Hyderabad_Darshan_Package1_Repo.From_Place(driver, fp).sendKeys(Keys.ARROW_DOWN);
	        Tourism_Hyderabad_Darshan_Package1_Repo.From_Place(driver, fp).sendKeys(Keys.ENTER);
	        
	        Thread.sleep(4000);
	        //Tourism_Hyderabad_Darshan_Package1_Repo.To_Place(driver, tp).sendKeys(tp);
	        Tourism_Hyderabad_Darshan_Package1_Repo.To_Place(driver, tp).sendKeys(Keys.ARROW_DOWN);
	        Tourism_Hyderabad_Darshan_Package1_Repo.To_Place(driver, tp).sendKeys(Keys.ARROW_DOWN);
	        Tourism_Hyderabad_Darshan_Package1_Repo.To_Place(driver, tp).sendKeys(Keys.ARROW_DOWN);
	        Tourism_Hyderabad_Darshan_Package1_Repo.To_Place(driver, tp).sendKeys(Keys.ENTER);
	        
	        Tourism_Hyderabad_Darshan_Package1_Repo.Depart_on_date_Txt(driver).click();
	        Tourism_Hyderabad_Darshan_Package1_Repo.Depart_on_date(driver, dd).click();
	        Tourism_Hyderabad_Darshan_Package1_Repo.Return_on_dateTxt(driver).click();
	        Tourism_Hyderabad_Darshan_Package1_Repo.Return_on_date(driver, rd).click();
	        Tourism_Hyderabad_Darshan_Package1_Repo.Search_button(driver).click();
	       // Tourism_Hyderabad_Darshan_Package1_Repo.From_Place(driver, fp).clear();
	       // Tourism_Hyderabad_Darshan_Package1_Repo.To_Place(driver, tp).clear();
	      
	    	System.out.println(fp+"    "+tp+" "+dd+"  "+dm+"  "+dy+"  "+rd+"  "+rm+"  "+ry);
	        
	        

		
	  
  }
  }
 

  @AfterTest
  public void afterTest() {
  }

}
