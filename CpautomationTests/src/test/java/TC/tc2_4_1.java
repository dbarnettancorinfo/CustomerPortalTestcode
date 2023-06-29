package TC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class tc2_4_1 {
    private WebDriver driver;
    														// Test Case 2.4.1 - Ensure that user is not able to submit with a blank username or password

   
    	@Test ( priority = 1 )
    	public void testBlankUsernamePasswordEdge() {
    		// Set Browser path 
    		System.setProperty("webdriver.edge.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\edgedriver_win64\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\msedgedriver.exe");
    		// instantiate new driver object 
    		driver = new EdgeDriver();
    		// Run Test - check test for logic 
    		testBlankUsernamePassword();
    	}
    
    	
    	@Test (priority = 2)
    	public void testBlankUsernamePasswordChrome() {
    		// Set browser path 
    		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver_win32 (2)\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver.exe");
    		// Create New browser object 
    		driver = new ChromeDriver();
    		// Run test - Check test for logic 
    		testBlankUsernamePassword();
    	}
    	@Test (priority = 3)
    	public void testBlankUsernamePasswordFirefox() {
    		// Set browser path 
    		System.setProperty("webdriver.gecko.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\geckodriver-v0.33.0-win32\\\\\\\\geckodriver.exe");
    		// Create New browser object 
    		driver = new FirefoxDriver();
    		// Run test - Check test for logic 
    		testBlankUsernamePassword();
    	}
    	 public void testBlankUsernamePassword() {
    	    	// Navigate to login Page 
    	        driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");
    	        driver.manage().window().maximize();

    	        WebElement usernameField = driver.findElement(By.id("txtUsername"));
    	        WebElement passwordField = driver.findElement(By.id("txtPassword"));
    	        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));

    	        // Attempt to submit with blank username and password
    	        loginButton.click();

    	        // Verify error messages
    	        WebElement usernameError = driver.findElement(By.id("txtUsername-error"));
    	        WebElement passwordError = driver.findElement(By.id("txtPassword-error"));

    	        Assert.assertTrue(usernameError.isDisplayed(), "Username error message is not displayed for blank username");
    	        Assert.assertTrue(passwordError.isDisplayed(), "Password error message is not displayed for blank password");
    	    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}




