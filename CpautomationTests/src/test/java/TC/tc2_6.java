package TC;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class tc2_6 {
																							// Test Case 2.6 - Verify that the input fields have the correct type, length, and format validation.
    private WebDriver driver;

    

    	@Test 
    	public void testInputFieldValdiationChrome() {
    		// Set path for Chrome driver 
    		System.setProperty("werdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver_win32 (2)\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver.exe");
    		// Create browser object 
    		driver = new ChromeDriver();
    		testInputFieldValidation();
    		
    	}
    	@Test 
    	public void testInputFieldValidationEdge () {
    		// Set path for edge drivdr
    		System.setProperty("webdriver.edge.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\edgedriver_win64\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\msedgedriver.exe");
    		//Create broswer object 
    		driver = new EdgeDriver();
    		testInputFieldValidation();
    	}
    
    	@Test 
    	public void testInputFieldValidationFirefox() {
    		// Set path for Firefox driver
    		System.setProperty("webdriver.gecko.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\geckodriver-v0.33.0-win32\\\\\\\\geckodriver.exe");
    		// Create browser object
    		driver = new FirefoxDriver();
    		testInputFieldValidation();
    	}
    
    
    
    
    
    
    
    public void testInputFieldValidation() {
        // Open the registration page
        driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");

        // Find the input fields and perform validation
        
        // Email field - Checks for input field length , types and max allowed characters 
        WebElement emailField = driver.findElement(By.id("txtUsername"));
        assert emailField.getAttribute("type").equals("email") : "Email field has incorrect type!";
        assert emailField.getAttribute("maxlength").equals("50") : "Email field has incorrect max length!";
        assert emailField.getAttribute("pattern").equals("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}") : "Email field has incorrect format validation!";

        // Password field - Checks for input field length , types and max allowed characters 
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        assert passwordField.getAttribute("type").equals("password") : "Password field has incorrect type!";
        assert passwordField.getAttribute("maxlength").equals("20") : "Password field has incorrect max length!";
        assert passwordField.getAttribute("pattern").equals("[A-Za-z0-9@#$%^&+=]+") : "Password field has incorrect format validation!";


    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

