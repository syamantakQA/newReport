package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public WebDriver driver ;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser");
		//String browserName=prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
		{   
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
			//System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Misc\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		else
		
		{
			driver= new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getscreenshot(String testcasename,WebDriver driver, String dt) throws Exception
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationfile=System.getProperty("user.dir")+"\\reports\\"+testcasename+dt+".png";
		FileUtils.copyFile(source, new File(destinationfile));
		return destinationfile;
	}
	
	

}
