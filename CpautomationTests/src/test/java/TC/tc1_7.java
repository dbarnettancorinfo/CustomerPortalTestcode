package TC;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class tc1_7 {
	

	    private WebDriver driver;

	    																			// Test Case 1.7 - Sub page links should redirect web page to appropriate corresponding pages

	    @BeforeMethod
	    public void setUp() {
	        // Set up EdgeDriver path
	        System.setProperty("webdriver.edge.driver", "C:\\Users\\dbarnett\\Downloads\\edgedriver_win64\\msedgedriver.exe");

	        // Create EdgeDriver instance
	        driver = new EdgeDriver();
	       
	    }

	    @Test(priority = 1)
	    public void testSubPageLinksInEdge() {
	    	driver.get("http://customerportal.development.local/Account/Login?ReturnUrl=");
	    	
	    	 WebDriverWait wait = new WebDriverWait(driver, 10);
	      

	        // Click on "Who We Are" link
	        WebElement whoWeAreLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer\"]/div[1]/div/div[2]/ul/li[1]/a")));
	        whoWeAreLink.click();
	        driver.getCurrentUrl();
	        // Assert the page URL
	        assertPageURL("https://ancorinfo.com/about-ancor/");

	        // Get Window handle of first tab
	        String firstTabHandle = driver.getWindowHandle();

	        // Go back to the main tab
	        driver.switchTo().window(firstTabHandle);

	        // Click on "Home" link
	        WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer\"]/div[1]/div/div[2]/ul/li[2]/a")));
	        homeLink.click();
	        // Assert the page URL
	        assertPageURL("http://customerportal.development.local/home");

	        // Go back to the main tab
	        driver.switchTo().window(firstTabHandle);

	        // Click on "About WebView" link
	        WebElement aboutWebViewLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer\"]/div[1]/div/div[3]/ul/li/a")));
	        aboutWebViewLink.click();
	        // Assert the page URL
	        assertPageURL("https://ancorinfo.com/software-solutions/");

	        // Go back to the main tab
	        driver.switchTo().window(firstTabHandle);

	        // Click on "Contact Us" link
	        WebElement contactUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer\"]/div[1]/div/div[4]/ul/li[1]/a")));
	        contactUsLink.click();
	        // Assert the page URL
	        assertPageURL("https://ancorinfo.com/contact/");

	        // Go back to the main tab
	        driver.switchTo().window(firstTabHandle);

	        // Click on "Help Center" link
	        WebElement helpCenterLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer\"]/div[1]/div/div[4]/ul/li[2]/a")));
	        helpCenterLink.click();
	        // Assert the page URL
	        assertPageURL("http://customerportal.development.local/HelpCenter/Reference");

	        // Go back to the main tab
	        driver.switchTo().window(firstTabHandle);

	        // Click on "Report Issue" link
	        WebElement reportIssueLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer\"]/div[1]/div/div[4]/ul/li[3]/a")));
	        reportIssueLink.click();
	        // Assert the page URL
	        assertPageURL("http://customerportal.development.local/HelpCenter/IssueTracking");
	    }

	
	  
	    

	    @Test (priority = 2 )
	    public void testSubPageLinksInChrome() {
	    	driver.quit(); //end edge browser session 
	    	
	    	 // Set up ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\dbarnett\\\\\\\\Downloads\\\\\\\\chromedriver_win32 (2)\\\\\\\\chromedriver.exe");
	        
	       ChromeDriver driver = new ChromeDriver();
	       
	       	// Run log-in method 
	        logIn();


	       

	        // Click on "Who We Are" link
	        WebElement whoWeAreLink = driver.findElement(By.linkText("Who We Are"));
	        whoWeAreLink.click();
	        // Assert the page URL
	        assertPageURL("https://ancorinfo.com/about-ancor/");

	        
	        // Get Window handle of first tab 
	        String firstTabHandle = driver.getWindowHandles().iterator().next();
	        
	        
			// Go back to the main tab 
	        driver.switchTo().window(firstTabHandle);

	        // Click on "Home" link
	        WebElement homeLink = driver.findElement(By.linkText("Home"));
	        homeLink.click();
	        // Assert the page URL
	        assertPageURL("http://customerportal.development.local/home");

	        // Go back to the main tab 
	        driver.switchTo().window(firstTabHandle);
	        
	        // Click on "About WebView" link
	        WebElement aboutWebViewLink = driver.findElement(By.linkText("About Webview"));
	        aboutWebViewLink.click();
	        // Assert the page URL
	        assertPageURL("https://ancorinfo.com/software-solutions/");

	        // Go back to the main tab 
	        driver.switchTo().window(firstTabHandle);
	        
	        // Click on "Contact Us" link
	        WebElement contactUsLink = driver.findElement(By.linkText("Contact Us"));
	        contactUsLink.click();
	        // Assert the page URL
	        assertPageURL("https://ancorinfo.com/contact/");

	     // Go back to the main tab 
	        driver.switchTo().window(firstTabHandle);
	        
	        // Click on "Help Center" link
	        WebElement helpCenterLink = driver.findElement(By.linkText("Help Center"));
	        helpCenterLink.click();
	        // Assert the page URL
	        assertPageURL("http://customerportal.development.local/HelpCenter/Reference");

	        // Go back to previous page
	        driver.navigate().back();

	        // Click on "Report Issue" link
	        WebElement reportIssueLink = driver.findElement(By.linkText("Report Issue"));
	        reportIssueLink.click();
	        // Assert the page URL
	        assertPageURL("http://customerportal.development.local/HelpCenter/IssueTracking");
	    }
	    
	    
	    
	    @Test (priority = 3 )
	    public void testSubPageLinksInFirefox() {
	    	driver.quit(); // end chrome broswer session
	    	// Set up FirefoxDriver path
	        System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\dbarnett\\\\Downloads\\\\geckodriver-v0.33.0\\\\\\\\geckodriver.exe");
	        
	       FirefoxDriver driver = new FirefoxDriver();
	       
	       	// Run log-in method 
	        logIn();

	        // Click on "Who We Are" link
	        WebElement whoWeAreLink = driver.findElement(By.linkText("Who We Are"));
	        whoWeAreLink.click();
	        // Assert the page URL
	        assertPageURL("https://ancorinfo.com/about-ancor/");

	        
	        // Get Window handle of first tab 
	        String firstTabHandle = driver.getWindowHandles().iterator().next();
	        
	        
			// Go back to the main tab 
	        driver.switchTo().window(firstTabHandle);

	        // Click on "Home" link
	        WebElement homeLink = driver.findElement(By.linkText("Home"));
	        homeLink.click();
	        // Assert the page URL
	        assertPageURL("https://customerportal.development.local/home");

	        // Go back to the main tab 
	        driver.switchTo().window(firstTabHandle);
	        
	        // Click on "About WebView" link
	        WebElement aboutWebViewLink = driver.findElement(By.linkText("About Webview"));
	        aboutWebViewLink.click();
	        // Assert the page URL
	        assertPageURL("https://ancorinfo.com/software-solutions/");

	        // Go back to the main tab 
	        driver.switchTo().window(firstTabHandle);
	        
	        // Click on "Contact Us" link
	        WebElement contactUsLink = driver.findElement(By.linkText("Contact Us"));
	        contactUsLink.click();
	        // Assert the page URL
	        assertPageURL("https://ancorinfo.com/contact/");

	     // Go back to the main tab 
	        driver.switchTo().window(firstTabHandle);
	        
	        // Click on "Help Center" link
	        WebElement helpCenterLink = driver.findElement(By.linkText("Help Center"));
	        helpCenterLink.click();
	        // Assert the page URL
	        assertPageURL("http://customerportal.development.local/HelpCenter/Reference");

	        // Go back to previous page
	        driver.navigate().back();

	        // Click on "Report Issue" link
	        WebElement reportIssueLink = driver.findElement(By.linkText("Report Issue"));
	        reportIssueLink.click();
	        // Assert the page URL
	        assertPageURL("http://customerportal.development.local/HelpCenter/IssueTracking");
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
	    

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }

	    private void assertPageURL(String expectedURL) {
	        String actualURL = driver.getCurrentUrl();
	        assert actualURL.equals(expectedURL) : "Expected URL: " + expectedURL + ", Actual URL: " + actualURL;
	    }
	}


