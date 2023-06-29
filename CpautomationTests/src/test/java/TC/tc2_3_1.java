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

	public class tc2_3_1 {
															// Test Case 2.3.1 - Ensure that users will get a lockout message after 5 invalid login attempts (in 300 seconds) 
	    private WebDriver driver;


	        
	    @Test (priority = 1 )
	    public void testLockoutMessageChrome() {
	    	// Set browser path 
	    	System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver_win32 (2)\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver.exe");
	    	// Create new object 
	    	driver = new ChromeDriver();
	    	// Run Test - Check test for logic 
	    	testLockoutMessage();
	    }
	     
		    @Test (priority = 2 )
		    public void testLockoutMessageEdge() {
		    	// Set browser path 
		    	System.setProperty("webdriver.edge.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\edgedriver_win64\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\msedgedriver.exe");
		    	// Create new object 
		    	driver = new EdgeDriver();
		    	// Run Test - Check test for logic 
		    	testLockoutMessage();
		    }
		     
		    @Test (priority = 3 )
		    public void testLockoutMessageFirefox() {
		    	// Set browser path 
		    	System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\geckodriver-v0.33.0-win32\\\\geckodriver.exe");
		    	// Create new object 
		    	driver = new FirefoxDriver();
		    	// Run Test - Check test for logic 
		    	testLockoutMessage();
		    }
		    
	   
	

	   
	    public void testLockoutMessage() {
	    	// open window tab and maximize the browser window 
	    	driver.manage().window().maximize();
	    	// Navigate to Customer Log in page in dev Environment 
	        driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");
	        
	        WebElement usernameField = driver.findElement(By.id("txtUsername"));
	        WebElement passwordField = driver.findElement(By.id("txtPassword"));
	        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));

	        String invalidUsername = "invalidusername@yahoo.com";
	        String invalidPassword = "invalidpassword";

	        // Attempt login with invalid credentials five times
	        for (int i = 0; i < 6; i++) {
	            usernameField.sendKeys(invalidUsername);
	            passwordField.sendKeys(invalidPassword);
	            loginButton.click();
	            
	            // Find element an additional time 
	            usernameField = driver.findElement(By.id("txtUsername"));
		         passwordField = driver.findElement(By.id("txtPassword"));
		         loginButton = driver.findElement(By.id("LoginButtonContainer"));

	            // Clear the fields for the next attempt
	            usernameField.clear();
	            passwordField.clear();
	            
	          
	        }
	        // Verify lockout message
	        WebElement lockoutMessage = driver.findElement(By.id("lockout-message"));
	        String expectedLockoutMessage = "You have performed this action more than 5 times in the last 300 seconds.";
	        Assert.assertEquals(lockoutMessage.getText(), expectedLockoutMessage,
	                "Incorrect lockout message displayed after multiple invalid login attempts");

	        Assert.assertTrue(lockoutMessage.isDisplayed(), "Lockout message is not displayed!");
	    }

	    @AfterMethod
	    public void tearDown() {
	    	 driver.quit();
	    }
	}


