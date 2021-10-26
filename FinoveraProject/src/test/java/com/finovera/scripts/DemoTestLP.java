package com.finovera.scripts;

import org.testng.annotations.Test;

import com.finovera.generics.BaseTest;
import com.finovera.pages.EnterTimeTrackPage;
import com.finovera.pages.LoginPage;

public class DemoTestLP extends BaseTest
{
	@Test(priority = 0)
	public static void validLoginPage() throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.Login();
		Thread.sleep(1000);
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.clickOnLogout();
	}
	
	@Test(priority = 1)
	public static void inValidLoginPage() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.Login("snehasish@fiport.com", "invalid");

	}
}
