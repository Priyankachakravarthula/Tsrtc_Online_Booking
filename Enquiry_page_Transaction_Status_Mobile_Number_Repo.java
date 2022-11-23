package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Enquiry_page_Transaction_Status_Mobile_Number_Repo 
{
	static WebElement element;
	
	public static WebElement Mobile_Number_Txt(WebDriver driver)
	{
		element=driver.findElement(By.id("tranxMobileNo"));
		return element;
	}
	public static WebElement Transaction_date_Txt(WebDriver driver)
	{
		element=driver.findElement(By.id("tranxDate"));
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
	public static WebElement Submit_button(WebDriver driver)
	{
		element=driver.findElement(By.id("searchBtn"));
		return element;
	}

}
