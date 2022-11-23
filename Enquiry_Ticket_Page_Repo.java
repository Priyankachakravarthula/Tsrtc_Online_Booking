package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Enquiry_Ticket_Page_Repo 
{
	static WebElement element;
	
	public static WebElement Ticket_Numbertxt(WebDriver driver,String tn)
	{
		element=driver.findElement(By.id("id"));
		return element;
	}

	public static WebElement Mobile_Numbertxt(WebDriver driver,String mn)
	{
		element=driver.findElement(By.id("mobileNo"));
		return element;
	}
	public static WebElement Submit_Button(WebDriver driver)
	{
		element=driver.findElement(By.id("searchBtn"));
		return element;
	}
}
