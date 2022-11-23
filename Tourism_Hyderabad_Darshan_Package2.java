package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.Enquiry_page_Transaction_Status_Mobile_Number_Repo;
import repository.Tourism_Hyderabad_Darshan_Package2_Repo;

public class Tourism_Hyderabad_Darshan_Package2 
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
  public void Tourism_Hyderabad_Darshan_Package2() throws IOException, InterruptedException 
  {
	//For referring the file we want to open
		File f=new File("Data/Tsrtc.xlsx");

		//For opening the file in read mode
		FileInputStream fis=new FileInputStream(f);

		XSSFWorkbook w=new XSSFWorkbook(fis);

		//For referring the sheet we want to read
		XSSFSheet s=w.getSheet("Tourism_HYDERABAD_DARSHAN_PG_2");		        

		int rowsize=s.getLastRowNum();
		System.out.println("No. of rows are:" +rowsize);

		System.out.println("File opened successfully");
		 driver.get("https://www.tsrtconline.in/oprs-web/services/packagetours.do");
		 
		 //click on the book now button
		 driver.findElement(By.xpath("/html/body/div[4]/div/form/div/div[2]/div/div/div[4]/div[2]/span/input")).click();
		
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
		 
		 Tourism_Hyderabad_Darshan_Package2_Repo.From_Place(driver, fp).sendKeys(Keys.ARROW_DOWN);
		 Tourism_Hyderabad_Darshan_Package2_Repo.From_Place(driver, fp).sendKeys(Keys.ENTER);
		 Thread.sleep(4000);
		 Tourism_Hyderabad_Darshan_Package2_Repo.To_Place(driver, tp).sendKeys(Keys.ARROW_DOWN);
		 Tourism_Hyderabad_Darshan_Package2_Repo.To_Place(driver, tp).sendKeys(Keys.ARROW_DOWN);
		 Tourism_Hyderabad_Darshan_Package2_Repo.To_Place(driver, tp).sendKeys(Keys.ARROW_DOWN);
		 Tourism_Hyderabad_Darshan_Package2_Repo.To_Place(driver, tp).sendKeys(Keys.ARROW_DOWN);
		 Tourism_Hyderabad_Darshan_Package2_Repo.To_Place(driver, tp).sendKeys(Keys.ENTER);
		 Thread.sleep(4000);
		 Tourism_Hyderabad_Darshan_Package2_Repo.Depart_on_date_Txt(driver).click();
		 
		 Tourism_Hyderabad_Darshan_Package2_Repo.Depart_on_date(driver, dd).click();
		 Tourism_Hyderabad_Darshan_Package2_Repo.Return_on_dateTxt(driver).click();
		 Tourism_Hyderabad_Darshan_Package2_Repo.Return_on_date(driver, rd).click();
		 
		 Tourism_Hyderabad_Darshan_Package2_Repo.Search_button(driver).click();
		 
		 System.out.println(fp+"    "+tp+" "+dd+"  "+dm+"  "+dy+"  "+rd+"  "+rm+"  "+ry);
		 
		 
		 
 
  }
  }
  @AfterTest
  public void afterTest() 
  {
	  
  }

}
