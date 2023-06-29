package TC;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.Test;

	public class tc2_1_1 {
														// Test Case 2.1.1 - Ensure entering a bad Email will not allow you to login and will generate a generic error message. Validates email formatting
	    private WebDriver driver;

	  
	    
	    @Test (priority = 1)
	    public void testBadEmailLoginChrome () {
	    	// Set Browser path 
	    	System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver_win32 (2)\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver.exe");
	    	// Instantiate new browser Object 
	    	driver = new ChromeDriver();
	    	// Run Test - Check test method for logic 
	    	testBadEmailLogin();
	    }
	    
	    @Test (priority = 2)
	    public void testBadEmailLoginEdge () {
	    	// Set Browser path 
	    	System.setProperty("webdriver.edge.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\edgedriver_win64\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\msedgedriver.exe");
	    	// Instantiate new browser Object 
	    	driver = new EdgeDriver();
	    	// Run Test - Check test method for login
	    	testBadEmailLogin();
	    }
	    
	    @Test ( priority = 3)
	    public void testbademailLoginFirefox() {
	    	// Set browser path 
	    	System.setProperty("webdriver.firefox.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\geckodriver-v0.33.0\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\geckodriver.exe");
	    	// instantiate new browser object 
	    	driver = new FirefoxDriver();
	    	// Run Test - Check method for logic 
	    	testBadEmailLogin();
	    }
	  
	    
	    public void testBadEmailLogin() {
	        // Open the login page
	        driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");

	        // Find the email input field and enter a bad email
	        WebElement emailField = driver.findElement(By.id("txtUsername"));
	        emailField.sendKeys("bademail");

	        // Find the password input field and enter a valid password
	        WebElement passwordField = driver.findElement(By.id("txtPassword"));
	        passwordField.sendKeys("password123");

	        // Once you Click away from the log in field the error message should populate below use name field 

	        // Find the error message element
	        WebElement errorMessage = driver.findElement(By.id("txtUsername-error"));

	        // Verify that the error message is displayed and contains the expected text
	        assert errorMessage.isDisplayed() : "Invalid Email Address";
	        assert errorMessage.getText().equals("Invalid Email Address") : "Incorrect error message displayed!";
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}


