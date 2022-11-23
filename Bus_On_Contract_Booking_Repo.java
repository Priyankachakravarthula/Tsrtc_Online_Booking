package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bus_On_Contract_Booking_Repo 

{
	
static WebElement element;
	
	public static WebElement  From_Location(WebDriver driver)
	
	{
		element=driver.findElement(By.id("origin-input"));
		return element;
		
	}

public static WebElement  To_Location(WebDriver driver)
	
	{
		element=driver.findElement(By.id("destination-input"));
		return element;
		
	}
public static WebElement  startJourneydate_txt(WebDriver driver)

{
	element=driver.findElement(By.id("startTxtJourneyDate"));
	return element;
	
}
public static WebElement  Departure_Date(WebDriver driver,String dd)

{
	element=driver.findElement(By.linkText(dd));
	return element;
	
}
public static WebElement  Departure_Time(WebDriver driver)

{
	element=driver.findElement(By.id("startTime"));
	return element;
	
}
public static WebElement  endjourneydate_txt(WebDriver driver)

{
	element=driver.findElement(By.id("endTxtJourneyDate"));
	return element;
	
}
public static WebElement   Arrival_Date(WebDriver driver,String ad)

{
	element=driver.findElement(By.linkText(ad));
	return element;
	
}
public static WebElement  Arrival_Time(WebDriver driver)

{
	element=driver.findElement(By.id("endTime"));
	return element;
	
}
public static WebElement  Return_Route_Course(WebDriver driver)

{
	element=driver.findElement(By.id("returnStopOversdiv"));
	return element;
	
}
public static WebElement Continue_button(WebDriver driver)

{
	element=driver.findElement(By.id("searchBtn"));
	return element;
	
}


}
