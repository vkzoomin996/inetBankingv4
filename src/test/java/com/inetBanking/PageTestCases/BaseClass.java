package com.inetBanking.PageTestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.inetBanking.Utilites.ReadConfig;

public class BaseClass {
	ReadConfig readconfig =new ReadConfig();
	public String baseURL= readconfig.getApplicationURL();
	public String username= readconfig.getUsername();
	public String password= readconfig.getPassword();
	static WebDriver driver;
	//public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup( String br)
	{
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Veeresha K\\Downloads\\Eclipse 2022\\inetBankingv4\\Drivers\\chromedriver.exe"     );
	driver = new ChromeDriver();
	//logger  = logger.getLogger("ebanking");
//	PropertyConfigurator.configure(" log4j.properies");
	}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Veeresha K\\Downloads\\Eclipse 2022\\inetBankingv4\\Drivers\\geckodriver.exe"     );
			driver = new FirefoxDriver();
		}
		else  if(br.equals("edge")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Veeresha K\\Downloads\\Eclipse 2022\\inetBankingv4\\Drivers\\msedgedriver.exe"     );
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration .ofSeconds(10));
			driver.get("http://demo.guru99.com/v4/index.php");
		}
			
		
	@AfterClass
	public void teardown() {
		driver.quit();
	}
public void captureScreen(WebDriver driver , String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"/Screenshots/" +tname+".png");
	FileUtils.copyFile(source, target);
	System.out.println("screenshot taken");
	
}
	
	
	
	
	
	
	
	
	
}













