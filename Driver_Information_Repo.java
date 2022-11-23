package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Driver_Information_Repo 
{
	static WebElement element;

	public static WebElement Service_NumberTxt(WebDriver driver,String sn)
	{
		element=driver.findElement(By.id("serviceCode"));
		return element;
	}
	
	public static WebElement Journey_DateTxt(WebDriver driver)
	{
		element=driver.findElement(By.id("txtJourneyDate"));
		return element;
	}
	
	public static WebElement Month(WebDriver driver)
	{
		element=driver.findElement(By.className("ui-datepicker-month"));
		return element;
	}
	
	public static WebElement year(WebDriver driver)
	{
		element=driver.findElement(By.className("ui-datepicker-year"));
		return element;
	}

	public static WebElement day(WebDriver driver,String day)
	{
		element=driver.findElement(By.linkText(day));
		return element;
	}
	
	public static WebElement Submit_Button(WebDriver driver)
	{
		element=driver.findElement(By.id("searchBtn"));
		return element;
	}
}