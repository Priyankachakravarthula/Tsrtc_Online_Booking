package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Enquiry_Page_Service_Status_By_Ticket_Number_Repo 
{
	static WebElement element;
	
	public static WebElement Ticket_Number_Txt(WebDriver driver,String tn)
	{
		element=driver.findElement(By.id("id1"));
		return element;
	}
	
	public static WebElement Submit_button(WebDriver driver)
	{
		element=driver.findElement(By.id("searchBtn"));
		return element;
	}


}
