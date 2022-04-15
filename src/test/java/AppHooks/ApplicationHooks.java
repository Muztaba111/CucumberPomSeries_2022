package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before (order = 0)
    public void getProperty() {
		
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		
	}
	
	
	
	
	/*
	 * Below method will initialize the chrome browser and enter the URL of the application
	 * 
	 */
	@Before (order = 1)
	public void LaunchBrowser() {
		
		String browserName = prop.getProperty("browser");
		String urlName = prop.getProperty("url");
		
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		driver.get(urlName);
		
	
	}
 
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1) 
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screnShotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);	
			
			scenario.attach(sourcePath,"image/png", screnShotName);
		}
	}

}
