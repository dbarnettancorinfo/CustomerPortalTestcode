package TC;

		
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
	


					public class tc1_3_1 {
																											// Test Case 1.3.1 -  Ensure  all sub-menu links direct to correct page. 

	    		    private WebDriver driver;

	    		    @BeforeMethod
	    		    public void setUp() {
	    		        // Set up ChromeDriver path
	    		        System.setProperty("webdriver.chrome.driver", "C:/Users/dbarnett/Downloads/chromedriver_win32 (2)/chromedriver.exe");
	    		        // Set up EdgeDriver path
	    		        System.setProperty("webdriver.edge.driver", "C:/Users/dbarnett/Downloads/edgedriver_win64/msedgedriver.exe");
	    		        // Set up FirefoxDriver path
	    		        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbarnett\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");


	    		    }
	    		    
	    		    
	    		    
	    		    
	    		    
	    		    @Test (priority =1 )
	    		    public void subLinktestChrome() {
	    		    	// Create Browser instance 
	    		    	driver = new ChromeDriver();
	    		    	
	    		    	// Run first sub link test - Products 
	    		    	testProductNavigation();
	    		    	
	    		    	// Run second sub link test - Reports 
	    		    	testReportsNavigation();
	    		    	
	    		    	// Run thir sub link test 
	    		    	testAdminNavigation();
	    		    	
	    		    }
	    		    @Test(priority =1)
	    		    public void subLinktestEdge() {
	    		    	// Create Edge instance 
	    		    	driver = new EdgeDriver();
	    		    	
	    		    	// Run first sub link test - Products 
	    		    	testProductNavigation();
	    		    	
	    		    	// Run second sub link test - Reports 
	    		    	testReportsNavigation();
	    		    	
	    		    	// Run thir sub link test 
	    		    	testAdminNavigation();
	    		    
	    		    }
	    		    @Test (priority =1 )
	    		    public void subLinktestFirefox() {
	    		    	// Create Firefox instance 
	    		    	driver = new FirefoxDriver();
	    		    	
	    		    	// Run first sub link test - Products 
	    		    	testProductNavigation();
	    		    	
	    		    	// Run second sub link test - Reports 
	    		    	testReportsNavigation();
	    		    	
	    		    	// Run thir sub link test 
	    		    	testAdminNavigation();
	    		    }
	    		    public void testProductNavigation() {
	    		    	
	    		    	
	    		    	
	    		       // Log into customer portal 
	    		    	logIn();

	    		        // Sub-links XPaths
	    		        String[] subLinksXPaths = {
	    		                "//*[@id='SiteMenu']/div[2]/div/div[3]/div/div[1]/ul/li[1]",	// webview link 
	    		                "//*[@id='SiteMenu']/div[2]/div/div[3]/div/div[1]/ul/li[3]",	// Simple Search 
	    		                "//*[@id='SiteMenu']/div[2]/div/div[3]/div/div[1]/ul/li[4]",	// Advance Search 
	    		                "//*[@id='SiteMenu']/div[2]/div/div[3]/div/div[1]/ul/li[5]",	// Webview preferences 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[5]/ul/li[1]", // Fed extracking
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[5]/ul/li[3]", // maintenance
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[9]/ul/li[1]", // help center 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[9]/ul/li[3]", // Reference Documents
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[9]/ul/li[4]", // Knowledge Base 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[9]/ul/li[5]", // Issue Tracking 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[9]/ul/li[6]", // Release Notes 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[2]/ul/li[1]", // Label Editor 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[2]/ul/li[4]", // Text Manager 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[6]/ul/li[1]", // In plant printing (IPP)
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[6]/ul/li[3]", // Print center 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[6]/ul/li[4]", // Inventory Management 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[10]/ul/li[1]", // Hold and Release 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[10]/ul/li[3]", // Label Hold 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[10]/ul/li[4]", // Label Release 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[3]/ul/li[1]", // Document Library 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[3]/ul/li[3]", // Documents 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[7]/ul/li[1]", // Bailment Pool 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[7]/ul/li[3]", // 86/87 pool codes 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[7]/ul/li[4]", // 87 Enable Print 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[7]/ul/li[5]", // 86 Hold VINs 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[4]/ul/li[1]", //Dta Cor 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[4]/ul/li[3]", // Data Entry 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[4]/ul/li[4]", // Recent Scans 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[4]/ul/li[5]", // Config 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[8]/ul/li[1]", // Special Vehicles 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[8]/ul/li[3]", // GT Alterations
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[8]/ul/li[4]", // Company Car 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[8]/ul/li[5]" , // Special Handling Company 
	    		                "//*[@id=\"SiteMenu\"]/div[2]/div/div[3]/div/div[8]/ul/li[6]", // Special handling Dealer / Codes 
	    		                
	    		                
	    		                
	    		        };

	    		        // Expected URLs
	    		        String[] expectedUrls = {
	    		                "http://customerportal.development.local/Webview/Search",
	    		                "http://customerportal.development.local/Webview/Search",
	    		                "http://customerportal.development.local/webview/AdvancedSearch",
	    		                "http://customerportal.development.local/Webview/Preferences",
	    		                "http://customerportal.development.local/FedExTracking/Maintenance",
	    		                "http://customerportal.development.local/FedExTracking/Maintenance",
	    		                "http://customerportal.development.local/HelpCenter/Reference",
	    		                "http://customerportal.development.local/HelpCenter/Reference",
	    		                "http://customerportal.development.local/HelpCenter/KnowledgeBase",
	    		                "http://customerportal.development.local/HelpCenter/IssueTracking",
	    		                "http://customerportal.development.local/HelpCenter/ReleaseNotes",
	    		                "http://customerportal.development.local/LabelEditor/Index",
	    		                "http://customerportal.development.local/LabelEditor/TextManager",
	    		                "http://customerportal.development.local/PrintCenter/PrintDashCenter",
	    		                "http://customerportal.development.local/PrintCenter/PrintDashCenter",
	    		                "http://customerportal.development.local/InventoryManagement/Inventory",
	    		                "http://customerportal.development.local/HoldAndRelease/LabelHold",
	    		                "http://customerportal.development.local/HoldAndRelease/LabelHold",
	    		                "http://customerportal.development.local/HoldAndRelease/LabelRelease",
	    		                "http://customerportal.development.local/documentlibrary",
	    		                "http://customerportal.development.local/documentlibrary",
	    		                "http://customerportal.development.local/BailmentPool/DealerSearch",
	    		                "http://customerportal.development.local/BailmentPool/DealerSearch",
	    		                "http://customerportal.development.local/BailmentPool/BailmentDealer",
	    		                "http://customerportal.development.local/BailmentPool/PoolDealerVIN",
	    		                "http://customerportal.development.local/DtaCor/DataEntry",
	    		                "http://customerportal.development.local/DtaCor/DataEntry",
	    		                "http://customerportal.development.local/DtaCor/RecentScans",
	    		                "http://customerportal.development.local/DtaCor/Config",
	    		                "http://customerportal.development.local/SpecialVehicles/GTAlterations",
	    		                "http://customerportal.development.local/SpecialVehicles/GTAlterations" ,
	    		                "http://customerportal.development.local/SpecialVehicles/DealerSelect",
	    		                "http://customerportal.development.local/SpecialVehicles/CovSpecialHandlingTypes",
	    		                "http://customerportal.development.local/SpecialVehicles/CovSpecialHandlingDealers"
	    		        };

	    		        // Create WebDriverWait instance
	    		        WebDriverWait wait = new WebDriverWait(driver, 10);
	    		        // Find the "Products" element
	    		        WebElement productsElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[2]/div[2]/a/div")));

	    		        // Hover over the "Products" element
	    		        Actions actions = new Actions(driver);
	    		        actions.moveToElement(productsElement).build().perform();

	    		        // Loop through the sub-links
	    		        for (int i = 0; i < subLinksXPaths.length; i++) {
	    		            // Wait for the sub-link to be clickable
	    		            WebElement subLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(subLinksXPaths[i])));

	    		            // Click on the sub-link
	    		            subLink.click();

	    		            // Assert the redirected URL
	    		            Assert.assertEquals(driver.getCurrentUrl(), expectedUrls[i]);
	    		            // Refind element for stale element error 
		    		        WebElement productsElement1 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[2]/div[2]/a/div")));


	    		            // Hover over the "Products" element again
	    		            actions.moveToElement(productsElement1).build().perform();
	    		        }
	    		    }
	    		    
	    		    
	    		    
	    		    public void testReportsNavigation() {
	    		    	
	    		    	
	    		    	
		    		     // Currently Log in based on test case execution Priority 

		    		        // Sub-links XPaths
		    		        String[] subLinksXPaths = {
		    		                "//*[@id=\"SiteMenu\"]/div[3]/div/div[3]/div/div/ul/li[1]",// Production Reports 
		    		                "//*[@id=\"SiteMenu\"]/div[3]/div/div[3]/div/div/ul/li[3]",// Cert History 
		    		                "//*[@id=\"SiteMenu\"]/div[3]/div/div[3]/div/div/ul/li[4]",// DalyXtab 
		    		                "//*[@id=\"SiteMenu\"]/div[3]/div/div[3]/div/div/ul/li[5]", // File processing Status 
		    		                "//*[@id=\"SiteMenu\"]/div[3]/div/div[3]/div/div/ul/li[6]", // Missing loose Content 
		    		                "//*[@id=\"SiteMenu\"]/div[3]/div/div[3]/div/div/ul/li[7]" ,// missing Smog Content 
		    		                "//*[@id=\"SiteMenu\"]/div[3]/div/div[3]/div/div/ul/li[8]" // Retail Suspense 
		    		        };

		    		        // Expected URLs
		    		        String[] expectedUrls = {
		    		                "http://customerportal.development.local/ProductionReports/CertHistory",
		    		                "http://customerportal.development.local/ProductionReports/CertHistory", 
		    		                "http://customerportal.development.local/ProductionReports/DailyCrossTab",
		    		                "http://customerportal.development.local/ProductionReports/FileLoad" ,
		    		                "http://customerportal.development.local/ProductionReports/MissingLooseContentLabel",
		    		                "http://customerportal.development.local/ProductionReports/MissingSmog",
		    		                "http://customerportal.development.local/ProductionReports/RetailSuspense"
		    		        };

		    		        // Create WebDriverWait instance
		    		        WebDriverWait wait = new WebDriverWait(driver, 10);
		    		        // Find the "Reports" element
		    		        WebElement reportsElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[2]/div[3]/a/div")));

		    		        // Hover over the "Reports" element
		    		        Actions actions = new Actions(driver);
		    		        actions.moveToElement(reportsElement).build().perform();

		    		        // Loop through the sub-links
		    		        for (int i = 0; i < subLinksXPaths.length; i++) {
		    		            // Wait for the sub-link to be clickable
		    		            WebElement subLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(subLinksXPaths[i])));

		    		            // Click on the sub-link
		    		            subLink.click();

		    		            // Assert the redirected URL
		    		            Assert.assertEquals(driver.getCurrentUrl(), expectedUrls[i]);
		    		            // Refind element for stale element error 
			    		        WebElement reportsElement1 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[2]/div[3]/a/div")));


		    		            // Hover over the "Products" element again
		    		            actions.moveToElement(reportsElement1).build().perform();
		    		        }
		    		    }
	    		    
	    		    
	    		    
	    		    public void testAdminNavigation() {
	    		    	
	    		    	
		    		     // Currently Log in based on test case execution Priority 

		    		     

		    		        // Sub-links XPaths
		    		        String[] subLinksXPaths = {
		    		                "//*[@id=\"SiteMenu\"]/div[4]/div/div[3]/div/div[1]/ul/li[1]",// Security 
		    		                "//*[@id=\"SiteMenu\"]/div[4]/div/div[3]/div/div[1]/ul/li[3]",// User Review  
		    		                "//*[@id=\"SiteMenu\"]/div[4]/div/div[3]/div/div[1]/ul/li[4]",// Effective Permissions
		    		                "//*[@id=\"SiteMenu\"]/div[4]/div/div[3]/div/div[1]/ul/li[5]", // User Permission History 
		    		                "//*[@id=\"SiteMenu\"]/div[4]/div/div[3]/div/div[1]/ul/li[6]", // User usage Report 
		    		                "//*[@id=\"SiteMenu\"]/div[4]/div/div[3]/div/div[2]/ul/li[1]" ,// Email Maintenance 
		    		                "//*[@id=\"SiteMenu\"]/div[4]/div/div[3]/div/div[2]/ul/li[3]", // Distribution Group users 
		    		                "//*[@id=\"SiteMenu\"]/div[4]/div/div[3]/div/div[2]/ul/li[4]" // Distribution Group Notifications 
		    		        };

		    		        // Expected URLs
		    		        String[] expectedUrls = {
		    		                "http://customerportal.development.local/useradministration",
		    		                "http://customerportal.development.local/useradministration", 
		    		                "http://customerportal.development.local/UserAdministration/EffectivePermissions",
		    		                "http://customerportal.development.local/UserAdministration/UserActivityReport" ,
		    		                "http://customerportal.development.local/UserAdministration/UserUsageReport",
		    		                "http://customerportal.development.local/UserAdministration/DistributionGroupUsers",
		    		                "http://customerportal.development.local/UserAdministration/DistributionGroupUsers",
		    		                "http://customerportal.development.local/UserAdministration/DistributionGroupNotifications"
		    		        };

		    		        // Create WebDriverWait instance
		    		        WebDriverWait wait = new WebDriverWait(driver, 10);
		    		        // Find the "Reports" element
		    		        WebElement adminElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[2]/div[4]/a/div")));

		    		        // Hover over the "Reports" element
		    		        Actions actions = new Actions(driver);
		    		        actions.moveToElement(adminElement).build().perform();

		    		        // Loop through the sub-links
		    		        for (int i = 0; i < subLinksXPaths.length; i++) {
		    		            // Wait for the sub-link to be clickable
		    		            WebElement subLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(subLinksXPaths[i])));

		    		            // Click on the sub-link
		    		            subLink.click();

		    		            // Assert the redirected URL
		    		            Assert.assertEquals(driver.getCurrentUrl(), expectedUrls[i]);
		    		            // Refind element for stale element error 
			    		        WebElement adminElement1 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[2]/div[4]/a/div")));


		    		            // Hover over the "Products" element again
		    		            actions.moveToElement(adminElement1).build().perform();
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
	    		    public void tearDown() {
	    		        // Quit the driver
	    		        driver.quit();
	    		    }
	    		}
