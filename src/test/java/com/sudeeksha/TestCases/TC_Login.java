package com.sudeeksha.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sudeeksha.Pageobjects.Loginpage;

import junit.framework.Assert;

public class TC_Login extends BaseClass {
	
	@Test
	public void LoginTest() throws IOException 
	{
		Loginpage log = new Loginpage(driver);
		log.setUsername(username);
		logger.info("username entered");
		log.setPassword(password);
		logger.info("password entered");
		log.btnclick();
		
		//Thread.sleep(5000);
		
		//Thread.sleep(5000);
		
		//Thread.sleep(5000);
		//lp.btnclick();
		//Thread.sleep(5000);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePageppppppp"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else
		{ 
			addscreenCapture(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("test case faild");
			
		}
		
		
		
	}

}
