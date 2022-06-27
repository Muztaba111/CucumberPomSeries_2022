package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("brower value is : " +browser);
		
		if (browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
			tlDriver.set(new ChromeDriver());
		}
		
		else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
			tlDriver.set(new FirefoxDriver());		
	}
		else {
			System.out.println("Please pass the correct browser" +browser);
		}
		
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
}
	
    
	
	  public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	}