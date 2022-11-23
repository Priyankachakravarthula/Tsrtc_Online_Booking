package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ATB_LoginGuide_Repo
{
	static WebElement element;
	
	public static WebElement Login_Guide_button(WebDriver driver)
	{
		element=driver.findElement(By.linkText("Login Guide"));
		return element;
	}

	public static WebElement Back_button(WebDriver driver)
	{
		element=driver.findElement(By.name("resetBtn"));
		return element;
	}
}
