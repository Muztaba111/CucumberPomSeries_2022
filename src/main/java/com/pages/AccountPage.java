package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	private WebDriver driver;
	
	private By accountSections = By.cssSelector("div#center_column span");
	
	public AccountPage(WebDriver driver) {
		
		this.driver=driver;
	}
  
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountSectionsCount() {
		
		return	driver.findElements(accountSections).size();

		 
	}
	
	public List<String>  getAccountSectionList() {
		
		List<String> accounntList = new ArrayList<>();
		
		List<WebElement> accountHeaderList = driver.findElements(accountSections);
		for(WebElement e : accountHeaderList) {
			
			String text = e.getText();
			accounntList.add(text);	
		}
		return accounntList;
	}
}
