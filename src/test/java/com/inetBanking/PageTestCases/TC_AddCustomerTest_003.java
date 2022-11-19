package com.inetBanking.PageTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.AddCustomerPage;
import com.inetBanking.PageObjects.LoginPage;

import net.bytebuddy.utility.RandomString;

public class TC_AddCustomerTest_003 extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		 Thread.sleep(3000);
		 AddCustomerPage addcust=new AddCustomerPage(driver);
		 addcust.clickAddNewCustomer();
		 addcust.custname("veereshak");
		 addcust.custgender("male");
		 addcust.custdob("03", "21", "97");
		 Thread.sleep(3000);
		 addcust.custadress("India");
		 addcust.custcity("sandur");
		 addcust.custstate("Karnataka");
		 addcust.custpinno("583118");
		 addcust.custtelephoneno("7749016519");
		// email=randomestring()+"@gmail.com";
		 addcust.custemailid("v@gmail.com");
		 addcust.custpassword("vkzoomin");
		 addcust.custsubmit();
		 Thread.sleep(3000);
		 
		boolean res= driver.getTitle().equals("Guru99 Bank Customer Registration Page");
		 if(res==true)
		 {
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 captureScreen(driver,"addNewCustomer");
			 Assert.assertTrue(false);
		 }
}
}