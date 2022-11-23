package testNG_Registration_Page;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DataDriven_Tsrtc_Registration_Page

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
	public void  DataDriven_Tsrtc_Registration_Page() throws InterruptedException, IOException

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

		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


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


			System.out.println(ln + " " +fn+" " + e +" " +g+" " +day+" " +mon+" " +yr+" "+mobile_no+" " 
					+na+" " + c+" " +con+ " " + st+" " +pc+" " +idt +" "+idn + " " +ia);

			WebElement Login_Name=driver.findElement(By.id("loginName"));
			Login_Name.sendKeys(ln);

			WebElement Full_Name=driver.findElement(By.id("fullName"));
			Full_Name.sendKeys(fn);

			WebElement Email=driver.findElement(By.id("email"));
			Email.sendKeys(e);

			sel=new Select(driver.findElement(By.id("genderId")));
			sel.selectByIndex(1);

			Thread.sleep(4000);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			WebDriverManager.chromedriver().browserVersion("106.0.5249.91 ").setup();

			driver.findElement(By.id("txtDob")).click();


			Select Month=new Select(driver.findElement(By.className("ui-datepicker-month")));
			Month.selectByVisibleText(mon);

			Select Year=new Select(driver.findElement(By.className("ui-datepicker-year")));
			Year.selectByVisibleText(yr);

			driver.findElement(By.linkText(day)).click();

			// WebElement Date_of_Birth=driver.findElement(By.id("txtDob"));
			//Date_of_Birth.sendKeys(dob);

			WebElement Mobile_Number=driver.findElement(By.id("mobileNo"));
			Mobile_Number.sendKeys(mobile_no);


			sel=new Select(driver.findElement(By.id("nationalityId")));
			sel.selectByIndex(0);

			WebElement City=driver.findElement(By.id("city"));
			City.sendKeys(c);

			sel=new Select(driver.findElement(By.id("countryCode")));
			sel.selectByIndex(0);


			WebElement State=driver.findElement(By.id("stateName"));

			State.sendKeys(st);

			WebElement Postal_Code=driver.findElement(By.id("zipCode"));
			Postal_Code.sendKeys(pc);

			sel=new Select(driver.findElement(By.id("proofTypeId")));
			sel.selectByIndex(2);

			WebElement ID_Card_Number=driver.findElement(By.id("idNumber"));
			ID_Card_Number.sendKeys(idn);
			
			//Issuing Authority

			WebElement Issing_Authority=driver.findElement(By.id("issueAuthority"));
			Issing_Authority.sendKeys(ia);

			//WebElement Submit_Button=driver.findElement(By.name("SaveBtn"));
			//Submit_Button.click();

		    driver.navigate().refresh();

		}
		
	}



	@AfterTest
	public void afterTest() 
	{
		driver.close();
	}
}


