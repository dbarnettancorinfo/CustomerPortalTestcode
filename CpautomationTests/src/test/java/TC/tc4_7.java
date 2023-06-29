package TC;

																									// Test Case 4.7 - 'when hovering over the element a line should appear under the element and the element should be highlighted with gray, a drop-down menu of all the possible product selections should also appear.
	
	
	
	
	
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
		




		
		
			
		public class tc4_7 { 
										// Test Case 4.7 - 'when hovering over the element a line should appear under the element and the element should be highlighted with gray, a drop-down menu of all the possible product selections should also appear.

			private WebDriver driver;
		@BeforeMethod
		public void setUp() {
			 
		}
			@Test (priority = 1)
	    public void testProductsElementChromne() {
				
				// Set up EdgeDriver path
		        System.setProperty("webdriver.chrome.driver", "C:/Users/dbarnett/Downloads/chromedriver_win32 (2)/chromedriver.exe");
				
				
	        // Create ChromeDriver instance
	         driver = new ChromeDriver();
	     
	     // Open Ancor Customer Portal Login
	        driver.get("http://customerportal.development.local/home/ChangeClient?clientCode=CNO");
	        
	    	// Enter Valid User Name into Email Field
	        WebElement emailField = driver.findElement(By.id("txtUsername"));
	        emailField.sendKeys("dbarnett@ancorinfo.com");

	        // Enter Valid Password
	        WebElement pwField = driver.findElement(By.id("txtPassword"));
	        pwField.sendKeys("Blue1people2");

	        // Find and Click The Login Button
	        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));
	        loginButton.click();
	        
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        
	        // Wait for the element to appear
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SiteMenu\"]/div[2]")));

	        Actions actions = new Actions(driver);
	        // Hover over the element
	        actions.moveToElement(element).perform();

	        // Hover over the element to trigger the dropdown menu
	        actions.moveToElement(element).perform();

	        // Wait for the dropdown menu to appear
	        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SiteMenu\"]/div[2]/div[2]/div[2]/div/div[2]")));

	        // Verify that the dropdown menu is displayed
	        if (dropdownMenu.isDisplayed()) {
	            System.out.println("Dropdown menu appeared after hovering over the element.");
	        } else {
	            System.out.println("Dropdown menu did not appear after hovering over the element.");
	        }
			}
				@Test (priority = 2)
			  public void testProductsElementEdge() {
					 // Set up EdgeDriver path
			        System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");
				  
			        // Create EdgeDriver instance
			         driver = new EdgeDriver();
			     
			     // Open Ancor Customer Portal Login
			        driver.get("http://customerportal.development.local/home/ChangeClient?clientCode=CNO");
			        
			    	// Enter Valid User Name into Email Field
			        WebElement emailField = driver.findElement(By.id("txtUsername"));
			        emailField.sendKeys("dbarnett@ancorinfo.com");

			        // Enter Valid Password
			        WebElement pwField = driver.findElement(By.id("txtPassword"));
			        pwField.sendKeys("Blue1people2");

			        // Find and Click The Login Button
			        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));
			        loginButton.click();
			        
			        WebDriverWait wait = new WebDriverWait(driver, 10);
			        
			        // Wait for the element to appear
			        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SiteMenu\"]/div[2]")));

			        Actions actions = new Actions(driver);
			        // Hover over the element
			        actions.moveToElement(element).perform();

			        // Hover over the element to trigger the dropdown menu
			        actions.moveToElement(element).perform();

			        // Wait for the dropdown menu to appear
			        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SiteMenu\"]/div[2]/div[2]/div[2]/div/div[2]")));

			        // Verify that the dropdown menu is displayed
			        if (dropdownMenu.isDisplayed()) {
			            System.out.println("Dropdown menu appeared after hovering over the element.");
			        } else {
			            System.out.println("Dropdown menu did not appear after hovering over the element.");
			        }
					}
			  
			  @Test (priority = 3)
			  
			  public void testProductsElementFirefox() {
				// Set up FirefoxDriver path
			        System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\geckodriver-v0.33.0-win32\\\\geckodriver.exe");
				  
			        // Create FirefoxDriver instance
			         driver = new FirefoxDriver();
			     
			     // Open Ancor Customer Portal Login
			        driver.get("http://customerportal.development.local/home/ChangeClient?clientCode=CNO");
			        
			    	// Enter Valid User Name into Email Field
			        WebElement emailField = driver.findElement(By.id("txtUsername"));
			        emailField.sendKeys("dbarnett@ancorinfo.com");

			        // Enter Valid Password
			        WebElement pwField = driver.findElement(By.id("txtPassword"));
			        pwField.sendKeys("Blue1people2");

			        // Find and Click The Login Button
			        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));
			        loginButton.click();
			        
			        WebDriverWait wait = new WebDriverWait(driver, 10);
			        
			        // Wait for the element to appear
			        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SiteMenu\"]/div[2]")));

			        Actions actions = new Actions(driver);
			        // Hover over the element
			        actions.moveToElement(element).perform();

			        // Hover over the element to trigger the dropdown menu
			        actions.moveToElement(element).perform();

			        // Wait for the dropdown menu to appear
			        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SiteMenu\"]/div[2]/div[2]/div[2]/div/div[2]")));

			        // Verify that the dropdown menu is displayed
			        if (dropdownMenu.isDisplayed()) {
			            System.out.println("Dropdown menu appeared after hovering over the element.");
			        } else {
			            System.out.println("Dropdown menu did not appear after hovering over the element.");
			        }
					}
					
					
			
			
			
			
			public void logIn() {
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
		    }
			
		    @AfterMethod
		  public void tearDown(){
		    	  // Close the browser
		        driver.quit();
		    
		    }

	      
		    }
	


