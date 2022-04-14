package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1. By Locators or Object Repository
	
	private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.xpath("//*[@id=\"SubmitLogin\"]/span");
    private By forgetPwdLink = By.linkText("Forgot your password?");

    
    //2. Contructor of the page class
    
    public LoginPage(WebDriver driver) {
    
    	this.driver=driver;
    }
    
    //3. Page actions: Features(behaviour) of the page in the form of methods:
    
    public String getLoginPageTitle() {
    	
    	return driver.getTitle();
    }
    
    public boolean isForgotPwdLinkExist() {
    	
    	return driver.findElement(forgetPwdLink).isDisplayed();
    }
    
    public void enterUserName(String username) {
    	
    	driver.findElement(emailId).sendKeys(username);
    	
    }
    public void enterPassword(String pwd) {
    	
    	driver.findElement(password).sendKeys(pwd);
    }
    
    public void clickOnLogin() {
    	driver.findElement(signInButton).click();
    }
    
    public AccountPage doLogin(String un, String pwd) {
    	
    	driver.findElement(emailId).sendKeys(un);
    	
    	driver.findElement(password).sendKeys(pwd);
    	driver.findElement(signInButton).click();
    	
    	return new AccountPage(driver);
    	
    	
    }
    
}