package com.finovera.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage 
{
	@FindBy(xpath="//input[@type='email']")
	private WebElement unTb;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pwTb;
	
	@FindBy(xpath="//button[.='Login']")
	private WebElement lgnBTN;	
	
	@FindBy(xpath="//kendo-formerror[.='Sign In Failed']")
	private WebElement errorMsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Login()
	{
		unTb.sendKeys("snehasish@fiport.com");
		pwTb.sendKeys("Fiport!16");
		lgnBTN.click();
	}
	
	public void Login(String un, String pw) 
	{
		unTb.sendKeys(un);
		pwTb.sendKeys(pw);
		lgnBTN.click();

	}
	
	public void setUsername(String un) 
	{
		unTb.sendKeys(un);

	}
	
	public void setPassword(String pw) 
	{
		unTb.sendKeys(pw);

	}
	
	public void clickOnLoginBTN() 
	{
		lgnBTN.click();

	}
	
	public void verifyErrMsg() 
	{
		Assert.assertTrue(errorMsg.isDisplayed());
		Reporter.log("The Error Msg is displayed:----->"+errorMsg.getText() , true);
	}

}
