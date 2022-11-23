package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.Registration_Page_Repo;

public class Registration_Page 
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
  public void Registration_Page() throws IOException, InterruptedException
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
		for(int i=1; i<=rowsize; i++)
		{
			String ln=s.getRow(i).getCell(0).toString();
			String fn=s.getRow(i).getCell(1).toString();
			String e=s.getRow(i).getCell(2).toString();
			String g=s.getRow(i).getCell(3).toString();
			String day=s.getRow(i).getCell(4).toString();
			String mon=s.getRow(i).getCell(5).toString();
			String yr=s.getRow(i).getCell(6).toString();

			String mobile_no=s.getRow(i).getCell(7).toString();
			String na=s.getRow(i).getCell(8).toString();
			String c=s.getRow(i).getCell(9).toString();
			String con=s.getRow(i).getCell(10).toString();
			String st=s.getRow(i).getCell(11).toString();
			String pc=s.getRow(i).getCell(12).toString();
			String idt=s.getRow(i).getCell(13).toString();
			String idn=s.getRow(i).getCell(14).toString();
			String ia=s.getRow(i).getCell(15).toString();
			
			Registration_Page_Repo.Login_Name(driver).sendKeys(ln);
			Registration_Page_Repo.Full_Name(driver).sendKeys(ln);
			Registration_Page_Repo.Email(driver).sendKeys(e);
			Select GenderId=new Select(Registration_Page_Repo.Gender(driver));
			GenderId.selectByVisibleText(g);
			Registration_Page_Repo.date_of_birth_txt(driver).click();
			
			Select Month=new Select(Registration_Page_Repo.Month(driver));
			Month.selectByVisibleText(mon);
			Select Year=new Select(Registration_Page_Repo.Year(driver));
			Year.selectByVisibleText(yr);
			
			Registration_Page_Repo.day(driver, day).click();
			Registration_Page_Repo.Mobile_Number(driver).sendKeys(mobile_no);
			Select Nationality_Id=new Select(Registration_Page_Repo.Nationality_Id(driver));
			Nationality_Id.selectByIndex(0);
			Registration_Page_Repo.City(driver).sendKeys(c);
			Select Country=new Select(Registration_Page_Repo.Country(driver));
			Country.selectByIndex(0);
			Registration_Page_Repo.State(driver).sendKeys(st);
			Registration_Page_Repo.Postal_Code(driver).sendKeys(pc);
			Select ProofType_Id=new Select(Registration_Page_Repo.ProofTypeId(driver));
			ProofType_Id.selectByIndex(2);
			Registration_Page_Repo.ID_Card_Number(driver).sendKeys(idn);
			Registration_Page_Repo.Issuing_Authority(driver).sendKeys(ia);
			 //Registration_Page_Repo.Submit_button(driver).click();
			Registration_Page_Repo.Login_Name(driver).clear();
			Registration_Page_Repo.Full_Name(driver).clear();
			Registration_Page_Repo.Email(driver).clear();
			Registration_Page_Repo.Mobile_Number(driver).clear();
			Registration_Page_Repo.City(driver).clear();
			Registration_Page_Repo.State(driver).clear();
			Registration_Page_Repo.Postal_Code(driver).clear();
			Registration_Page_Repo.ID_Card_Number(driver).clear();
			Registration_Page_Repo.Issuing_Authority(driver).clear();
			Registration_Page_Repo.City(driver).clear();
			
			System.out.println(ln + " " +fn+" " + e +" " +g+" " +day+" " +mon+" " +yr+" "+mobile_no+" " 
					+na+" " + c+" " +con+ " " + st+" " +pc+" " +idt +" "+idn + " " +ia);
	  
  }
  }
  

  @AfterTest
  public void afterTest() {
  }

}
