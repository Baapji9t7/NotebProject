package com.noteb.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
    public static WebDriver driver; 
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
	}
	
		@BeforeClass
		public void openBrowser() {
		driver = new ChromeDriver();
		Reporter.log("Browser Started",true);
	    driver.manage().window().maximize();
	    driver.get("https://www.noteb.com/");
	    Reporter.log("Entered the URL -'https://www.noteb.com/' ",true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    }
		
		@AfterClass
		public void closeBrowser() {
			Reporter.log("Browser closed",true);	
			driver.quit();
		}


}
