package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tourism_Hyderabad_Darshan_Package1_Repo
{
	static WebElement element;
	
	public static WebElement From_Place(WebDriver driver,String fp)
	{
		element=driver.findElement(By.id("fromPlaceName"));
		return element;
	}
	
	public static WebElement To_Place(WebDriver driver,String tp)
	{
		element=driver.findElement(By.id("toPlaceName"));
		return element;
	}
	
	public static WebElement Depart_on_date_Txt(WebDriver driver)
	{
		element=driver.findElement(By.id("txtJourneyDate"));
		return element;
	}
	
	public static WebElement Depart_on_date(WebDriver driver,String dd)
	{
		element=driver.findElement(By.linkText(dd));
		return element;
	}
	
	public static WebElement Return_on_dateTxt(WebDriver driver)
	{
		element=driver.findElement(By.id("txtReturnJourneyDate"));
		return element;
	}
	
	public static WebElement Return_on_date(WebDriver driver,String rd)
	{
		element=driver.findElement(By.linkText(rd));
		return element;
	}
	
	public static WebElement Search_button(WebDriver driver)
	{
		element=driver.findElement(By.id("searchBtn"));
		return element;
	}
	
	

}
