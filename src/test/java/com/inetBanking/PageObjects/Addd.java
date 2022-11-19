package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Addd {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Veeresha K\\Downloads\\Eclipse 2022\\inetBankingv4\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/v4/manager/CustomerRegMsg.php?cid=35920");
		System.out.println(driver.getPageSource());
		
	}

}
