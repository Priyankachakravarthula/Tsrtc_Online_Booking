package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class eTicket_Valid_Login_Repo 
{
	
	static WebElement element;
	
	public static WebElement  username(WebDriver driver)
	
	{
		element=driver.findElement(By.id("userName"));
		return element;
		
	}
		
	public static WebElement  password(WebDriver driver)
	
	{
		element=driver.findElement(By.id("password"));
		return element;
		
	}

public static WebElement login(WebDriver driver)

{
	element=driver.findElement(By.id("submitBtn"));
	return element;
	
}
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

public static WebElement Journey_date_txt(WebDriver driver)

{
	element=driver.findElement(By.id("txtJourneyDate"));
	return element;
	
}


public static WebElement depart_on_date(WebDriver driver,String dd)

{
	element=driver.findElement(By.linkText(dd));
	return element;
	
}

public static WebElement depart_on_month(WebDriver driver,String dm)

{
	element=driver.findElement(By.linkText(dm));
	return element;
	
}

public static WebElement depart_on_year(WebDriver driver,String dy)

{
	element=driver.findElement(By.linkText(dy));
	return element;
	
}

public static WebElement Return_Journeydate_txt(WebDriver driver)

{
	element=driver.findElement(By.id("txtReturnJourneyDate"));
	return element;
	
}

public static WebElement return_on_date(WebDriver driver,String rd)

{
	element=driver.findElement(By.linkText(rd));
	return element;
	
}

public static WebElement Return_on_month(WebDriver driver,String rm)

{
	element=driver.findElement(By.linkText(rm));
	return element;
	
}

public static WebElement Return_on_year(WebDriver driver,String ry)

{
	element=driver.findElement(By.linkText(ry));
	return element;
	
}

public static WebElement Submit_button(WebDriver driver)

{
	element=driver.findElement(By.id("searchBtn"));
	return element;
	
}


public static WebElement New_Booking(WebDriver driver)

{
	element=driver.findElement(By.linkText(" New Booking"));
	return element;
	
}

}
