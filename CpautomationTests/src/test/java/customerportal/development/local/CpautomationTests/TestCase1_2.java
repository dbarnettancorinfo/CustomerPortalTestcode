package customerportal.development.local.CpautomationTests;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	
	public class TestCase1_2 {

	    private WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        // Set up ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\chromedriver_win32 (2)\\\\\\\\chromedriver.exe");

	        // Set up FirefoxDriver path
	        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\OneDrive - ANCOR INFORMATION MAN\\Desktop\\Selenium webdriver\\Geckodriver");

	        
	        // Set up EdgeDriver Path 
	        System.setProperty("webdriver.edge.driver", "C:\\Users\\dbarnett\\OneDrive - ANCOR INFORMATION MAN\\Desktop\\Selenium webdriver\\EdgeDriver");

	        // Create ChromeDriver instance
	        driver = new ChromeDriver();
	    }

	    @Test
	    
	    		//Test Case ID TC-1.2 
	    public void testLogoDisplayInChrome() {
	        verifyLogoDisplay(driver);
	    }

	    @Test
	    public void testLogoDisplayInFirefox() {
	        driver.quit();  // Quit ChromeDriver instance
	        driver = new FirefoxDriver();
	        verifyLogoDisplay(driver);
	    }

	    @Test
	    public void testLogoDisplayInEdge() {
	        driver.quit();  // Quit FirefoxDriver instance
	        driver = new EdgeDriver();
	        verifyLogoDisplay(driver);
	    }

	    private void verifyLogoDisplay(WebDriver driver) {
	        // Open the web page URL
	        driver.get("https://http://customerportal.development.local/home");

	        // Find the logo element
	        WebElement logoElement = driver.findElement(By.cssSelector("CLientLogo"));

	        // Verify if the logo element is displayed - unique image name not used by dev team 
	        Assert.assertTrue(logoElement.isDisplayed(), "Logo is displayed on the page.");

	        // Add additional assertions if required (e.g., logo size, alt text, etc.)
	        	Assert.assertFalse(logoElement.isDisplayed(), "Logo is not displayed  on the page.");
	        	
	        // Close the browser
	        driver.quit();
	    }

	    @AfterClass
	    public void tearDown() {
	        // Quit the driver and close all associated windows
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

	
	
	
	
	

