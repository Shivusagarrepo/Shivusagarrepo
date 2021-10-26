package com.finovera.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest 
{

	private static final TimeUnit Seconds = null;

	static 
	{
		System.setProperty("webdriver.chrome.driver.exe", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver.exe", "./driver/geckodriver.exe");
		
	}
	
	public static WebDriver driver;
	
	@Parameters("sBrowser")
	@BeforeClass
	public void openBrowser(String sBrowser)
	{
		if(sBrowser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(sBrowser.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(sBrowser.equals("ie"))
		{
			driver= new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void openApp() 
	{
		driver.get("https://app-sandbox.finovera.com");
	}
}
