package customerportal.development.local.CpautomationTests;
				


    
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class TestCase1_1{
	    private WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        // Set up the ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dbarnett\\OneDrive - ANCOR INFORMATION MAN\\Desktop\\Selenium webdriver\\chrommedriver");
	        driver = new ChromeDriver();
	        
	        
	        // Set up the EdgeDriver path 
	        System.setProperty("webdriver.edge.driver", "C:\\Users\\dbarnett\\OneDrive - ANCOR INFORMATION MAN\\Desktop\\Selenium webdriver\\EdgeDriver");
	        driver = new EdgeDriver();
	        
	        
	        // Set up the Firefoxdriver Path 
	        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\OneDrive - ANCOR INFORMATION MAN\\Desktop\\Selenium webdriver\\Geckodriver");
	        driver = new FirefoxDriver();
	         driver.quit();
	        
	    }
	    

	    @Test
	    
	    public void AssureLogIn(){
	    	// Open Ancor Customer Portal Login 
	    	 driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");
	    	 
	    	 // Enter Valid User Name into Email Field 
	    	WebElement emailField = driver.findElement("txtUsername");
	    	emailField.sendKeys("dbarnett@ancorinfo.com");
	    	
	    	// Enter Valid Password 
	    	WebElement pwField = driver.findElement("PasswordContainer");
	    	pwField.sendKeys("@ncoR77&");
	    	
	    	// Find and Click The Login Button 
	    	WebElement loginButton = driver.findElement("LoginButtonContainer");
	    	loginButton.click();
	    	
	    	
	    	
	    	
	    	/* wait for page to load after successful login - this method is a before test method and will 
	    	 * not close current browser Secession
	    	 */
	    	
	    }
	    			//Test ID TC-1.1
	    public void testFeedbackButton() {
	        // Open the Ancor Customer Portal 
	        driver.get("http://customerportal.development.local/Home");

	        // Find and click the feedback button - bottom right of screen 
	        WebElement feedbackButton = driver.findElement(By.id("feedbackBtn"));
	        feedbackButton.click();

	        // Enter feedback message - modal text field 
	        WebElement feedbackInput = driver.findElement(By.id("feedbackNotes"));
	        feedbackInput.sendKeys("This is a test feedback message.");

	        // Submit the feedback - click submit button 
	        WebElement submitButton = driver.findElement(By.id("btnSubmitFeedback"));
	        submitButton.click();

	        // Verify the success message or any other assertions as needed
	        WebElement successMessage = driver.findElement(By.id("Modalmessage"));
	        assert successMessage.isDisplayed();
	        
 	        
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}

	
	
	

