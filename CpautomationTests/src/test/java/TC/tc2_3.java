package TC;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	
		public class tc2_3 {

	    private WebDriver driver;
	    															// Test Case 2.3 - Verify that the user is not allowed to log in after 5 unsuccessful login attempts.
	    @BeforeMethod
	    public void setUp() {
	        // Set up EdgeDriver path
	        System.setProperty("webdriver.edge.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\edgedriver_win64\\\\\\\\\\\\\\\\msedgedriver.exe");
	        // Set up FirefoxDriver path
	        System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\geckodriver-v0.33.0-win32\\\\geckodriver.exe");
	        // Set up ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\chromedriver_win32 (2)\\\\\\\\chromedriver.exe");

	       
	    }
	    
	    
	    @Test (priority = 1 )
	    public void testLoginAttemptsChrome () throws InterruptedException {
	    	// Create driver object
	    	 driver = new ChromeDriver ();
	    	// Run Test - Check test for logic 
	    	 testLoginAttempts(); 
	    }
	    @Test (priority = 2 )
	    public void testLoginAttemptsEdge() throws InterruptedException {
	    	// Create driver object 
	    	driver = new EdgeDriver();
	    	// Run Test - Check test for logic 
	    	testLoginAttempts();
	    }
	    @Test (priority = 3 )
	    public void testLoginAttemptsFirefox() throws InterruptedException {
	    	// Create driver object 
	    	driver = new FirefoxDriver();
	    	// Run Test - Check test for logic 
	    	testLoginAttempts();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public void testLoginAttempts() throws InterruptedException {
	        // Open the login page
	        driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");

	        // Attempt login with incorrect credentials five times
	        for (int i = 1; i <= 5; i++) {
	            WebElement usernameField = driver.findElement(By.id("txtUsername"));
	            WebElement passwordField = driver.findElement(By.id("txtPassword"));
	            WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));

	            // Enter incorrect username and password
	            usernameField.sendKeys("invalidusername@yahoo.com");
	            passwordField.sendKeys("invalidpassword");

	            // Click on the login button
	            loginButton.click();
	           
	            // Wait for the login error message to appear - You have performed this action more than 5 times in the last 300 seconds.
	            Thread.sleep(1000);

	            // Clear the fields for the next attempt
	            usernameField.clear();
	            passwordField.clear();
	            
	            // Find Element for additional time 
	            driver.findElement(By.id("txtUsername"));
	            driver.findElement(By.id("txtPassword"));
	            driver.findElement(By.id("LoginButtonContainer"));

	        }

	        // Verify if the login button is disabled after five unsuccessful login attempts
	        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));
	        assert !loginButton.isEnabled() : "Login button is not disabled after five unsuccessful login attempts!";

	        // Wait for 5 minutes (300,000 milliseconds) before re-attempting login
	        Thread.sleep(300000);

	        // Attempt login again with correct credentials
	        WebElement usernameField = driver.findElement(By.id("txtUsername"));
	        WebElement passwordField = driver.findElement(By.id("txtPassword"));
	        WebElement loginButton1 = driver.findElement(By.id("LoginButtonContainer"));

	        // Enter correct username and password
	        usernameField.sendKeys("dbarnett@ancorinfo");
	        passwordField.sendKeys("Blue1people2");

	        // Click on the login button
	        loginButton1.click();

	        // Verify if the user is logged in
	        WebElement welcomeMessage = driver.findElement(By.id("welcome-message"));
	        assert welcomeMessage.isDisplayed() : "Login failed after waiting for 5 minutes!";
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}


