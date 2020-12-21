package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import page.LoginPage;

public class ExtentReportsDemo {

	private static WebDriver driver = null;
	private static LoginPage loginPageObj;
	
	public static void main(String[] args) throws InterruptedException {
		
		// start reporter
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Spark.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		// create a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("Google Search Test One", "Test to validate Google search functionality");
		
		// 2. get the project location
		String projectPath = System.getProperty("user.dir");

		// 3. set the Chrome driver and its location
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver1.exe");

		// 4. declare and refer a new Chrome object
		driver = new ChromeDriver();

		// Maximizes the window
		driver.manage().window().maximize();
		
		loginPageObj = new LoginPage(driver);

		// Used to create a toggle for the given test, adds all log events under it
		test.log(Status.INFO, "Starting Test Case");
		
		// 6. get the URL of the website
		driver.get("https://shopee.ph/");
		test.pass("Successfully navigated to the Shopee website");
		
		// 7. refer the method from loginPageObj
		loginPageObj.clickLoginAdsButton();
		test.pass("Ads button is clicked");
		
		loginPageObj.clickLoginLink();
		test.pass("Login link is clicked");
		
		loginPageObj.setTextInLoginNameBox("gabbieeneko@gmail.com");
		test.pass("Entered the username");
		
		Thread.sleep(3000);
		loginPageObj.setTextInLoginPasswordBox("FuRrPasSc0d32021");
		test.pass("Entered the password");
		
		// 8. refer the method from loginPageObj, login button
		Thread.sleep(3000);
		loginPageObj.clickLoginButton();
		test.pass("Login button is clicked");
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		test.pass("Browser is closed");
		
		test.info("Test has been completed");
		
		// calling flush writes everything to the log file
		extent.flush();
	} // end main method

} // end class ExtentReports
