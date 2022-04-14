package stepdefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	
	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable dataTable) {
		
		List<Map<String, String>> credList = dataTable.asMaps();
		String userName = credList.get(0).get("username");
		String passWord= credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=my-account");
		
	
		accountPage = loginPage.doLogin(userName, passWord);
		
	
	}

	@Given("user is on Accounts page")
	public void user_is_on_Accounts_page() {
		
		String title =accountPage.getAccountPageTitle();
		System.out.println("Account Page Title is :" +title);

	   
	}

	@Then("user gets the accounts section")
	public void user_gets_the_accounts_section(DataTable sectionTable) {
		
		List<String> expectedSectionList = sectionTable.asList();
		
		System.out.println("Expected account section List:  : " +expectedSectionList);
		
		List<String> actualSectionList = accountPage.getAccountSectionList();
		
		System.out.println("Actual account section List" +actualSectionList);

		Assert.assertTrue(expectedSectionList.equals(actualSectionList));    
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		int size = accountPage.getAccountSectionsCount();
		System.out.println("Header section size :"  +size);

	    Assert.assertTrue(accountPage.getAccountSectionsCount() == expectedSectionCount);
	}




}
