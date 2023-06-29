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

	public class tc2_6_1 {

	    private WebDriver driver;
	    
	    @Test (priority = 1)
	    public void testForgotPasswordChrome() {
	    	// set up driver path 
	    	System.setProperty("webdriver.chrome.driver", "C:/Users/dbarnett/Downloads/chromedriver_win32 (2)/chromedriver.exe");
	    	// Create browser object 
	    	driver = new ChromeDriver();
	    	// Run Test - Check test for logic 
	    	testForgotPassword();
	    	
	    }
	    @Test (priority = 2)
	    public void testForgotPasswordEdge() {
	    	// Set up driver path 
	    	System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");
	    	// Create browser object 
	    	driver = new EdgeDriver();
	    	// Run Test - Check test for logic 
	    	testForgotPassword();
	    }
	    @Test (priority = 3)
	    public void testForgotPasswordFirefox() {
	    	// Set up driver path 
	    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");
	    	// Create browser object 
	    	driver = new FirefoxDriver();
	    	// Run Test - Check Test for logic 
	    	testForgotPassword();
	    	
	    }

	    
	    public void testForgotPassword() {
	    	// Navigate to log in page 
	    	driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");
	    	
	        // Find the "Forgot Password" link element
	        WebElement forgotPasswordLink = driver.findElement(By.id("lnkForgotPassword"));

	        // Click the "Forgot Password" link
	        forgotPasswordLink.click();

	        // Verify if the email modal is displayed
	        WebElement emailModal = driver.findElement(By.id("ForgotPasswordContent")); 

	        Assert.assertTrue(emailModal.isDisplayed(), "The email modal is not displayed after clicking the 'Forgot Password' link.");
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}


