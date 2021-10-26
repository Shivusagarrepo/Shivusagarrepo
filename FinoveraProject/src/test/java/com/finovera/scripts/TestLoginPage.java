package com.finovera.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.finovera.generics.BaseTest;
import com.finovera.pages.EnterTimeTrackPage;
import com.finovera.pages.LoginPage;

public class TestLoginPage extends BaseTest
{
	@Test
	public void test_ValidLoginPage() throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.Login();
		Thread.sleep(1000);
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.verifyETP(driver, "actiTIME - Enter Time-Track");
		etp.clickOnLogout();
	}
	
	@Test(dataProvider = "testWithInvalidLoginPage")
	public void test_InvalidLoginPage(String un, String pw) throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.Login(un, pw);
		Thread.sleep(1000);
		lp.verifyErrMsg();
	}
	
	@DataProvider
	public Object[][] testWithInvalidLoginPage() 
	{
		Object[][] s = new Object[3][2];
		
		s[0][0]="123";
		s[0][1]="234";
		
		s[1][0]="ssjsjs";
		s[1][1]="132ed";
		
		s[2][0]="#^%&U";
		s[2][1]="asddfvdfv";
		
		return s;
	}
}
