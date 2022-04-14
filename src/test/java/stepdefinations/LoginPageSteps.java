package stepdefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSteps {
	
	private static String title ;
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		 title = loginPage.getLoginPageTitle();
		System.out.println("Page title is :" +title);
	   
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is :" +title);
		Assert.assertTrue(title.contains(expectedTitleName));
	   
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	    
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	  
		loginPage.enterUserName(username);
	}

	@When("user enters passwprd {string}")
	public void user_enters_passwprd(String password) {
	    
		loginPage.enterPassword(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.clickOnLogin();
	}



}
