package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepage {
	
	public WebDriver driver;
	
	By login= By.xpath("//span[contains(text(),'Login')]");
	
	public homepage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement login()
	{
		return driver.findElement(login);
	}
	
	By txt_val=By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	public WebElement gettxt_val()
	{
		return driver.findElement(txt_val);
	}

}
