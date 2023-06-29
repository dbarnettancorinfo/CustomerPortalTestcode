package customerportal.development.local.CpautomationTests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;



public class SetCustomer {
							
			
				
					 					
					     private WebDriver driver;

					     @BeforeClass
					     public void setUp() {
					         // Set up ChromeDriver path
					         System.setProperty("webdriver.chrome.driver", "C:/Users/dbarnett/Downloads/chromedriver_win32 (2)/chromedriver.exe");

					         // Set up EdgeDriver path
					         System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");

					         // Set up FirefoxDriver path
					         System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\OneDrive - ANCOR INFORMATION MAN\\Desktop\\Selenium webdriver\\Geckodriver.exe");
					     }

					     @Test
					     public void testDropdownSubMenuInChrome() {
					         driver = new ChromeDriver();
					         logIn();
					         getFordMotorCompany();					         
					         }

					     @Test
					     public void testDropdownSubMenuInEdge() {
					         driver = new EdgeDriver();
					         logIn();
					         getFordMotorCompany();					         
					     }

					     @Test
					     public void testDropdownSubMenuInFirefox() {
					         driver = new FirefoxDriver();
					         getcanoo();
					     }

					     public void getcanoo() {

					         // Find the "ClientList" element
					         WebElement ClientListElement = driver.findElement(By.id("ClientList"));

					         // Create an Actions object
					         Actions actions = new Actions(driver);                      

					         // Hover over the "Customer" element
					         actions.moveToElement(ClientListElement).perform();

					         // Find the dropdown button element
					         WebElement dropdownButton = driver.findElement(By.id("Canoo"));

					         // Click on the dropdown button to open the Customer Menu - CANOO 
					         actions.moveToElement(dropdownButton).click().perform();

					         // Find and click on the submenu -"Canoo" element
					         WebElement submenuElement = driver.findElement(By.id("Canoo"));
					         submenuElement.click();

					         // Add assertions or further actions if required based on the expected behavior

					        
					     }
					     
					     public void getVolvo() {
					        
					    	 // Use method Only log in session is current 
					         // Find the "ClientList" element
					         WebElement ClientListElement = driver.findElement(By.id("ClientList"));

					         // Create an Actions object
					         Actions actions = new Actions(driver);                      

					         // Hover over the "Customer" element
					         actions.moveToElement(ClientListElement).perform();
					         	WebDriverWait wait = new WebDriverWait(driver,10);
						        WebElement webviewLoadsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ClientList\"]/div/div[2]/div[3]/div/div/ul/li[8]")));

					         // Click on the dropdown button to open the Customer Menu - Volvo Cars 
					         actions.moveToElement(webviewLoadsLink);

					         // Find and click on the submenu -"Volvo Cars" element
					         webviewLoadsLink.click();

					     }
					     // Faraday Future Client Dash Board  - Customer Portal 
					     public void getFaradayFuture() {
					         

					         // Find the "ClientList" element
					         WebElement ClientListElement = driver.findElement(By.id("ClientList"));

					         // Create an Actions object
					         Actions actions = new Actions(driver);                      

					         // Hover over the "Customer" element
					         actions.moveToElement(ClientListElement).perform();
					         WebDriverWait wait = new WebDriverWait(driver,10);
						        WebElement webviewLoadsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ClientList\"]/div/div[2]/div[3]/div/div/ul/li[2]")));

					       

					         // Click on the dropdown button to open the Customer Menu - Faraday Future 
					         actions.moveToElement(webviewLoadsLink);

					         // Find and click on the submenu -"Faraday Future" element
					       
					         webviewLoadsLink.click();

					     }
					     
					     public void getStellantis() {
					         // Open the web page URL
					         driver.get("https://customerportal.ancorinfo.com/Home");

					         // Find the "ClientList" element
					         WebElement ClientListElement = driver.findElement(By.id("ClientList"));

					         // Create an Actions object
					         Actions actions = new Actions(driver);                      

					         // Hover over the "Customer" element
					         actions.moveToElement(ClientListElement).perform();

					         // Find the dropdown button element
					         WebElement dropdownButton = driver.findElement(By.id("Stellantis"));

					         // Click on the dropdown button to open the Customer Menu - Stellantis
					         actions.moveToElement(dropdownButton).click().perform();

					         // Find and click on the submenu -"Stellantis" element
					         WebElement submenuElement = driver.findElement(By.id("Stellantis"));
					         submenuElement.click();
					     }

					     
					     
					     public void getFordMotorCompany() {
					         

					         // Find the "ClientList" element
					         WebElement ClientListElement = driver.findElement(By.id("ClientList"));

					         // Create an Actions object
					         Actions actions = new Actions(driver);                      

					         // Hover over the "Customer" element
					         actions.moveToElement(ClientListElement).perform();

					         // Find the dropdown button element
					         WebDriverWait wait = new WebDriverWait(driver,10);
						     WebElement webviewLoadsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ClientList\"]/div/div[2]/div[3]/div/div/ul/li[4]")));

					         // Click on the dropdown button to open the Customer Menu - Ford Motor Company 
					         actions.moveToElement(webviewLoadsLink);

					         
					         webviewLoadsLink.click();
					     }
					     
					     
					     public void getLordsTownMotors() {
					         // Open the web page URL
					         driver.get("https://customerportal.ancorinfo.com/Home");

					         // Find the "ClientList" element
					         WebElement ClientListElement = driver.findElement(By.id("ClientList"));

					         // Create an Actions object
					         Actions actions = new Actions(driver);                      

					         // Hover over the "Customer" element
					         actions.moveToElement(ClientListElement).perform();

					         // Find the dropdown button element
					         WebElement dropdownButton = driver.findElement(By.id("Lordstown Motors"));

					         // Click on the dropdown button to open the Customer Menu - Lords Town Motors
					         actions.moveToElement(dropdownButton).click().perform();

					         // Find and click on the submenu -"Lords Town Motors" element
					         WebElement submenuElement = driver.findElement(By.id("Lordstown Motors"));
					         submenuElement.click();
					     }
					     
					     

					     public void getPolestarPerfrormance() {
					         // Open the web page URL
					         driver.get("https://customerportal.ancorinfo.com/Home");

					         // Find the "ClientList" element
					         WebElement ClientListElement = driver.findElement(By.id("ClientList"));

					         // Create an Actions object
					         Actions actions = new Actions(driver);                      

					         // Hover over the "Customer" element
					         actions.moveToElement(ClientListElement).perform();

					         // Find the dropdown button element
					         WebElement dropdownButton = driver.findElement(By.id("Polestar Performance AB"));

					         // Click on the dropdown button to open the Customer Menu - Polestar Performance 
					         actions.moveToElement(dropdownButton).click().perform();

					         // Find and click on the submenu -"Pole Star Performance AB" element
					         WebElement submenuElement = driver.findElement(By.id("Polestar Performance AB"));
					         submenuElement.click();
					     }
					     
					     public void getVinfast() {
					         // Open the web page URL
					         driver.get("https://customerportal.ancorinfo.com/Home");

					         // Find the "ClientList" element
					         WebElement ClientListElement = driver.findElement(By.id("ClientList"));

					         // Create an Actions object
					         Actions actions = new Actions(driver);                      

					         // Hover over the "Customer" element
					         actions.moveToElement(ClientListElement).perform();

					         // Find the dropdown button element
					         WebElement dropdownButton = driver.findElement(By.id("VinFast Automotive"));

					         // Click on the dropdown button to open the Customer Menu - VinFast Automotive  
					         actions.moveToElement(dropdownButton).click().perform();

					         // Find and click on the submenu -"VinFast Automotive" element
					         WebElement submenuElement = driver.findElement(By.id("VinFast Automotive"));
					         submenuElement.click();
					     }
					     
					     
					     public void logIn() {
						    	// Open Ancor Customer Portal Login
						        driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");
						        
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
					     
					     @AfterClass
					     public void tearDown() {
					         // Quit the driver and close all associated windows
					         if (driver != null) {
					             driver.quit();
					         }
					     }
					 
				
				
			}

