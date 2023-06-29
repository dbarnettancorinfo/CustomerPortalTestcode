package TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class tc5_3 {
								/* Test Case 5.3 -User gets a warning if searching with no parameters selected/entered Once pressed the vin list table will be created based on any and all search parameters entered. */
							
							WebDriver driver;
							WebDriverWait wait;
	
							@Test (priority = 1 )
							public void emeptyVinSearchtestChrome () {
								// Set Driver path 
								System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\chromedriver_win32 (2)\\\\\\\\chromedriver.exe");
								
								// Create browser object 
								driver = new ChromeDriver();
								
								// Log into the customer portal 
								logIn();
								
								// Run test - Check test for Logic 
								emptyVinSearchTest();							
								}
							
							@Test (priority = 2 )
							public void emeptyVinSearchTestEdge() {
								// Set Driver path 
								System.setProperty("webdriver.edge.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\edgedriver_win64\\\\\\\\msedgedriver.exe");
								
								// Create browser object 
								driver = new EdgeDriver();
								
								// Log into the customer portal 
								logIn();
								
								// Run test - Check test for Logic 
								emptyVinSearchTest();							
								}
							
							@Test (priority = 3 )
							public void emptyVinSearchTestFirefox() {
								// Set Driver path 
								System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\geckodriver-v0.33.0-win32\\\\\\\\geckodriver.exe");
								
								// Creat browser object 
								driver = new FirefoxDriver();
								
								// Log into customer portal 
								logIn();
								
								// Run test - check test for logic 
								emptyVinSearchTest();
							}
						
							public void emptyVinSearchTest() {
								 wait = new WebDriverWait(driver, 10);
								 
								 
									//find Vin search button 
									WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SearchTab btnSearchTop\"]")));
									// Click  VIN Search button 
									searchButton.click();
									
									// Assure that the "Must Enter At Least One VIN" error message pops up  
									WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ModalMessageContent")));
									
									// assert that the error message is displayed on the screen
									assert errorMessage.isDisplayed();	
									
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
				public void tearDown() {
					driver.quit();
				}
				

				
}
