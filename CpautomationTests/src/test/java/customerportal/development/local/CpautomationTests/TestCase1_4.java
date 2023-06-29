package customerportal.development.local.CpautomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1_4 {

    public static void main(String[] args) {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dbarnett\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        
     // Set up FirefoxDriver path
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\Downloads\\geckodriver-v0.33.0-win32\\\\geckodriver.exe");
        
        
     // Set up EdgeDriver path
        System.setProperty("webdriver.edge.driver", "C:\\Users\\dbarnett\\Downloads\\edgedriver_win64\\\\msedgedriver.exe");

        // Create FirefoxDriver instance
        FirefoxDriver driver = new FirefoxDriver();	
        
        

        // Open Ancor Customer Portal Login
        driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");
        
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
        String exp = "Your information doesn't match our records. Please try again.\r\n"
        		+ "";
        
        // Verify if the login error message is displayed Should display - "Your information doesn't match our records. Please try again."
        WebElement errorMessage = driver.findElement(By.className("Your information doesn't match our records. Please try again."));
        assert errorMessage.isDisplayed() : "Login error message not displayed for case-sensitive login attempt!";
        
        
        // pulling the error message if any from the bowser to be display in IDE console 
        String act = errorMessage.getText();
        System.out.println("Error Message is: " + act);
        
        
        //Verify message with assertion
        Assert.assertEquals(exp, act);
        
        // Enter Valid User Name into Email Field
        emailField = driver.findElement(By.id("txtUsername"));
        emailField.sendKeys("dbarnett@ancorinfo.com");

        
        // Enter Valid Password
         pwField = driver.findElement(By.id("txtPassword"));
        pwField.sendKeys("Blue1people2");

        // Find and Click The Login Button
         loginButton = driver.findElement(By.id("LoginButtonContainer"));
        loginButton.click();
        
     // Verify if the welcome image is displayed
        WebElement welcomeImage = driver.findElement(By.id("WelcomeImageContainer"));
        assert welcomeImage.isDisplayed() : "Welcome image displayed after login!";
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        


    }
	    @AfterMethod
	    public void tearDown() {
	        EdgeDriver driver = new EdgeDriver();	
			// Close the browser
	        driver.quit();
	    }

	   
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        
        

        
    }




