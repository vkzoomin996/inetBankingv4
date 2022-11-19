package com.inetBanking.PageTestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.Utilites.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd ) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
	//	logger.info("user name is provided");
		lp.setPassword(pwd);
		//logger.info("password is provided");
		Thread.sleep(3000);
		
		lp.clickSubmit();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			//logger.warn("login failed");
		}
		else {
			Assert.assertTrue(true);
			//logger.info("login is passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
			
			
		}
		
		
	}
	
	
	public boolean isAlertPresent()//user defined method created to check alert is present or not 
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
		
	}
		@DataProvider(name="LoginData") 
		String[][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/PageTestData/LoginData.xlsx";
			int rownum=XLUtils.getRowCount(path, "sheet1");
			int colcount=XLUtils.getCellCount(path, "sheet1", 1);
			
			String logindata[][]=new String[rownum][colcount];
					
		
		for(int i=1; i<rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				 logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);//1  0
			}
		}
		return logindata;
		
}
}
