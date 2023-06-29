package TC;


					
	

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	
		public class tc2_1 {
																//Test Case 2.1 - Ensure entering a User Name/Password allows you to login 
	    private WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        // Set up EdgeDriver path
	        System.setProperty("webdriver.edge.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\edgedriver_win64\\\\\\\\\\\\\\\\msedgedriver.exe");
	        // Set up FirefoxDriver path
	        System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\geckodriver-v0.33.0-win32\\\\geckodriver.exe");
	        // Set up ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\chromedriver_win32 (2)\\\\\\\\\\\\\\\\chromedriver.exe");

	       
	    
	    }

	    @Test
	    public void testLoginEdge() {
	    	
	    	 // Create EdgeDriver instance
	        driver = new EdgeDriver();
	    	
	    	 // Open Ancor Customer Portal Login
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
	        
	        // Verify if the welcome image is displayed
	        WebElement welcomeImage = driver.findElement(By.id("WelcomeImageContainer"));
	        assert welcomeImage.isDisplayed() : "Welcome image not displayed after login!";
	        
	    }
	    
	    
	    @Test
	    public void testLoginChrome(){

	    	//   instantiate chrome driver 
	    		driver = new ChromeDriver();
	    		
	    	 // Open Ancor Customer Portal Login
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
	        
	        // Verify if the welcome image is displayed
	        WebElement welcomeImage = driver.findElement(By.id("WelcomeImageContainer"));
	        assert welcomeImage.isDisplayed() : "Welcome image not displayed after login!";
	    }
	    
	    @Test
	    public void testLoginFirefox(){

	    	//   instantiate chrome driver 
	    		driver = new FirefoxDriver();
	    		
	    	 // Open Ancor Customer Portal Login
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
	        
	        // Verify if the welcome image is displayed
	        WebElement welcomeImage = driver.findElement(By.id("WelcomeImageContainer"));
	        assert welcomeImage.isDisplayed() : "Welcome image not displayed after login!";
	    }
	        
	    

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}

	

