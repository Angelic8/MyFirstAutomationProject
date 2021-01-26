package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import page.CategoryPage;
import page.HomePage;
import page.LoginPage;

public class EcommerceTestCases {

	// 1. Create a private instance variable for the driver
	private static WebDriver driver = null;

	// This is the private instance variable for site pages; data should be inside the @test
	private static LoginPage loginPageObj;
	private static HomePage HomePageObj;
	private static CategoryPage CategoryPageObj;

	// This is for test reports
	private static ExtentSparkReporter spark;
	private static ExtentReports extent;
	private static ExtentTest test;

	@BeforeSuite
	public void setUp() {

		spark = new ExtentSparkReporter("ECommerceTestCases.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

	} // end method setUp()

	@BeforeTest
	public void setUpTest() {

		// 2. Get the project location
		String projectPath = System.getProperty("user.dir");

		// 3. Set the Chrome driver and its location
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver1.exe");

		// Web Push Notifications
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		// 1-Allow, 2-Block, 0-default
		options.setExperimentalOption("prefs", prefs);

		// 4. Declare and refer a new Chrome object
		driver = new ChromeDriver(options);

		// Maximizes the window
		driver.manage().window().maximize();

		// 5. Declare and refer a new object to its class, and then pass it to the
		// driver; data is from the pages own driver
		loginPageObj = new LoginPage(driver);
		HomePageObj = new HomePage(driver);
		CategoryPageObj = new CategoryPage(driver);

		// 6. Get the URL of the website
		driver.get("https://shopee.ph/");

	} // end method setup()

	@Test
	public static void aLoginValidCredentialsTest() throws InterruptedException {

		test = extent.createTest("Verify Login Page", "Check using valid credentials");	
		test.log(Status.INFO, "Login");
		
		// 7. refer the method from loginPageObj
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		loginPageObj.clickLoginAdsButton();
		test.pass("Ads button is clicked.");
		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		loginPageObj.clickLoginLink();
		test.pass("Login is clicked.");
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		loginPageObj.setTextInLoginNameBox("");
		test.pass("Username field is available.");
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		loginPageObj.setTextInLoginPasswordBox("");
		test.pass("Password field is available.");
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		loginPageObj.clickLoginButton();
		test.pass("Successfully Logged-in!");
		
	} // end method loginValidCredentialsTest()

	@Test
	public static void bHomePageTest() throws InterruptedException {

		test = extent.createTest("Verify Homepage","Check the features and functionalities.");
		test.log(Status.INFO, "Homepage");
		
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		HomePageObj.clickLoginAdsButtonAfter();
		test.pass("Pop-up Ads on Homepage is clicked.");
		test.pass("User is in Homepage.");
		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		HomePageObj.inputSearchBar("sunnies face fluffmatte");
		test.pass("Search bar is available");
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		HomePageObj.clickSearchButton();
		test.pass("Search button is clicked.");
		test.pass("User is directed to the Search Results page.");
		
		//Thread.sleep(2000);
		//HomePageObj.searchResultFor();
		//Assert.assertTrue("sunnies face fluffmatte", true);
		//System.out.println(); 
		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		HomePageObj.clickShopeeLogo();
		test.pass("Shopee Logo is clicked.");
		test.pass("User is directed to Homepage.");
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		HomePageObj.clickPopUpAdsHomepage();
		test.pass("Pop-up Ads in Homepage is clicked.");
		
	} // end method bHomePageTest()

	@Test
	public static void cCategoryPageTest() {

		test = extent.createTest("Verify Category Page","Check the features and functionalities.");
		test.log(Status.INFO, "Category");
		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		CategoryPageObj.clickLogoSM();
		test.pass("Shopee Mall section in Homepage is available.");
		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		CategoryPageObj.clickSeeAllSMLink();
		test.pass("See All link is clicked.");
		test.pass("User is directed to Shoppe Mall page.");
		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		CategoryPageObj.clickAdsSM();
		test.pass("Pop-up ads on Shopee Mall is clicked.");
		test.pass("User is in the Shopee Mall - Category page.");
		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		CategoryPageObj.clickLinkSH();
		test.pass("Shopee Home link is clicked.");
		test.pass("User is directed to Homepage.");
		
	} // end method cCategoryPageTest()

	@AfterTest
	public static void endTest() {

		// 8. call the temporary sleep for (5) seconds, close, and then quit the website
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.close();
		driver.quit();
		test.pass("Browser is closed");
		test.info("Test has been completed");
		
		// This is required when using the Extent Report
		extent.flush();
		
	} // end method endTest()

} // end class EcommerceTestCases
