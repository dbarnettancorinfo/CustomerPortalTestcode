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
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class tc4_1 {
																								// Test Case 4.1 - 'Clicking on this widget will redirect the user to the print center page. (Print Center) 
																								// Identify All clients with print center widget / button 	: Faraday , Canoo , lordstown motors , vin fast   

	    private WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        // Set up ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "C:/Users/dbarnett/Downloads/chromedriver_win32 (2)/chromedriver.exe");
	        // Set up FirefoxDriver path
	        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");
	        // Set up EdgeDriver path
	        System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");

	    }

	    @Test ( priority = 1)
	    public void testPrintCenterWidgetChrome() {
	    	// Create Chrome browser object 
	        driver = new ChromeDriver();
	    	
	    	// Log into customer portal - Starting at Faraday future 
	    	 logIn();

	        // Wait until the element with id "PRINT_CENTER_LINK_WIDGET" is visible
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement printCenterLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PRINT_CENTER_LINK_WIDGET")));

	        // Click on the element to redirect to the Print Center page
	        printCenterLink.click();

	        // Verify if the user is redirected to the expected URL
	        String expectedRedirectedURL = "http://customerportal.development.local/PrintCenter/PrintDashCenter";
	        String actualURL = driver.getCurrentUrl();

	        assert actualURL.equals(expectedRedirectedURL) : "User is not redirected to the expected URL: " + expectedRedirectedURL;

	        // Repeat the same steps for the remaining URLs
	        String[] clientCodes = {"CNO", "VFA", "LMC"};
	        for (String clientCode : clientCodes) {
	            navigateToUrl("http://customerportal.development.local/home/ChangeClient?clientCode=" + clientCode);

	            printCenterLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PRINT_CENTER_LINK_WIDGET")));
	            printCenterLink.click();

	            actualURL = driver.getCurrentUrl();
	            assert actualURL.equals(expectedRedirectedURL) : "User is not redirected to the expected URL: " + expectedRedirectedURL;
	        }
	    }
	    @Test (priority = 2)
	    public void testPrintCenterWidgetEdge() {
	    	// Create Edge browser object 
	        driver = new EdgeDriver();
	    	
	    	// Log into customer portal - Starting at Faraday future 
	    	 logIn();

	        // Wait until the element with id "PRINT_CENTER_LINK_WIDGET" is visible
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement printCenterLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PRINT_CENTER_LINK_WIDGET")));

	        // Click on the element to redirect to the Print Center page
	        printCenterLink.click();

	        // Verify if the user is redirected to the expected URL
	        String expectedRedirectedURL = "http://customerportal.development.local/PrintCenter/PrintDashCenter";
	        String actualURL = driver.getCurrentUrl();

	        assert actualURL.equals(expectedRedirectedURL) : "User is not redirected to the expected URL: " + expectedRedirectedURL;

	        // Repeat the same steps for the remaining URLs
	        String[] clientCodes = {"CNO", "VFA", "LMC"};
	        for (String clientCode : clientCodes) {
	            navigateToUrl("http://customerportal.development.local/home/ChangeClient?clientCode=" + clientCode);

	            printCenterLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PRINT_CENTER_LINK_WIDGET")));
	            printCenterLink.click();

	            actualURL = driver.getCurrentUrl();
	            assert actualURL.equals(expectedRedirectedURL) : "User is not redirected to the expected URL: " + expectedRedirectedURL;
	        }
	    }
	    
	    
	    
	    @Test (priority = 3 )
	    public void testPrintCenterWidgeFirefox() {
	    	// Create Edge browser object 
	        driver = new FirefoxDriver();
	    	
	    	// Log into customer portal - Starting at Faraday future 
	    	 logIn();

	        // Wait until the element with id "PRINT_CENTER_LINK_WIDGET" is visible
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement printCenterLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PRINT_CENTER_LINK_WIDGET")));

	        // Click on the element to redirect to the Print Center page
	        printCenterLink.click();

	        // Verify if the user is redirected to the expected URL
	        String expectedRedirectedURL = "http://customerportal.development.local/PrintCenter/PrintDashCenter";
	        String actualURL = driver.getCurrentUrl();

	        assert actualURL.equals(expectedRedirectedURL) : "User is not redirected to the expected URL: " + expectedRedirectedURL;

	        // Repeat the same steps for the remaining URLs
	        String[] clientCodes = {"CNO", "VFA", "LMC"};
	        for (String clientCode : clientCodes) {
	            navigateToUrl("http://customerportal.development.local/home/ChangeClient?clientCode=" + clientCode);

	            printCenterLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PRINT_CENTER_LINK_WIDGET")));
	            printCenterLink.click();

	            actualURL = driver.getCurrentUrl();
	            assert actualURL.equals(expectedRedirectedURL) : "User is not redirected to the expected URL: " + expectedRedirectedURL;
	        }
	    }
	    private void navigateToUrl(String url) {
	        driver.navigate().to(url);
	    }

	    public void logIn() {
	    	// Open Ancor Customer Portal Login
	        driver.get("http://customerportal.development.local//home/ChangeClient?clientCode=FFM");
	        
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

					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
					

