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

public class tc3_5_1 {
																			// Test Case 3.5.1 - Clicking on 'Document Library' will send the User to the Document Library page. (Ford Page)
	
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

	    @Test ( priority =1)
	    public void testWebviewLoadsRedirectEdge() {
	    	// Create Edge Browser Object 
	    	driver = new EdgeDriver();
	    	// Logs into Ford Mortor Company Customer Page 
	    	logIn();
	    	
	        // Wait until the 'Webview Loads' link is visible
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement webviewLoadsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"UsageReportContainerHeader\"]/a")));
	        // Click on the 'Webview Loads' link
	        webviewLoadsLink.click();

	        // Verify if the user is redirected to the 'File Processing Status' report page
	        String expectedRedirectedURL = "http://customerportal.development.local/documentlibrary";
	        String actualURL = driver.getCurrentUrl();
	        
	        // Print current page URL to the console 
	        System.out.println(driver.getCurrentUrl());
	        
	        // Print Expected URL to console 
	        System.out.println("Expected: " + "http://customerportal.development.local/documentlibrary");

	        assert actualURL.equals(expectedRedirectedURL) : "User is not redirected to the 'documentlibrary' report page!";
	        
	    }
	    @Test (priority =2)
	    public void testWebviewLoadsRedirectChrome() {
	    	// Create Chrome Browser Object 
	    	driver = new ChromeDriver();
	    	// Logs into Ford Mortor Company Customer Page 
	    	logIn();
	    	
	        // Wait until the 'Webview Loads' link is visible
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement webviewLoadsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"UsageReportContainerHeader\"]/a")));
	        // Click on the 'Webview Loads' link
	        webviewLoadsLink.click();

	        // Verify if the user is redirected to the 'File Processing Status' report page
	        String expectedRedirectedURL = "http://customerportal.development.local/documentlibrary";
	        String actualURL = driver.getCurrentUrl();
	        
	        // Print current page URL to the console 
	        System.out.println(driver.getCurrentUrl());
	        
	        // Print Expected URL to console 
	        System.out.println("Expected: " + "http://customerportal.development.local/documentlibrary");
	        
	        assert actualURL.equals(expectedRedirectedURL) : "User is not redirected to the 'documentlibrary' report page!";
	        
	    }
	    	
	    @Test (priority = 3 )
	    public void testWebviewLoadsRedirectFirefox() {
	    	// Create Firefox Browser Object 
	    	driver = new FirefoxDriver();
	    	// Logs into Ford Mortor Company Customer Page 
	    	logIn();
	    	
	        // Wait until the 'Webview Loads' link is visible
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement webviewLoadsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"UsageReportContainerHeader\"]/a")));
	        // Click on the 'Webview Loads' link
	        webviewLoadsLink.click();

	        // Verify if the user is redirected to the 'File Processing Status' report page
	        String expectedRedirectedURL = "http://customerportal.development.local/documentlibrary";
	        String actualURL = driver.getCurrentUrl();
	        
	        // Print current page URL to the console 
	        System.out.println(driver.getCurrentUrl());
	        
	        // Print Expected URL to console 
	        System.out.println("Expected: " + "http://customerportal.development.local/documentlibrary");

	        assert actualURL.equals(expectedRedirectedURL) : "User is not redirected to the 'documentlibrary' report page!";
	        
	    }
	    
	    
	    
	    
	    
	    public void logIn() {
	    	// Open Ancor Customer Portal Login - starts at Ford Mortor Company 
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





