package TC;

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

public class tc4_4 {
					
																		// Test Case 4.4 - 'when hovering over the widget a shadow appear within the box indicating it as a selector.(Metric and Reports)
	
	
	
	
	private WebDriverWait wait;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	   // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:/Users/dbarnett/Downloads/chromedriver_win32 (2)/chromedriver.exe");
        // Set up FirefoxDriver path
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");
        // Set up EdgeDriver path
        System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");

    }

    @Test (priority = 1)
    public void testWidgetHoverEffectChrome() {
    	// Create Chrome Driver Object 
    	driver = new ChromeDriver();
    	
        // Log into customer portal - Start from the initial URL
    	logIn();
       
    	// Wait object for Web Browser drivers use 
        wait = new WebDriverWait(driver, 10); 
        
        // Wait until the widget is visible
        WebElement widget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("REPORTS_LINK_WIDGET")));

        // Hover over the widget
        Actions actions = new Actions(driver);
        actions.moveToElement(widget).perform();

        // Verify if the shadow appears within the box
        String shadowStyle = widget.getCssValue("box-shadow");
        assert !shadowStyle.isEmpty() : "Shadow effect is not applied to the widget.";

        // Repeat the same steps for the remaining URLs
        String[] clientCodes = {"CNO", "VFA", "LMC"};
        for (String clientCode : clientCodes) {
            navigateToUrl("http://customerportal.development.local/home/ChangeClient?clientCode=" + clientCode);

            widget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("REPORTS_LINK_WIDGET")));
            actions.moveToElement(widget).perform();

            shadowStyle = widget.getCssValue("box-shadow");
            assert !shadowStyle.isEmpty() : "Shadow effect is not applied to the widget.";
            
        }
    }
    @Test (priority = 2)
    public void testWidgetHoverEffectEdge() {
    	// Create Edge Driver Object 
    	driver = new EdgeDriver();
    	
        // Log into customer portal - Start from the initial URL
    	logIn();
       
    	// Wait object for Web Browser drivers use 
        wait = new WebDriverWait(driver, 10); 
        
        // Wait until the widget is visible
        WebElement widget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("REPORTS_LINK_WIDGET")));

        // Hover over the widget
        Actions actions = new Actions(driver);
        actions.moveToElement(widget).perform();

        // Verify if the shadow appears within the box
        String shadowStyle = widget.getCssValue("box-shadow");
        assert !shadowStyle.isEmpty() : "Shadow effect is not applied to the widget.";

        // Repeat the same steps for the remaining URLs
        String[] clientCodes = {"CNO", "VFA", "LMC"};
        for (String clientCode : clientCodes) {
            navigateToUrl("http://customerportal.development.local/home/ChangeClient?clientCode=" + clientCode);

            widget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("REPORTS_LINK_WIDGET")));
            actions.moveToElement(widget).perform();

            shadowStyle = widget.getCssValue("box-shadow");
            assert !shadowStyle.isEmpty() : "Shadow effect is not applied to the widget.";
        }
    }
    
    @Test (priority = 3)
    public void testWidgetHoverEffectFirefox() {
    	// Log into customer portal 
    	// Create Firefox Driver Object 
    	driver = new FirefoxDriver();
    	
        // Log into customer portal - Start from the initial URL
    	logIn();
       
    	// Wait object for Web Browser drivers use 
        wait = new WebDriverWait(driver, 10); 
        
        // Wait until the widget is visible
        WebElement widget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("REPORTS_LINK_WIDGET")));

        // Hover over the widget
        Actions actions = new Actions(driver);
        actions.moveToElement(widget).perform();

        // Verify if the shadow appears within the box
        String shadowStyle = widget.getCssValue("box-shadow");
        assert !shadowStyle.isEmpty() : "Shadow effect is not applied to the widget.";

        // Repeat the same steps for the remaining URLs
        String[] clientCodes = {"CNO", "VFA", "LMC"};
        for (String clientCode : clientCodes) {
            navigateToUrl("http://customerportal.development.local/home/ChangeClient?clientCode=" + clientCode);

            widget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("REPORTS_LINK_WIDGET")));
            actions.moveToElement(widget).perform();

            shadowStyle = widget.getCssValue("box-shadow");
            assert !shadowStyle.isEmpty() : "Shadow effect is not applied to the widget.";
        }
    }


    public void logIn() {
    	// Open Ancor Customer Portal Login
        driver.get("http://customerportal.development.local//home/ChangeClient?clientCode=FFM");
        
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
    
    private void navigateToUrl(String url) {
        driver.navigate().to(url);
    }
    
    
    @AfterMethod
    public void tearDown() {
        // Quit the driver
        driver.quit();
    }
}

