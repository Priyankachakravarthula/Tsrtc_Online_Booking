package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page_Repo 
{
	static WebElement element;
	
	public static WebElement From_City(WebDriver driver,String fc)
	{
		element=driver.findElement(By.id("fromPlaceName"));
		return element;
	}
	
	public static WebElement To_City(WebDriver driver,String tc)
	{
		element=driver.findElement(By.id("toPlaceName"));
		return element;
	}
	public static WebElement Depart_On_DateTxt(WebDriver driver)
	{
		element=driver.findElement(By.id("txtJourneyDate"));
		return element;
	}
	public static WebElement Depart_On_Date(WebDriver driver,String dd)
	{
		element=driver.findElement(By.linkText(dd));
		return element;
	}
	public static WebElement  Return_On_DateTxt(WebDriver driver)
	{
		element=driver.findElement(By.id("txtReturnJourneyDate"));
		return element;
	}
	public static WebElement  Return_On_Date(WebDriver driver,String rd)
	{
		element=driver.findElement(By.linkText(rd));
		return element;
	}
	public static WebElement  Search_Button(WebDriver driver)
	{
		element=driver.findElement(By.id("searchBtn"));
		return element;
	}
	
	

}
