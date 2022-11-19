package com.inetBanking.PageTestCases;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void loginTest() throws IOException {
	driver.get(baseURL);
	//logger.info("URL is opened");
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	//logger.info("entered username");

	lp.setPassword(password);
	//logger.info("entered password");

	lp.clickSubmit();
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
	//	logger.info("login test is passed");
	}
	else
	{
		captureScreen( driver , "loginTest");
		Assert.assertTrue(false);
		//logger.info("login test is failed");

	}
	
	
	}
	

}
