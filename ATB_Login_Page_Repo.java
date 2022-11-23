package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ATB_Login_Page_Repo 
{
static WebElement element;
	
	public static WebElement  Username(WebDriver driver)
	
	{
		element=driver.findElement(By.name("userName"));
		return element;
		
	}
	
public static WebElement Password(WebDriver driver)
	
	{
		element=driver.findElement(By.name("password"));
		return element;
		
	}

}
