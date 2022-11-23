package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ATB_Forgot_Password_Repo 
{
	static WebElement element;
	
	public static WebElement Email(WebDriver driver)
	{
		element=driver.findElement(By.name("userName"));
		return element;
				
	}

	public static WebElement Submit_Button(WebDriver driver)
	{
		element=driver.findElement(By.name("submitBtn"));
		return element;
				
	}
	
	public static WebElement Back_Button(WebDriver driver)
	{
		element=driver.findElement(By.name("resetBtn"));
		return element;
				
	}
}
