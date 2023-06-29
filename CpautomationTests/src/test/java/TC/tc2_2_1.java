package TC;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class tc2_2_1 {
																				// Test Case 2.2.1 - Ensure entering a bad Password will not allow you to login and will generate a generic error message
	    private WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");
	    }

	    @Test (priority = 1)
	    public void testBadPasswordLoginChrome() {
	    	// Set browser path 
	    	System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver_win32 (2)\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver.exe");
	    	// instantiate browser object 
	    	driver = new ChromeDriver();
	    	// Run Test - Check test for logic 
	    	testBadPasswordLogin();
	    }
	    @Test (priority = 2)
	    public void testBadPasswordLoginEdge() {
	    	// Set browser path 
	    	System.setProperty("webdriver.edge.drive", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\edgedriver_win64\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\msedgedriver.exe");
	    	// instantiate browser object
	    	driver = new EdgeDriver();
	    	// Run Test - Check test for logic 
	    	testBadPasswordLogin();
	    }
	    @Test (priority = 3)
	    public void testBadpasswordLoginFirefox() {
	    	// Set browser path 
	    	System.setProperty("webdriver.firefox.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\geckodriver-v0.33.0\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\geckodriver.exe");
	    	// instantiate browser object 
	    	driver = new FirefoxDriver();
	    	// Run test - Check test for logic 
	    	testBadPasswordLogin();
	    }
	    
	    
	    
	    
	    
	    public void testBadPasswordLogin() {
	        WebElement usernameField = driver.findElement(By.id("txtUsername"));
	        WebElement passwordField = driver.findElement(By.id("txtPassword"));
	        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));

	        usernameField.sendKeys("dbarnett@ancorinfo.com");
	        passwordField.sendKeys("badpassword");

	        loginButton.click();
	        // locates error message 
	        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(), 'Your information doesn't match our records. Please try again.')]"));
	        String expectedErrorMessage = "Your information doesn't match our records. Please try again.";
	        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage,
	                "Incorrect error message displayed for bad password login attempt");

	        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed!");
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}


