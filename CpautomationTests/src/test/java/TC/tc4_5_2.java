package TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class tc4_5_2 {
																									// Test Case 4.5.2 - Clicking on the view report pdf if available will open a vin report.
																									// Write a test script that check if the status report page has text on the page that says "View Report"  if it doesnt stop the test and print tpop the console no files avalible and assert a test failure after checking the following url links first " http://customerportal.development.local/home/ChangeClient?clientCode=VOL , http://customerportal.development.local/home/ChangeClient?clientCode=VFA ,http://customerportal.development.local/home/ChangeClient?clientCode=LMC , http://customerportal.development.local/home/ChangeClient?clientCode=FCA , http://customerportal.development.local//home/ChangeClient?clientCode=FFM , http://customerportal.development.local/home/ChangeClient?clientCode=CNO ". if avalible click the web element by the name of " View Report PDF" 

					public WebDriver driver;

				            @BeforeMethod
				            public void setUp() {
				                System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\dbarnett\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver_win32 (2)\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\chromedriver.exe");
				                System.setProperty("webdriver.gecko.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\geckodriver-v0.33.0-win32\\\\\\\\geckodriver.exe");
				                System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");
				            }
				                @Test(priority = 1)
				                public void testStatusReportPageOnChrome() {
				                    driver = new ChromeDriver();
				                    logIn();
				                    executeStatusReportPageTest();
				                }

				                @Test(priority = 2)
				                public void testStatusReportPageOnEdge() {
				                    driver = new EdgeDriver();
				                    logIn();
				                    executeStatusReportPageTest();
				                }

				                @Test(priority = 3)
				                public void testStatusReportPageOnFirefox() {
				                    driver = new FirefoxDriver();
				                    logIn();
				                    executeStatusReportPageTest();
				                }

				                private void executeStatusReportPageTest() {
				                    String[] urls = {
				                            "http://customerportal.development.local/home/ChangeClient?clientCode=VFA",
				                            "http://customerportal.development.local/home/ChangeClient?clientCode=VOL",
				                            "http://customerportal.development.local/home/ChangeClient?clientCode=LMC",
				                            "http://customerportal.development.local/home/ChangeClient?clientCode=FCA",
				                            "http://customerportal.development.local/home/ChangeClient?clientCode=FFM",
				                            "http://customerportal.development.local/home/ChangeClient?clientCode=CNO"
				                    };

				                    for (String url : urls) {
				                        driver.get(url);

				                        WebDriverWait wait = new WebDriverWait(driver, 10);

				                        boolean viewReportElement = driver.getPageSource().contains("Current Status");
				                        if (viewReportElement = true) {
				                            System.out.println("View Report element found on page.");
				                            WebElement viewReportPDFElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"processTrackingTable\"]/tbody/tr[1]/td[3]/a/i")));
				                            viewReportPDFElement.click();
				                            System.out.println( "Clicked on View Report PDF.");
				                          
				                            
				                        } else {
				                            System.out.println("No files available on the page.");
				                            Assert.fail("Test failed: No files available.");
				                        }
				                    }
				                }
				                public void logIn() {
				                	// Open Ancor Customer Portal Login
				        	        driver.get("http://customerportal.development.local/home/ChangeClient?clientCode=VFA");
				        	        
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


				          