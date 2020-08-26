package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage {
	
	public WebDriver driver ;
	
	private By email_id= By.xpath("//input[@id='user_email']");
	private By password= By.xpath("//input[@id='user_password']");
	private By log_in=By.xpath("//input[@name='commit']");
	
	public loginpage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement email_id()
	{
		return driver.findElement(email_id);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement getlog_in()
	{
		return driver.findElement(log_in);
	}

}
