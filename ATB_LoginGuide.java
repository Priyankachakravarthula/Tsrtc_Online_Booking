package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.ATB_LoginGuide_Repo;

public class ATB_LoginGuide 
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
  public void ATB_LoginGuide () throws InterruptedException 
  {
	  driver.get("https://www.tsrtconline.in/oprs-web/login/show.do");
	  driver.findElement(By.linkText("ATB/OPR Login")).click();
	  
	  ATB_LoginGuide_Repo.Login_Guide_button(driver).click();
	  
	  Thread.sleep(4000);
	  ATB_LoginGuide_Repo.Back_button(driver).click();
  }
  

  @AfterTest
  public void afterTest() {
  }

}
