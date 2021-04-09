package com.sudeeksha.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how =How.NAME, using="uid")
	@CacheLookup
	WebElement uname;
	
	@FindBy(how =How.NAME,using="password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(how =How.NAME, using="btnLogin")
	@CacheLookup
	WebElement login;
	
	public void setUsername(String username)
	{
		uname.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		pwd.sendKeys(password);
	}
	
	public void btnclick()
	{
		login.click();
	}

	
	

}
