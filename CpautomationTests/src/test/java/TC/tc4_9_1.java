package TC;


																							// Test Case 4.9.1 - 'Clicking on the Title 'Usage Report' will take the user to the 'User Usage Report' page.
	
	
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class tc4_9_1 {
	    private WebDriver driver;
	    private WebDriverWait wait;

	  
	    

	    @Test(priority = 1)
	    public void testWebElementRedirectInChrome() {
	        performTest();
	    }

	    @Test(priority = 2)
	    public void testWebElementRedirectInFirefox() {
	        performTest();
	    }

	    @Test(priority = 3)
	    public void testWebElementRedirectInEdge() {
	    	System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");
            driver = new EdgeDriver();
            
	        performTest();
	    }

	    public void performTest() {
	        // Navigate to the initial URL
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
	        
	        
	        // Set up explicit wait with a timeout of 10 seconds
	        WebDriverWait wait = new WebDriverWait(driver, 10);

	        // Wait until the element is visible
	        WebElement usageReportLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"UsageReportContainerHeader\"]")));
	        
	        // Find the web element with XPath
	        WebElement usageReportLink1 = driver.findElement(By.id("UsageReportContainerHeader"));
	        
	        // Click the web element
	        usageReportLink.click();
	      
	        // Get the current URL
	        String currentURL = driver.getCurrentUrl();

	        // Define the expected URL
	        String expectedURL = "http://customerportal.development.local/UserAdministration/UserUsageReport";

	        // Assert if the expected URL equals the actual URL
	        if (expectedURL.equals(currentURL)) {
	            System.out.println(  " Expected:" + expectedURL +  "URL matches actual URL.");
	        } else {
	            System.out.println("Test failed  "  + "  Expected URL: " + expectedURL +
	                    ", Actual URL: " + currentURL);
	            assert expectedURL.equals(currentURL);
	        }

	       
	    }
	 
	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}


