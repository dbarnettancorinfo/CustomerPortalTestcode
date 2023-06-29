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

	public class TestCase1_3 {
	    private WebDriver driver
	    	
	   
	    @BeforeClass
	    public void setUp() {
	    	// Set up FireFox driver path 
	    	System.setProperty("webdriver.gecko.driver ", "C:\\Users\\dbarnett\\OneDrive - ANCOR INFORMATION MAN\\Desktop\\Selenium webdriver\\Geckodriver");
	    
	    	// Set Up EdgeDriver  Path
	    	System.setProperty("webdriver.edge.driver", "C:\\Users\\dbarnett\\OneDrive - ANCOR INFORMATION MAN\\Desktop\\Selenium webdriver\\EdgeDriver");
	 
	        // Set up ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", ": C:\\Users\\dbarnett\\OneDrive - ANCOR INFORMATION MAN\\Desktop\\Selenium webdriver\\chromedriver");

	        // Create ChromeDriver instance
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void testCustomerLogoPosition() {
	    
	    	
	        // Open the web page URL
	        driver.get("https://www.example.com");

	        // Find the customer logo element
	        WebElement logoElement = driver.findElement(By.cssSelector(".customer-logo"));

	        // Verify if the logo is displayed
	        Assert.assertTrue(logoElement.isDisplayed(), "Customer logo is not displayed on the page.");

	        // Verify if the logo is positioned in the top left corner
	        String logoPosition = logoElement.getCssValue("position");
	        String logoTop = logoElement.getCssValue("top");
	        String logoLeft = logoElement.getCssValue("left");
	        Assert.assertEquals(logoPosition, "absolute", "Customer logo is not positioned absolutely.");
	        Assert.assertEquals(logoTop, "0px", "Customer logo is not positioned at the top.");
	        Assert.assertEquals(logoLeft, "0px", "Customer logo is not positioned at the left.");

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