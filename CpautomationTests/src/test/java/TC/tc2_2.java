package TC;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;


	public class tc2_2 {
																		//Test Case 2.2 -  Verify login Case Sensitivity 

	    private WebDriver driver;

	    @BeforeTest
	    public void setUp() {
	        // Set up EdgeDriver path
	        System.setProperty("webdriver.edge.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\edgedriver_win64\\\\\\\\\\\\\\\\msedgedriver.exe");
	        // Set up FirefoxDriver path
	        System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\geckodriver-v0.33.0-win32\\\\geckodriver.exe");
	        // Set up ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\chromedriver_win32 (2)\\\\\\\\\\\\\\\\chromedriver.exe");


	    }

	    @Test(priority = 1)
	    public void testLoginCaseSensitiveEdge() {
	        driver = new EdgeDriver();

	        // Open the login page
	        driver.get("http://customerportal.development.local/home/ChangeClient?clientCode=FMC");
	         
	        // Enter Valid User Name into Email Field
	        WebElement emailField = driver.findElement(By.id("txtUsername"));
	        emailField.sendKeys("dbarnett@ancorinfo.com");

	        // Enter Password in lower case Actual should be a capital "B"
	        WebElement pwField = driver.findElement(By.id("txtPassword"));
	        pwField.sendKeys("blue1people2");

	        // Find and Click The Login Button
	        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));
	        loginButton.click();
	        
	        //Expected Text Error - "Your information doesn't match our records. Please try again."
	        String exp = "Your information doesn't match our records. Please try again.";
	        
	        // Get the page source as a string
	        String pageSource = driver.getPageSource();
	        
	        // Search for error text on the display 
	        String searchText = "Your information doesn't match our records. Please try again.";
	        
	        // Verify that the expected text is present on screen after entering lower case characters
	        if (pageSource.contains(searchText)) {
	        	System.out.println("Text found on page");
	        } else {
	        	System.out.println("Text not found on page");
	        }
	       
	        // Redefine element fields for secondary function 
	        WebElement emailField1 = driver.findElement(By.id("txtUsername"));
	        WebElement pwField1 = driver.findElement(By.id("txtPassword"));

	       // Clear Text fields for Username and password 
	        emailField1.clear();
	        pwField1.clear();
	       
	        // Enter Valid User Name into Email Field
	        emailField = driver.findElement(By.id("txtUsername"));
	        emailField.sendKeys("dbarnett@ancorinfo.com");

	        
	        // Enter Valid Password
	         pwField = driver.findElement(By.id("txtPassword"));
	        pwField.sendKeys("Blue1people2");

	        // Find and Click The Login Button
	         loginButton = driver.findElement(By.id("LoginButtonContainer"));
	        loginButton.click();
	        
	     // Set the maximum wait time in seconds
	        int waitTimeInSeconds = 120;
	        
	     // Create an explicit wait with the specified wait time
	        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
	        

	        // Wait until the image element with the specified src attribute is visible
	        WebElement welcomeImage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector("img[src='/Images/welcomeimage.jpg']")));

	        // Perform any desired actions with the image element
	        if (welcomeImage.isDisplayed()) {
	            System.out.println("Image is displayed on the page!");
	        } else {
	            System.out.println("Image is not displayed on the page.");
	        }

	        
	     // Verify if the welcome image is displayed
	        WebElement welcomeImage1 = driver.findElement(By.cssSelector("img[src='/Images/welcomeimage.jpg']"));
	        assert welcomeImage1.isDisplayed() : "Welcome image displayed after login!";
	    }
	      
	    
	    
	    @Test(priority = 2)
	    public void testLoginCaseSensitiveChrome() {
	    									//Test Case 2.2 Verify login Case Sensitivity 
	    	driver = new ChromeDriver();
	    	 // Open the login page
	        driver.get("http://customerportal.development.local/home/ChangeClient?clientCode=FMC");
	         
	        // Enter Valid User Name into Email Field
	        WebElement emailField = driver.findElement(By.id("txtUsername"));
	        emailField.sendKeys("dbarnett@ancorinfo.com");

	        // Enter Password in lower case Actual should be a capital "B"
	        WebElement pwField = driver.findElement(By.id("txtPassword"));
	        pwField.sendKeys("blue1people2");

	        // Find and Click The Login Button
	        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));
	        loginButton.click();
	        
	        //Expected Text Error - "Your information doesn't match our records. Please try again."
	        String exp = "Your information doesn't match our records. Please try again.";
	        
	        // Get the page source as a string
	        String pageSource = driver.getPageSource();
	        
	        // Search for error text on the display 
	        String searchText = "Your information doesn't match our records. Please try again.";
	        
	        // Verify that the expected text is present on screen after entering lower case characters
	        if (pageSource.contains(searchText)) {
	        	System.out.println("Text found on page");
	        } else {
	        	System.out.println("Text not found on page");
	        }
	       
	        // Redefine element fields for secondary function 
	        WebElement emailField1 = driver.findElement(By.id("txtUsername"));
	        WebElement pwField1 = driver.findElement(By.id("txtPassword"));

	       // Clear Text fields for Username and password 
	        emailField1.clear();
	        pwField1.clear();
	       
	        // Enter Valid User Name into Email Field
	        emailField = driver.findElement(By.id("txtUsername"));
	        emailField.sendKeys("dbarnett@ancorinfo.com");

	        
	        // Enter Valid Password
	         pwField = driver.findElement(By.id("txtPassword"));
	        pwField.sendKeys("Blue1people2");

	        // Find and Click The Login Button
	         loginButton = driver.findElement(By.id("LoginButtonContainer"));
	        loginButton.click();
	        
	     // Set the maximum wait time in seconds
	        int waitTimeInSeconds = 120;
	        
	     // Create an explicit wait with the specified wait time
	        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
	        

	        // Wait until the image element with the specified src attribute is visible
	        WebElement welcomeImage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector("img[src='/Images/welcomeimage.jpg']")));

	        // Perform any desired actions with the image element
	        if (welcomeImage.isDisplayed()) {
	            System.out.println("Image is displayed on the page!");
	        } else {
	            System.out.println("Image is not displayed on the page.");
	        }

	        
	     // Verify if the welcome image is displayed
	        WebElement welcomeImage1 = driver.findElement(By.cssSelector("img[src='/Images/welcomeimage.jpg']"));
	        assert welcomeImage1.isDisplayed() : "Welcome image displayed after login!";
	        
	    }
	    
	    
	    @Test(priority =3)
	    public void testLoginCaseSensitiveFireox() {
	    									//Test Case 2.2 Verify login Case Sensitivity 
	    	driver = new FirefoxDriver();
	    	 // Open the login page
	        driver.get("http://customerportal.development.local/home/ChangeClient?clientCode=FMC");
	         
	        // Enter Valid User Name into Email Field
	        WebElement emailField = driver.findElement(By.id("txtUsername"));
	        emailField.sendKeys("dbarnett@ancorinfo.com");

	        // Enter Password in lower case Actual should be a capital "B"
	        WebElement pwField = driver.findElement(By.id("txtPassword"));
	        pwField.sendKeys("blue1people2");

	        // Find and Click The Login Button
	        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));
	        loginButton.click();
	        
	        //Expected Text Error - "Your information doesn't match our records. Please try again."
	        String exp = "Your information doesn't match our records. Please try again.";
	        
	        // Get the page source as a string
	        String pageSource = driver.getPageSource();
	        
	        // Search for error text on the display 
	        String searchText = "Your information doesn't match our records. Please try again.";
	        
	        // Verify that the expected text is present on screen after entering lower case characters
	        if (pageSource.contains(searchText)) {
	        	System.out.println("Text found on page");
	        } else {
	        	System.out.println("Text not found on page");
	        }
	       
	        // Redefine element fields for secondary function 
	        WebElement emailField1 = driver.findElement(By.id("txtUsername"));
	        WebElement pwField1 = driver.findElement(By.id("txtPassword"));

	       // Clear Text fields for Username and password 
	        emailField1.clear();
	        pwField1.clear();
	       
	        // Enter Valid User Name into Email Field
	        emailField = driver.findElement(By.id("txtUsername"));
	        emailField.sendKeys("dbarnett@ancorinfo.com");

	        
	        // Enter Valid Password
	         pwField = driver.findElement(By.id("txtPassword"));
	        pwField.sendKeys("Blue1people2");

	        // Find and Click The Login Button
	         loginButton = driver.findElement(By.id("LoginButtonContainer"));
	        loginButton.click();
	        
	     // Set the maximum wait time in seconds
	        int waitTimeInSeconds = 120;
	        
	     // Create an explicit wait with the specified wait time
	        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
	        

	        // Wait until the image element with the specified src attribute is visible
	        WebElement welcomeImage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector("img[src='/Images/welcomeimage.jpg']")));

	        // Check if welcome image is displayed ; Print to Console 
	        if (welcomeImage.isDisplayed()) {
	            System.out.println("Image is displayed on the page!");
	        } else {
	            System.out.println("Image is not displayed on the page.");
	        }

	        
	     // Verify if the welcome image is displayed
	        WebElement welcomeImage1 = driver.findElement(By.cssSelector("img[src='/Images/welcomeimage.jpg']"));
	        assert welcomeImage1.isDisplayed() : "Welcome image displayed after login!";
	    }
	    		
	    

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}

	
	
	
	
	

