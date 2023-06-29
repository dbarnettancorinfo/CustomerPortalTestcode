package TC;
	

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tc2_4 {
																	// Test Case 2.4 - Verify that the user is automatically logged out after a certain period of inactivity and an appropriate message is displayed.
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
            }

    @Test(priority = 1)
    public void testAutomaticLogoutOnChrome() throws InterruptedException {
    	// Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:/Users/dbarnett/Downloads/chromedriver_win32 (2)/chromedriver.exe");
        driver = new ChromeDriver();
        performAutomaticLogoutTest();
    }

    @Test(priority = 2)
    public void testAutomaticLogoutOnEdge() throws InterruptedException {
        // Set up EdgeDriver path
        System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");
        driver = new EdgeDriver();
        performAutomaticLogoutTest();
    }

    @Test(priority = 3)
    public void testAutomaticLogoutOnFirefox() throws InterruptedException {
        // Set up FirefoxDriver path
        System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\geckodriver-v0.33.0-win32\\\\geckodriver.exe");
        driver = new FirefoxDriver();
        performAutomaticLogoutTest();
    }

    private void performAutomaticLogoutTest() throws InterruptedException {
        // Open the login page
        driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");

        // Enter username and password to login
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("LoginButtonContainer"));

        // Enter username and password
        usernameField.sendKeys("dbarnett@ancorinfo.com");
        passwordField.sendKeys("Blue1people2");

        // Click on the login button
        loginButton.click();

        // Wait for 10 minutes (600,000 milliseconds) for the user to be automatically logged out
        Thread.sleep(600000);

        // Verify if the user is logged out by checking the presence of the login page elements
        WebElement loginForm = driver.findElement(By.id("LoginContainer"));
        WebElement usernameFieldAgain = driver.findElement(By.id("username"));
        WebElement passwordFieldAgain = driver.findElement(By.id("password"));

        assert loginForm.isDisplayed() : "User was not automatically logged out after 10 minutes of inactivity!";
        assert usernameFieldAgain.isDisplayed() : "Username field is not displayed on the login page!";
        assert passwordFieldAgain.isDisplayed() : "Password field is not displayed on the login page!";
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
