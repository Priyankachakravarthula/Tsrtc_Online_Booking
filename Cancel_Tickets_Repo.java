package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cancel_Tickets_Repo 
{
	static WebElement element;
	
	public static WebElement Ticket_NumberTxt(WebDriver driver,String tn)
	{
		element=driver.findElement(By.id("id"));
		return element;
		
	}
	
	public static WebElement UID_NumberTxt(WebDriver driver,String un)
	{
		element=driver.findElement(By.id("uidNumber"));
		return element;
		
	}

	public static WebElement Mobile_NumberTxt(WebDriver driver,String mn)
	{
		element=driver.findElement(By.id("mobileNo"));
		return element;
		
	}

	public static WebElement Search_Button(WebDriver driver)
	{
		element=driver.findElement(By.id("searchBtn"));
		return element;
		
	}

	public static WebElement Reset_Button(WebDriver driver)
	{
		element=driver.findElement(By.id("resetBtn"));
		return element;
		
	}


}
