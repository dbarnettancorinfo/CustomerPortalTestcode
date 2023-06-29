package TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class tc5_2 {
				private WebDriver driver;																	// Test Case 5.2 - Enter key should perform a search when the Search Button is enabled and the VINs text area is not selected.
				private WebDriverWait wait;
	
	@Test (priority = 1 )
	public void searchButtonTestChome () {
		// Set Browser path 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dbarnett\\Downloads\\chromedriver_win32 (2)\\\\chromedriver.exe");
		
		// Create Chrome browser object 
		driver = new ChromeDriver();
		
		// Login into the customer portal 
		logIn();
		
		// Check test For logic 
		searchButtonTest();
		}
				
	@Test (priority = 2)
	public void searchButtonTestEdge() {
		// Set Browser Path 
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dbarnett\\Downloads\\edgedriver_win64\\\\msedgedriver.exe");
		
		// Create Edge browser object 
		driver = new EdgeDriver();
		
		// Log into the customer portal 
		logIn();
		
		// Check test for logic 
		searchButtonTest();
	}
	
	
	@Test (priority = 3)
	public void searchButtonTestFirefox () {
		// Set browser path 
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\Downloads\\geckodriver-v0.33.0-win32\\\\geckodriver.exe");
		
		// Create Firefox browser object 
		driver = new FirefoxDriver();
		
		// Log into the customer portal 
		logIn();
		
		// Check text for logic
		searchButtonTest();
	}
				
				
				
				
				
	public void searchButtonTest() {
		 wait = new WebDriverWait(driver, 10);
		 
		 
		//find Vin search button 
		WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SearchTab btnSearchTop\"]")));
		// Click  VIN Search button 
		searchButton.click();
		
		// Assure that the search button click navigates you to search page 
		String actualUrl = driver.getCurrentUrl();
		
		
		// Proper Url Address 
		String expectedUrl = "http://customerportal.development.local/Webview/Search";
		
		// assert that the expected URl is the same as the Actual URL
		assert actualUrl.equals(expectedUrl);
		
		
	}
	
	public void logIn() {
		// Open Ancor Customer Portal Login
        driver.get("http://customerportal.development.local/home/ChangeClient?clientCode=FMC");
        
    	// Enter Valid User Name into Email Field
        WebElement emailField = driver.findElement(By.id("txtUsername"));
        emailField.sendKeys("dbarnett@ancorinfo.com");

        // Enter Valid Password
        WebElement pwField = driver.findElement(By.id("txtPassword"));
        pwField.sendKeys("Blue1people2");

        // Find and Click The Login Button
        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));
        loginButton.click();
		
	}

			@AfterMethod
			public void tearDown() { 
				driver.quit();
				
			}
}
