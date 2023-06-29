package TC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebElement;

public class tc3_6 {
																// Test Case 3.6 - Can enter multiple VINs into the Vin Search Widget 
	
	    private WebDriver driver;

	    @Test (priority = 1)
	    public void testEnterMultipleVinsChrome() {
	    	// Set up path 
	    	System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\chromedriver_win32 (2)\\\\\\\\chromedriver.exe");
	    	// Create web driver object 
	    	driver = new ChromeDriver();	
	    
	    	// Run Test - Check test for logic 
	    	testEnterMultipleVINs();
	    	}

	    @Test ( priority = 2)
	    public void testEnterMultipleVinsEdge() {
	    	// Set up Path 
	    	System.setProperty("webdriver.edge.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\edgedriver_win64\\\\\\\\msedgedriver.exe");
	    	// Create web driver object 
	    	driver = new EdgeDriver();
	    	
	    	// Run Test - Check test for logic 
	    	testEnterMultipleVINs();
	    	
	    }
	    @Test (priority = 3)
	    public void testEnterMultipleVinsFirefox() {
	    	// Set Up Path
	    	System.setProperty("webdriver.gecko.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\geckodriver-v0.33.0-win32\\\\\\\\geckodriver.exe");
	    	// Create web driver object 
	    	driver = new FirefoxDriver();
	    	
	    	// Run Test - Check test for logic
	    	testEnterMultipleVINs();
	    }
	    
	    
	    
	    public void testEnterMultipleVINs() {
	       
	        
	        // Open Ancor Customer Portal Login// VIN search widget
	        driver.get("https://customerportal.ancorinfo.com/webview/AdvancedSearch");

	        // Enter Valid User Name into Email Field
	        WebElement emailField = driver.findElement(By.id("txtUsername"));
	        emailField.sendKeys("dbarnett@ancorinfo.com");

	        // Enter Valid Password
	        WebElement pwField = driver.findElement(By.id("txtPassword"));
	        pwField.sendKeys("@ncoR77&");

	        // Find and Click The Login Button
	        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));
	        loginButton.click();

	        // Locate the VIN input field - Wait until the element with ID "txtVINs" is visible
	        WebDriverWait wait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds
	        WebElement vinInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtVINs")));
	        
	        // Click text field 
	        vinInput.click();

	        // Enter multiple VINs separated by a comma
	        vinInput.sendKeys("1F0DP5CU2GL100015 ", "1FADP5AU0GL100061", "YV1MC68276J000379");

	        // Submit the VINs for search
	        WebElement searchButton = driver.findElement(By.id("btnSearchTop"));
	        searchButton.click();
	        
	        // Verify if the search results are displayed
	        String expectedText = "VIN(s)";
	        String pageSource = driver.getPageSource();

	        if (pageSource.contains(expectedText)) {
	            System.out.println( expectedText + "' found on the page source.");
	        } else {
	            System.out.println( expectedText + "' not found on the page source.");
	            Assert.fail( expectedText + "' not found on the page.");
	        }

	    }
	
	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	

								
								
			}

