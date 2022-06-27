package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	

	
	private By emailId = By.xpath("//*[@id=\"account_email\"]");
	private By continueWithEmailButton = By.xpath("//*[@id=\"body-content\"]/div[2]/div/div[2]/div/div/div[2]/div/form/button");
    private By password = By.xpath("//*[@id=\"account_password\"]");
    private By signInButton = By.xpath("//*[@id=\"login_form\"]/div[2]/ul/button");
    private By productLink = By.xpath("//*[@id=\"AppFrameNav\"]/nav/div[2]/div[2]/ul/li[3]/div[1]/a/span");
    private By addProducButton = By.xpath("//*[@id=\"AppFrameMain\"]/div/div/div[1]/div/div[2]/div[2]/a/span/span");
    private By title = By.xpath("//*[@id=\"PolarisTextField4\"]");
    private By discription = By.xpath("//*[@id=\"tinymce\"]");
    private By productType = By.xpath("//*[@id=\"PolarisTextField8\"]");
    private By saveButton = By.xpath("//*[@id=\"AppFrameMain\"]/div/div/div[2]/form/div/div[3]/div/div/div/button/span/span");
    

    
    
    
    public LoginPage(WebDriver driver) {
    
    	this.driver=driver;
    }
    
   
    
    public void enterUserName(String username) throws Exception {
    	
    	driver.findElement(emailId).sendKeys(username);
    	Thread.sleep(10000);
    }
   public void clickOnContinueWithEmailButton() throws Exception  {
    	
    	driver.findElement(continueWithEmailButton).click();
    	Thread.sleep(10000);
   }
    public void enterPassword(String pwd) {
    	
    	driver.findElement(password).sendKeys(pwd);
    }
    
    public void clickOnLogin() throws Exception {
    	driver.findElement(signInButton).click();
    	Thread.sleep(20000);
    }
    public void clickOnProductLink() throws Exception {
    	driver.findElement(productLink).click();
    	Thread.sleep(15000);

    }
    public void clickOnAddProductButton() throws Exception {
    	driver.findElement(addProducButton).click();
    	Thread.sleep(15000);
    }
  public void enterTitle(String titleName) {
    	
    	driver.findElement(title).sendKeys(titleName);
    }
 
  public void productType(String productnName) {
	  	
	  	driver.findElement(productType).sendKeys(productnName);
	  }
    
  public void clickSaveButton() throws Exception {
  	driver.findElement(saveButton).click();
  	Thread.sleep(20000);
  }
    
    
}