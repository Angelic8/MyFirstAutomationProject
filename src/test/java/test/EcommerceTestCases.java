package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.CategoryPage;
import page.HomePage;
import page.LoginPage;
//import page.SearchAndSearchResults;

public class EcommerceTestCases {

	// 1. create a private instance variable for the driver
	private static WebDriver driver = null;
	
	// create a private instance variable for pages; data should be inside the test suite
	private static LoginPage loginPageObj;
	private static HomePage HomePageObj;
	private static CategoryPage CategoryPageObj;
	//private static SearchAndSearchResults SearchAndSearchResultsObj;
	
	@BeforeTest
	public void setUpTest() {

		// 2. get the project location
		String projectPath = System.getProperty("user.dir");

		// 3. set the Chrome driver and its location
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver1.exe");

		// Web Push Notifications
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		// 1-Allow, 2-Block, 0-default
		options.setExperimentalOption("prefs", prefs);

		// 4. declare and refer a new Chrome object
		driver = new ChromeDriver(options);

		// Maximizes the window
		driver.manage().window().maximize();

		// 5. declare and refer a new object to its class, and then pass it to the driver; data is from the pages own driver
		loginPageObj = new LoginPage(driver);
		HomePageObj = new HomePage(driver);
		CategoryPageObj = new CategoryPage(driver);
		//SearchAndSearchResultsObj = new SearchAndSearchResults(driver);
		
		// 6. get the URL of the website
		driver.get("https://shopee.ph/");
		
	} // end method setup()

	@Test
	public static void aLoginValidCredentialsTest() throws InterruptedException {

		// 7. refer the method from loginPageObj
		Thread.sleep(2000);
		loginPageObj.clickLoginAdsButton();
		Thread.sleep(2000);
		loginPageObj.clickLoginLink();
		loginPageObj.setTextInLoginNameBox("gabbieeneko@gmail.com");
		Thread.sleep(2000);
		loginPageObj.setTextInLoginPasswordBox("FuRrPasSc0d32021");
		Thread.sleep(2000);
		loginPageObj.clickLoginButton();

	} // end method loginValidCredentialsTest()

	@Test
	public static void bHomePageTest() throws InterruptedException {

		Thread.sleep(2000);
		HomePageObj.clickLoginAdsButtonAfter();
		Thread.sleep(2000);
		HomePageObj.inputSearchBar("sunnies face fluffmatte");
		Thread.sleep(2000);
		HomePageObj.clickSearchButton();	
		HomePageObj.clickShopeeLogo();
	} // end method bHomePageTest()
	
	@Test
	public static void cCategoryPageTest() throws InterruptedException {
		
		Thread.sleep(2000);
		CategoryPageObj.clickLogoSM();
		CategoryPageObj.clickSeeAllSMLink();
		
	} // end method cCategoryPageTest()
	
	
	@AfterTest
	public static void endTest() throws InterruptedException {

		// 8. call the temporary sleep for (5) seconds, close, and then quit the website
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	} // end method endTest()

} // end class EcommerceTestCases
