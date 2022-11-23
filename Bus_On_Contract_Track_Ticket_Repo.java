package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bus_On_Contract_Track_Ticket_Repo 
{
	static WebElement element;
	
	public static WebElement Ticket_NumberTxt(WebDriver driver,String tn)
	{
		element=driver.findElement(By.id("id"));
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

}
