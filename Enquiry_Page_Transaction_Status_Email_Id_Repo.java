package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Enquiry_Page_Transaction_Status_Email_Id_Repo 
{
 static WebElement element;
 
 public static WebElement Email_Id(WebDriver driver)
 {
	 element=driver.findElement(By.id("email"));
	 return element;
 }
 
 public static WebElement Booked_date(WebDriver driver)
 {
	 element=driver.findElement(By.id("tranxDate1"));
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
 
 public static WebElement Day(WebDriver driver,String day)
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
