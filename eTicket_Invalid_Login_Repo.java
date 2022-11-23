package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class eTicket_Invalid_Login_Repo

{
	static WebElement element;
	
	public static WebElement  username(WebDriver driver)
	
	{
		element=driver.findElement(By.id("userName"));
		return element;
		
	}

public static WebElement  password(WebDriver driver)
	
	{
		element=driver.findElement(By.id("password"));
		return element;
		
	}

public static WebElement login(WebDriver driver)

{
	element=driver.findElement(By.id("submitBtn"));
	return element;
	
}


}
