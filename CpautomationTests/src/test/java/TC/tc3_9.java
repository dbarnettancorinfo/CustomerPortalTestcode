package TC;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.Test;

	
	public class tc3_9 {
																				// Test Case 3.9 - Selecting 'User Review' will take the user to the User Review page
	    private WebDriver driver;


	    @Test (priority = 1)
	    public void testUserReviewNavigationChrome() {
	    	// Set up ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "C:/Users/dbarnett/Downloads/chromedriver_win32 (2)/chromedriver.exe");
	        // Create driver object 
	        driver = new ChromeDriver();
	    	// Log into customer portal 
	    	logIn();
	        // Find User Review tab element        
	        WebElement userReviewTab = driver.findElement(By.id("UserReviewTab"));
	        // Wait until the 'UserReviewTab' element is visible
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserReviewTab")));
	     // Click on the 'User Review' link
	        userReviewTab.click();


	        // Verify if the user is taken to the User Review page
	        String expectedUserReviewURL = "http://customerportal.development.local/useradministration";
	        String actualUserReviewURL = driver.getCurrentUrl();
	        
	        // Print current page URL to console 
	        System.out.println(driver.getCurrentUrl());
	        
	        // Print the expected URL to console for error tracking 
	        System.out.println("Expected URL : " + "http://customerportal.development.local/useradministration");
	        
	        assert actualUserReviewURL.equals(expectedUserReviewURL) : "User Review page URL is not correct!";
	    }
	    @Test (priority = 2)
	    public void testUserReviewNavigationEdge() {
	    	 // Set up EdgeDriver path
	        System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");
	        // Create driver object 
	        driver = new EdgeDriver();
	    	// Log into customer portal 
	    	logIn();
	        // Find User Review tab element        
	        WebElement userReviewTab = driver.findElement(By.id("UserReviewTab"));
	        // Wait until the 'UserReviewTab' element is visible
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserReviewTab")));
	     // Click on the 'User Review' link
	        userReviewTab.click();


	        // Verify if the user is taken to the User Review page
	        String expectedUserReviewURL = "http://customerportal.development.local/useradministration";
	        String actualUserReviewURL = driver.getCurrentUrl();
	        
	        // Print current page URL to console 
	        System.out.println(driver.getCurrentUrl());
	        
	        // Print the expected URL to console for error tracking 
	        System.out.println("Expected URL : " + "http://customerportal.development.local/useradministration");
	        
	        assert actualUserReviewURL.equals(expectedUserReviewURL) : "User Review page URL is not correct!";
	    }
	    @Test (priority = 3)
	    public void testUserReviewNavigationFirefox() {
	    	// Set up FirefoxDriver path
	        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");
	        // Create driver object 
	        driver = new FirefoxDriver();
	    	// Log into customer portal 
	    	logIn();
	        // Find User Review tab element        
	        WebElement userReviewTab = driver.findElement(By.id("UserReviewTab"));
	        // Wait until the 'UserReviewTab' element is visible
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserReviewTab")));
	     // Click on the 'User Review' link
	        userReviewTab.click();


	        // Verify if the user is taken to the User Review page
	        String expectedUserReviewURL = "http://customerportal.development.local/useradministration";
	        String actualUserReviewURL = driver.getCurrentUrl();
	        
	        // Print current page URL to console 
	        System.out.println(driver.getCurrentUrl());
	        
	        // Print the expected URL to console for error tracking 
	        System.out.println("Expected URL : " + "http://customerportal.development.local/useradministration");
	        
	        assert actualUserReviewURL.equals(expectedUserReviewURL) : "User Review page URL is not correct!";
	    }
	    
	    
	    
	    
	    
	    
	    public void logIn() {
	    	// Open Ancor Customer Portal Login
	        driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");
	        
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


