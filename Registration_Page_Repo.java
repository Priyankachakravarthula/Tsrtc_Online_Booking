package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration_Page_Repo 
{
	static WebElement element;
	
	public static WebElement Login_Name(WebDriver driver)
	{
		element=driver.findElement(By.id("loginName"));
		return element;
	}
	
	public static WebElement Full_Name(WebDriver driver)
	{
		element=driver.findElement(By.id("fullName"));
		return element;
	}
	
	public static WebElement Email(WebDriver driver)
	{
		element=driver.findElement(By.id("email"));
		return element;
	}
	
	public static WebElement Gender(WebDriver driver)
	{
		element=driver.findElement(By.id("genderId"));
		return element;
	}
	
	public static WebElement date_of_birth_txt(WebDriver driver)
	{
		element=driver.findElement(By.id("txtDob"));
		return element;
	}
	
	public static WebElement Month(WebDriver driver)
	{
		element=driver.findElement(By.className("ui-datepicker-month"));
		return element;
	}
	
	public static WebElement Year(WebDriver driver)
	{
		element=driver.findElement(By.className("ui-datepicker-year"));
		return element;
	}
	
	public static WebElement day(WebDriver driver,String day)
	{
		element=driver.findElement(By.linkText(day));
		return element;
	}
	public static WebElement Mobile_Number(WebDriver driver)
	{
		element=driver.findElement(By.id("mobileNo"));
		return element;
	}
	public static WebElement Nationality_Id(WebDriver driver)
	{
		element=driver.findElement(By.id("nationalityId"));
		return element;
	}
	public static WebElement City(WebDriver driver)
	{
		element=driver.findElement(By.id("city"));
		return element;
	}
	public static WebElement Country(WebDriver driver)
	{
		element=driver.findElement(By.id("countryCode"));
		return element;
	}
	public static WebElement State(WebDriver driver)
	{
		element=driver.findElement(By.id("stateName"));
		return element;
	}
	public static WebElement Postal_Code(WebDriver driver)
	{
		element=driver.findElement(By.id("zipCode"));
		return element;
	}
	public static WebElement ProofTypeId(WebDriver driver)
	{
		element=driver.findElement(By.id("proofTypeId"));
		return element;
	}
	public static WebElement ID_Card_Number(WebDriver driver)
	{
		element=driver.findElement(By.id("idNumber"));
		return element;
	}
	public static WebElement Issuing_Authority(WebDriver driver)
	{
		element=driver.findElement(By.id("issueAuthority"));
		return element;
	}
	
	public static WebElement Submit_button(WebDriver driver)
	{
		element=driver.findElement(By.id("SaveBtn"));
		return element;
	}
	
	

}
