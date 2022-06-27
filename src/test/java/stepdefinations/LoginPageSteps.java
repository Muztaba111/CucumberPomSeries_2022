package stepdefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSteps {
		
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
				
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) throws Exception {
	  
		loginPage.enterUserName(username);
		
	}
	@Then("user click on continue with email button")
	public void user_click_on_continue_with_email_button() throws Exception  {
	  
		loginPage.clickOnContinueWithEmailButton();
	}
	
	

	@And("user enters passwprd {string}")
	public void user_enters_passwprd(String password) {
	    
		loginPage.enterPassword(password);
	}
	@Then("user click on login button")
	public void user_click_on_login_button() throws Exception {
		loginPage.clickOnLogin();
	}

	@Then("user click on the products link")
	public void user_click_on_the_products_link() throws Exception {
		loginPage.clickOnProductLink();
	}

	@Then("user click on Add product button")
	public void user_click_on_Add_product_button() throws Exception {
		loginPage.clickOnAddProductButton();
	}
	@And("user enter title {string}")
	public void user_enter_title(String titleName) throws Exception {
	  
		loginPage.enterTitle(titleName);
	}
	
	@And("user enter product type {string}")
	public void user_enter_product_type(String productnName) {
	  
		loginPage.productType(productnName);
	}
	@Then("click on Save button")
	public void click_on_Save_button() throws Exception {
		loginPage.clickSaveButton();
	}
}
