package TC;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;


		public class tc1_1 {
			
			
	    private WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        // Set up EdgeDriver path
	        System.setProperty("webdriver.edge.driver", "C:\\Users\\dbarnett\\Downloads\\edgedriver_win64\\\\msedgedriver.exe");
	        // Set up FirefoxDriver path
	        System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\geckodriver-v0.33.0-win32\\\\geckodriver.exe");
	        // Set up ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\chromedriver_win32 (2)\\\\chromedriver.exe");

	       
	        
	        
	        
	    }

	    @Test (priority = 1 )
	    public void testFeedbackSubmissionInEdge() {
	    	
	    	//Declare web Edge Web browser
	        driver = new EdgeDriver();

	    	
	        // Open a webpage
	        driver.get("http://customerportal.development.local/home");

	        // Find and click the feedback button right corner 
	        WebElement feedbackButton = driver.findElement(By.id("feedbackBtn"));
	        feedbackButton.click();

	        // Fill in the feedback form
	        WebElement feedbackField = driver.findElement(By.id("feedbackNotes"));
	        feedbackField.sendKeys("This is my feedback message test.");

	        // Submit the feedback
	        WebElement submitButton = driver.findElement(By.id("btnSubmitFeedback"));
	        submitButton.click();
	    }
	    
	    @Test ( priority = 2 )
	    public void testFeedbackSubmissionInChrome() {
	    	
	    	//Declare Chrome Web browser 
	        driver = new ChromeDriver();

	    	 // Open a webpage
	        driver.get("http://customerportal.development.local/home");

	        // Find and click the feedback button right corner 
	        WebElement feedbackButton = driver.findElement(By.id("feedbackBtn"));
	        feedbackButton.click();

	        // Fill in the feedback form
	        WebElement feedbackField = driver.findElement(By.id("feedbackNotes"));
	        feedbackField.sendKeys("This is my feedback message test.");

	        // Submit the feedback
	        WebElement submitButton = driver.findElement(By.id("btnSubmitFeedback"));
	        submitButton.click();
	    }

	    @Test (priority = 3)
	     public void testFeedbackSubmissionInFirefox() {
	    	
	    	
	    	// Declare Firefox Webrowser 
	    	 driver = new FirefoxDriver();	
	    	
	    	 // Open a webpage
	        driver.get("http://customerportal.development.local/home");

	        // Find and click the feedback button right corner 
	        WebElement feedbackButton = driver.findElement(By.id("feedbackBtn"));
	        feedbackButton.click();

	        // Fill in the feedback form
	        WebElement feedbackField = driver.findElement(By.id("feedbackNotes"));
	        feedbackField.sendKeys("This is my feedback message test.");

	        // Submit the feedback
	        WebElement submitButton = driver.findElement(By.id("btnSubmitFeedback"));
	        submitButton.click();
	    }
	    
	   
	    
	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}


