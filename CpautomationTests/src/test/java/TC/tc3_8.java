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

	public class tc3_8 {
																			// Test Case 3.8 - Selecting 'Simple Search' or 'Advanced Search' will take you to their respective pages.
	    private WebDriver driver;

	    

	    
	    @Test (priority = 1)
	    public void testSimpleSearchNavigationChrome() {
	    	// Set up Driver path 
	    	 System.setProperty("webdriver.chrome.driver", "C:/Users/dbarnett/Downloads/chromedriver_win32 (2)/chromedriver.exe");
	    	 // New driver object 
	    	 driver = new ChromeDriver();
	    	// Run Test - Check Test for logic 
	    	testSimpleSearchNavigation();
	    }
	    @Test(priority = 2)
	    public void testSimpleSearchNavigationEdge() {
	    	// Set up Driver path 
	        System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");
	        // New driver object 
	    	 driver = new EdgeDriver();
	    	// Run Test - Check Test for logic 
	    	testSimpleSearchNavigation();

	    }
	   
	    @Test (priority = 3)
    	public void testSimpleSearchNavigationFirefox() {
	    	// Set up Driver path 
	        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");
	        // New driver object 
	        driver = new FirefoxDriver();
	        // Run Test - Check Test for logic
	    testSimpleSearchNavigation();
    	}
	    
	    
	    
	    
	    @Test (priority = 4)
	    public void testAdvancedSearchNavigationChrome() {
	    	// Set up Driver path 
	    	 System.setProperty("webdriver.chrome.driver", "C:/Users/dbarnett/Downloads/chromedriver_win32 (2)/chromedriver.exe");
	    	 // New driver object 
	    	 driver = new ChromeDriver();
	    	// Run Test - Check Test for logic     	
	    	testSimpleSearchNavigation();
	    }
	    @Test(priority = 5)
	    public void testAdvancedSearchNavigationEdge() {
	    	// Set up Driver path 
	        System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");
	        // New driver object 
	    	 driver = new EdgeDriver();
		    // Run Test - Check Test for logic 
	    	testSimpleSearchNavigation();

	    }
	   
	    @Test (priority = 6)
    	public void testAdvancedSearchNavigationFirefox() {
	    	// Set up Driver path 
	        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");
	        // New driver object 
	        driver = new FirefoxDriver();
	        // Run Test - Check Test for logic
	    testSimpleSearchNavigation();
    	}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public void testSimpleSearchNavigation() {
	    	// log into customer portal 
	    	logIn();
	    	
	    	// Wait for the "SearchTab" element to be in view - Click on the 'Simple Search' link
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement searchTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SearchTab\"]")));

	        // Click on the "SearchTab" element
	        searchTab.click();
	        
	        
	        // Wait for URL to populate - ensures accurate Url is read 
	        try {
	            Thread.sleep(10000); // Wait for 10 seconds (10,000 milliseconds)
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Verify the current URL is the Simple Search page URL
	        String expectedSimpleSearchURL = "https://customerportal.ancorinfo.com/Webview/Search";
	        String actualSimpleSearchURL = driver.getCurrentUrl();
	        assert !actualSimpleSearchURL.equals(expectedSimpleSearchURL) : "Simple Search page URL is not correct!";
	    }

	    
	    public void testAdvancedSearchNavigation() {
	    	// log into customer portal 
	    	logIn();
	        
	     // Wait for the "AdvancedSearchTab" element to be in view - Click on the 'Advanced Search' link
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement advancedSearchLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AdvancedSearchTab\"]")));
	        advancedSearchLink.click();
	        
	        // Wait for URL to populate - ensures accurate Url is read 
	        try {
	            Thread.sleep(10000); // Wait for 10 seconds (10,000 milliseconds)
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        // Verify the current URL is the Advanced Search page URL
	        String expectedAdvancedSearchURL = "https://customerportal.ancorinfo.com/webview/AdvancedSearch";
	        String actualAdvancedSearchURL = driver.getCurrentUrl();
	        assert !actualAdvancedSearchURL.equals(expectedAdvancedSearchURL) : "Advanced Search page URL is incorrect!";
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
	        // Close the browser
	        driver.quit();
	    }
	}
	
	
	
	
