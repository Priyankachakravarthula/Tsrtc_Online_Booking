package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tourism_Karthika_Maas_Darshan2_Repo 
{
	static WebElement element;
	 
	public static WebElement From_Place(WebDriver driver)
	{
		element=driver.findElement(By.id("fromPlaceName"));
		return element;
	}
	
	public static WebElement To_Place(WebDriver driver)
	{
		element=driver.findElement(By.id("toPlaceName"));
		return element;
	}
	
	public static WebElement Depart_on_date_txt(WebDriver driver)
	{
		element=driver.findElement(By.id("txtJourneyDate"));
		return element;
	}
	
	public static WebElement Depart_on_date(WebDriver driver,String dd)
	{
		element=driver.findElement(By.linkText(dd));
		return element;
	}
	
	public static WebElement Retrn_on_date_txt(WebDriver driver)
	{
		element=driver.findElement(By.id("txtReturnJourneyDate"));
		return element;
	}
	
	public static WebElement Return_on_date(WebDriver driver,String rd)
	{
		element=driver.findElement(By.linkText(rd));
		return element;
	}
	
	public static WebElement search_button(WebDriver driver)
	{
		element=driver.findElement(By.id("searchBtn"));
		return element;
	}
	public static WebElement select_seats(WebDriver driver)
	{
		element=driver.findElement(By.id("SrvcSelectBtnForward0"));
		return element;
	}
	public static WebElement Boarding_Point(WebDriver driver)
	{
		element=driver.findElement(By.id("ForwardBoardId"));
		return element;
	}
	public static WebElement Dropping_Point(WebDriver driver)
	{
		element=driver.findElement(By.id("ForwardDroppingId"));
		return element;
	}
	public static WebElement Concession(WebDriver driver)
	{
		element=driver.findElement(By.id("concessionId"));
		return element;
	}
	public static WebElement show_layout_button(WebDriver driver)
	{
		element=driver.findElement(By.id("fwLtBtn"));
		return element;
	}
	public static WebElement Card_Number_Txt(WebDriver driver)
	{

         element=driver.findElement(By.id("cardNumber"));
		return element;
	}
	public static WebElement Booked_by_name(WebDriver driver)
	{

         element=driver.findElement(By.id("bookedByName"));
		return element;
	}
	public static WebElement Mobile_Number_Txt(WebDriver driver)
	{

         element=driver.findElement(By.id("mobileNo"));
		return element;
	}
	public static WebElement Email_Txt(WebDriver driver)
	{

         element=driver.findElement(By.id("email"));
		return element;
	}
	public static WebElement Gender(WebDriver driver)
	{

         element=driver.findElement(By.id("genderCodeIdForward0"));
		return element;
	}
	public static WebElement Age(WebDriver driver)
	{

         element=driver.findElement(By.id("passengerAgeForward0"));
		return element;
	}
	public static WebElement Book_Return_button(WebDriver driver)
	{

         element=driver.findElement(By.xpath("/html/body/div[4]/div/form/div/div[3]/div[3]/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td/div/input"));
		return element;
	}
	

}
