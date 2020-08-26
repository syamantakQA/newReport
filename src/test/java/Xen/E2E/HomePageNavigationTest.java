package Xen.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;

import pageObject.homepage;
import pageObject.loginpage;



public class HomePageNavigationTest extends base {
	
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	public WebDriver driver;
	
	@BeforeTest
	public void setup () throws Exception
	{
		//navigating to homepage
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("setup method executed successfully");
	}
	@Test
	public void txtvalidation() throws Exception
	{
		
		homepage hm = new homepage(driver);
		//asserting whether expected text is present or not in homepage
		String returned_txt=hm.gettxt_val().getText();
		Assert.assertEquals(returned_txt, "FEATURED COURSES123");
		log.debug("Text successfully validated");
			
	}
	
	@AfterTest
	public void teardown () throws Exception
	{
		//closing the browser
		
		driver.close();
	}
	
}
