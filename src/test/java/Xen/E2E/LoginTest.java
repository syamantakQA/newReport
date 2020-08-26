package Xen.E2E;


import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Resources.base;
import pageObject.homepage;
import pageObject.loginpage;



public class LoginTest extends base {
	
	public static Logger log= LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeMethod
	public void setup () throws Exception
	{
		//navigating to homepage
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getdata")
	public void landingPage(String username, String password) throws Exception
	{
		
		homepage hm = new homepage(driver);
		
		//clicking on login button
		hm.login().click();
		
		//providing email id and password in login page
		
		loginpage ln = new loginpage(driver);
		ln.email_id().sendKeys(username);
		ln.password().sendKeys(password);
		ln.getlog_in().click();
		
		log.error("False error");
		log.debug("Test done with params");
		
		
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object [][] data= new Object [2][2];
		
		// 1st [] represent row and 2nd [] represent column.
		// no of row means how many times our test will run. 
		//1 means our test will run 2 times .
		//no of column means  our test will run with how many data set. 
		//1 means our test will run with 2 data set
		//array indexing start with 0.
		
		//executing tc with first set of data
		data[0][0]="abc@test.com";
		data[0][1]="password_09";
		
		
		//executing tc with second set of data
		data[1][0]="pqr@test.com";
		data[1][1]="password_10";
		
		
		return data;
		
	}
	
	@AfterMethod
	public void teardown () throws Exception
	{
		//closing the browser
		
		driver.close();
	}
	

}
