package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import page.LoginPage;


public class ExtentReportsDemoWithTestNG {

	private ExtentSparkReporter spark;
	private ExtentReports extent;
	private ExtentTest test;
	
	private static WebDriver driver = null;
	private static LoginPage loginPageObj;
	
	@BeforeSuite
	public void setUp() {	
		
		spark = new ExtentSparkReporter("ReportsWithTestNG.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

	} // end method or function setUp()

	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginPageObj = new LoginPage(driver);
		
	} // end method setUpTest()
	
	
	@Test
	public void test1() {		
	
		test = extent.createTest("MyFirstTest", "Sample description");
		
		test.log(Status.INFO, "Starting Test Case");
		
		driver.get("https://shopee.ph/");
		test.pass("Successfully navigated to the Shopee website");
		
		loginPageObj.clickLoginAdsButton();
		test.pass("Ads button is clicked");
		
		loginPageObj.clickLoginLink();
		test.pass("Login link is clicked");
		
		loginPageObj.setTextInLoginNameBox("gabbieeneko@gmail.com");
		test.pass("Entered the username");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPageObj.setTextInLoginPasswordBox("FuRrPasSc0d32021");
		test.pass("Entered the password");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPageObj.clickLoginButton();
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("failed-img.png").build());
		test.addScreenCaptureFromPath("failed.png");
		
		//test.pass("Login button is clicked");
		
	} // end method or function test1()
	
	@AfterSuite
	public void tearDown() throws InterruptedException {		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		test.pass("Browser is closed");
		test.info("Test has been completed");
		extent.flush();
	} // end method or function tearDown()
	
} // end class ExtentReportsDemoWithTestNG
