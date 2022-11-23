package testNG_ATB_Login;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Login_Guide 
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
  public void Login_Guide() throws InterruptedException
  {
	    driver.get("https://www.tsrtconline.in/oprs-web/login/show.do");
		driver.findElement(By.linkText("ATB/OPR Login")).click();
		
		Thread.sleep(4000);
		
		//click on login guide button
		
		driver.findElement(By.linkText("Login Guide")).click();
		
		//click on back button
		driver.findElement(By.name("resetBtn")).click();
  }
  

  @AfterTest
  public void afterTest() 
  {
  }

}
