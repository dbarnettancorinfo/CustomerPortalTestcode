package TC;


																			// Test Case 4.3.2 - Date filters allow you to select different date ranges, upon selecting a new date range the chart resets for the values in that range
	
	
	
	
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class tc4_3_2 {

	    private WebDriver driver;
	    private WebDriverWait wait;
	 

	    @Test
	    public void testDropdownSelection() {
	    	 System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");
	            driver = new EdgeDriver();
	            	    	
	        // Navigate to the URL
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


	        // Find the dropdown element and select an option
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlMetricsDateRange")));
	        // Click Date Changer 
	        dropdown.click();
	        
	        // Select the :Next week Selector
	        WebElement lastWeek = driver.findElement(By.xpath("//*[@id=\"ddlMetricsDateRange\"]/option[1]"));
	        lastWeek.click();
	        
	        // Wait for the information element to be updated
	        WebElement infoElement = driver.findElement(By.id("metricsTotalString"));
	        String updatedInfo = infoElement.getText();
	        
	        // Perform assertion to check if the information is updated correctly
	        String expectedInfo = "63 labels created in this period COV: 9TRDA: 9VECI: 9VINPLATE: 9BATTERY: 9CERT: 9RETAIL: 9"; 
	        Assert.assertEquals(updatedInfo, expectedInfo, "Information is not updated correctly");

	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}


