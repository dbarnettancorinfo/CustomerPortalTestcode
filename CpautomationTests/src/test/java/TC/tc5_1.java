package TC;


																											/* Test Case 5.1 - Can enter multiple vins/base8s to search on.Field accepts only alphanumeric, commas, and white space.If the entered vin(s) are not either 8 or 17 characters an error message will display. 
Error message will only display if the vins are incorrect when clicking search.
																											 
																											 */
	
	
	
	
	
	
	import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.Test;
	import org.openqa.selenium.support.ui.WebDriverWait;
	

			public class tc5_1 {
	    private WebDriver driver;

   	 


	    @Test
	    public void testVINSearchPassChrome() {
	    	 System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\chromedriver_win32 (2)\\\\\\\\\\\\\\\\chromedriver.exe");
		        driver = new ChromeDriver();
		        WebDriverWait wait = new WebDriverWait(driver, 10);
	        // Open the page
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

	        // Find and enter the VINs
	        WebElement vinsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtVINs")));
	        vinsElement.sendKeys("3FADP4AJ0BM104845,");

	        // Find and enter the second VIN
	        vinsElement.sendKeys("JBB46724");

	        // Find and click the Search button
	        WebElement searchButton = driver.findElement(By.id("SearchTab btnSearchTop"));
	        searchButton.click();

	        // Wait for the search results page to load
	        // Assuming the text "VIN(s) found" appears on the page to indicate successful search results
	        boolean resultsText = driver.getPageSource().contains("VIN(s) found");
	        Assert.assertTrue(resultsText = true , "VIN(s) found text is not displayed.");
	       	        }
	    
	    public void testVINSearchPassFirefox() {
	    	
	    	 System.setProperty("webdriver.gecko.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\geckodriver-v0.33.0\\\\\\\\\\\\\\\\geckodriver.exe");
		        driver = new FirefoxDriver();
	    	
	        // Open the page
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

	        // Find and enter the VINs
	        WebElement vinsElement = driver.findElement(By.id("txtVINs"));
	        vinsElement.sendKeys("3FADP4AJ0BM104845,");

	        // Find and enter the second VIN
	        vinsElement.sendKeys("JBB46724");

	        // Find and click the Search button
	        WebElement searchButton = driver.findElement(By.id("SearchTab btnSearchTop"));
	        searchButton.click();

	        // Wait for the search results page to load
	        // Assuming the text "VIN(s) found" appears on the page to indicate successful search results
	        boolean resultsText = driver.getPageSource().contains("VIN(s) found");
	        Assert.assertTrue(resultsText = true , "VIN(s) found text is not displayed.");
	       	        }
	    
	    public void testVINSearchPassEdge() {
	    	
	    	 System.setProperty("webdriver.edge.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\edgedriver_win64\\\\msedgedriver.exe");
		        driver = new EdgeDriver();
	    	
	        // Open the page
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

	        // Find and enter the VINs
	        WebElement vinsElement = driver.findElement(By.id("txtVINs"));
	        vinsElement.sendKeys("3FADP4AJ0BM104845,");

	        // Find and enter the second VIN
	        vinsElement.sendKeys("JBB46724");

	        // Find and click the Search button
	        WebElement searchButton = driver.findElement(By.id("SearchTab btnSearchTop"));
	        searchButton.click();

	        // Wait for the search results page to load
	        // Assuming the text "VIN(s) found" appears on the page to indicate successful search results
	        boolean resultsText = driver.getPageSource().contains("VIN(s) found");
	        Assert.assertTrue(resultsText = true , "VIN(s) found text is not displayed.");
	       	        }
	    
	    @Test
	    public void testVinSearchFailEdge() {
	    	System.setProperty("webdriver.edge.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\edgedriver_win64\\\\msedgedriver.exe");
	        driver = new EdgeDriver();
    	
        // Open the page
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
	    
        // Find and enter the VINs
        WebElement vinsSearchElement = driver.findElement(By.id("txtVINs"));
        vinsSearchElement.sendKeys("3Fa");
        
        // Find Search Button 
        WebElement searchButton = driver.findElement(By.id("SearchTab btnSearchTop"));
        searchButton.click();
        
        // Check page for Error
        boolean errormMessage = driver.getPageSource().contains("VINs must be either 8 or 17 characters long:");   
        
        String expectedMessage = "VINs must be either 8 or 17 characters long:";
       // Assert Fail if Error Message Not Present
        assert expectedMessage.equals(errormMessage) ;
	    }
      
	        

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}


