package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Enquiry_Page_Transaction_Status_Repo 
{
	static WebElement element;
	
	public static WebElement Ob_Reference_NumberTxt(WebDriver driver, String ob_Ref_Nm)
	{
		element=driver.findElement(By.id("bankRefNo"));
		return element;
	}
	
	public static WebElement Submit_Button(WebDriver driver)
	{
		element=driver.findElement(By.id("searchBtn"));
		return element;
	}


}
