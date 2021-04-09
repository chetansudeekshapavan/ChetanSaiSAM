package com.sudeeksha.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.sudeeksha.TestUtilities.ReadConfig;

public class BaseClass {
	
	ReadConfig config=new ReadConfig();
	
	public String baseUrl=config.getAppurl();
	public String username=config.getUsername();
	public String password=config.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	
	
	
	//@Parameters("Browser")
	@BeforeClass
	public void setup()
	{
		//if(br.equals("chrome"))
		//{
			System.setProperty("webdriver.chrome.driver", config.getChromepath());
			driver=new ChromeDriver();
			
			logger=Logger.getLogger("chetanbanking");
			PropertyConfigurator.configure("log4j.properties");
		//}
		//else if(br.equals("firefox"))
		//{
		//System.setProperty("webdriver.gecko.driver", config.getFirefoxpath());
		//}
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void addscreenCapture(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File tgt=new File(System.getProperty("user.dir") + "/Screenshots/" + tname +  ".png");
		FileUtils.copyFile(src, tgt);
	}

}
