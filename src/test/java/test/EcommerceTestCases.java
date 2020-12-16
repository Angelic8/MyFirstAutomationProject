package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.*;

import page.LoginPage;

public class EcommerceTestCases {

	// 1. create a private instance variable for the driver
	private static WebDriver driver = null;
	private static LoginPage loginPageObj;

	// public static void main(String[] args) throws InterruptedException {
	// } // end main method

	@BeforeTest
	public void setUpTest() {

		// 2. get the project location
		String projectPath = System.getProperty("user.dir");

		// 3. set the Chrome driver and its location
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver1.exe");

		// 4. declare and refer a new Chrome object
		driver = new ChromeDriver();

		// Maximizes the window
		driver.manage().window().maximize();

	} // end method setup()

	// 10. call the method
	// loginValidCredentialsTest();
	// loginInvalidCredentialsTest();

	@Test
	public static void loginValidCredentialsTest() throws InterruptedException {
		// 5. declare and refer a new object, class LoginPage, and then pass the driver;
		// calls the data from LoginPage
		loginPageObj = new LoginPage(driver);

		// 6. get the URL of the website
		driver.get("https://shopee.ph/");

		// 7. refer the method from loginPageObj
		loginPageObj.clickLoginAdsButton();
		loginPageObj.clickLoginLink();
		loginPageObj.setTextInLoginNameBox("gabbieeneko@gmail.com");
		Thread.sleep(3000);
		loginPageObj.setTextInLoginPasswordBox("FuRrPasSc0d32021");
		Thread.sleep(3000);
		// 8. refer the method from loginPageObj, login button
		loginPageObj.clickLoginButton();

	} // end method loginValidCredentialsTest()

	/*@Test
	public static void loginInvalidCredentialsTest() throws InterruptedException {

		loginPageObj = new LoginPage(driver);
		driver.get("https://shopee.ph/");

		loginPageObj.clickLoginAdsButton();
		loginPageObj.clickLoginLink();

		loginPageObj.setTextInLoginNameBox("gabbieeneko@gmail.com");
		Thread.sleep(3000);
		loginPageObj.setTextInLoginPasswordBox("FuRrPasSc0d32022");
		Thread.sleep(3000);
		loginPageObj.clickLoginButton();

	} // end method loginInvalidCredentialsTest() */

	@AfterTest
	public static void endTest() throws InterruptedException {

		// 9. call the temporary sleep for (5) seconds, close, and then quit the website
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	} // end method endTest()

} // end class EcommerceTestCases
