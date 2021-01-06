package test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.*;

import page.HomePage;
import page.LoginPage;

public class EcommerceTestCases {

	// 1. create a private instance variable for the driver
	private static WebDriver driver = null;
	private static LoginPage loginPageObj;
	private static HomePage HomePageObj;

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

		// 5. declare and refer a new object, class LoginPage, and then pass the driver;
		loginPageObj = new LoginPage(driver); // calls the data from LoginPage
		HomePageObj = new HomePage(driver); // calls the data from HomePage*/

		// 6. get the URL of the website
		driver.get("https://shopee.ph/");
	} // end method or function setup()

	@Test
	public static void loginValidCredentialsTest() throws InterruptedException {

		// 7. refer the method from loginPageObj
		loginPageObj.clickLoginAdsButton();
		loginPageObj.clickLoginLink();
		loginPageObj.setTextInLoginNameBox("gabbieeneko@gmail.com");
		Thread.sleep(3000);
		loginPageObj.setTextInLoginPasswordBox("FuRrPasSc0d32021");
		Thread.sleep(3000);
		// 8. refer the method from loginPageObj, login button
		loginPageObj.clickLoginButton();

	} // end method or function loginValidCredentialsTest()

	@Test
	public static void homePageAds() throws InterruptedException {

		Thread.sleep(6000);
		HomePageObj.clickLoginAdsButtonAfter();

	} // end method or function homePageAds()

	@Test
	public static void homePageSearchBar() throws InterruptedException {

		Thread.sleep(3000);
		HomePageObj.inputSearchBar("sunnies face fluffmatte");

	} // end method or function homePageSearchBar()

	@Test
	public static void homePageSearchButton() throws InterruptedException {

		Thread.sleep(3000);
		HomePageObj.clickSearchButton();
		
	} // end method or function homePageSearchButton()

	@AfterTest
	public static void endTest() throws InterruptedException {

		// 9. call the temporary sleep for (5) seconds, close, and then quit the website
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	} // end method or function endTest()

} // end class EcommerceTestCases
