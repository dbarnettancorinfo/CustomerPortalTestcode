package TC;


																						// Test Case 4.5.1 - Clicking on this widget will redirect the user to the Document Library page.
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class tc4_5_1 {
	    private WebDriver driver;
	    private WebDriverWait DriverWait;


	    

	    @Test (priority = 1)
	    public void testDocumentLibraryLinkChrome() {
	   
	    	// Set up ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "C:/Users/dbarnett/Downloads/chromedriver_win32 (2)/chromedriver.exe");
	        // Create Chrome Browser Instance 
	        driver = new ChromeDriver();
	    	
	    	// Log into customer portal 
	    		logIn();
	    	
	    	
	        String[] urls = {
	                "http://customerportal.development.local/home/ChangeClient?clientCode=FFM",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=FCA",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=LMC",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=VFA",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=VOL"
	        };

	        for (String url : urls) {
	            // Open the customer portal page
	            driver.get(url);

	            // Click on the DOCUMENT_LIBRARY_LINK_WIDGET element
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            WebElement documentLibraryLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DOCUMENT_LIBRARY_LINK_WIDGET")));
	            documentLibraryLink.click();

	            // Verify the redirected URL
	            String expectedURL = "http://customerportal.development.local/documentlibrary";
	            String actualURL = driver.getCurrentUrl();

	            if (actualURL.equals(expectedURL)) {
	                System.out.println("Redirected to the correct URL: " + expectedURL);
	            } else {
	                System.out.println("Redirected to the wrong URL. Expected: " + expectedURL + ", Actual: " + actualURL);
	                // Assert/Assure that the actual URL equals the expected URL
		               Assert.assertEquals(actualURL, expectedURL, "Admin link did not redirect to the expected URL.");
	            }
	        }
	    }
	    @Test (priority = 2)
	    public void testDocumentLibraryLinkEdge() {
	 	   
	    	// Set up EdgeDriver path
	        System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");
	        // Create Chrome Browser Instance 
	        driver = new EdgeDriver();
	    	
	    	// Log into customer portal 
	    		logIn();
	    	
	    	
	        String[] urls = {
	                "http://customerportal.development.local/home/ChangeClient?clientCode=FFM",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=FCA",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=LMC",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=VFA",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=VOL"
	        };

	        for (String url : urls) {
	            // Open the customer portal page
	            driver.get(url);

	            // Click on the DOCUMENT_LIBRARY_LINK_WIDGET element
	            WebDriverWait wait = new WebDriverWait(driver, 10); 
	            WebElement documentLibraryLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DOCUMENT_LIBRARY_LINK_WIDGET")));
	            documentLibraryLink.click();

	            // Verify the redirected URL
	            String expectedURL = "http://customerportal.development.local/documentlibrary";
	            String actualURL = driver.getCurrentUrl();

	            if (actualURL.equals(expectedURL)) {
	                System.out.println("Redirected to the correct URL: " + expectedURL);
	            } else {
	                System.out.println("Redirected to the wrong URL. Expected: " + expectedURL + ", Actual: " + actualURL);
	                // Assert/Assure that the actual URL equals the expected URL
		               Assert.assertEquals(actualURL, expectedURL, "Admin link did not redirect to the expected URL.");
	            }
	        }
	    }

	    @Test (priority = 3)
	    public void testDocumentLibraryLinkFirefox() {
		 	   
	    	// Set up EdgeDriver path
	        System.setProperty("webdriver.gecko.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\geckodriver-v0.33.0-win32\\\\\\\\geckodriver.exe");
	        // Create FireFox Browser Instance 
	        driver = new FirefoxDriver();
	    	
	    	// Log into customer portal 
	    		logIn();
	    	
	    	
	        String[] urls = {

	                "http://customerportal.development.local/home/ChangeClient?clientCode=FCA",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=LMC",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=VFA",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=VOL",
	                "http://customerportal.development.local/home/ChangeClient?clientCode=FFM"
	        };

	        for (String url : urls) {
	            // Open the customer portal page
	            driver.get(url);

	            // Click on the DOCUMENT_LIBRARY_LINK_WIDGET element
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            WebElement documentLibraryLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DOCUMENT_LIBRARY_LINK_WIDGET")));
	            documentLibraryLink.click();

	            // Verify the redirected URL
	            String expectedURL = "http://customerportal.development.local/documentlibrary";
	            String actualURL = driver.getCurrentUrl();

	            if (actualURL.equals(expectedURL)) {
	                System.out.println("Redirected to the correct URL: " + expectedURL);
	            } else {
	                System.out.println("Redirected to the wrong URL. Expected: " + expectedURL + ", Actual: " + actualURL);
	                // Assert/Assure that the actual URL equals the expected URL
		               Assert.assertEquals(actualURL, expectedURL, "Admin link did not redirect to the expected URL.");
	            }
	        }
	    }

	    
	    public void logIn() {
	    	// Open Ancor Customer Portal Login
	        driver.get("http://customerportal.development.local/home/ChangeClient?clientCode=VOL");
	        
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

