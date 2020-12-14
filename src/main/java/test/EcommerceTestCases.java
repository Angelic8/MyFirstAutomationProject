package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.LoginPage;

public class EcommerceTestCases {

	// 3. create a private instance variable for the driver
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {

		// 11. call the method
		loginNameTest();
		
	} // end main method

	public static void loginNameTest() throws InterruptedException {
		// 1. get the project location
		String projectPath = System.getProperty("user.dir");
		
		// 2. set the Chrome driver and its location
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver1.exe");
		
		// 4. declare and refer a new Chrome object
		driver = new ChromeDriver();
		
		// 5. declare and refer a new object, class LoginPage, and then pass the driver; calls the data from LoginPage
		LoginPage loginPageObj = new LoginPage(driver);
		
		// 7. get the URL of the website
		driver.get("https://member.lazada.com.ph/user/login?spm=a2o4l.home.header.d5.239e359d7u0tiD&redirect=https%3A%2F%2Fwww.lazada.com.ph%2F");
		
		// 8. refer the method from loginPageObj
		loginPageObj.setTextInLoginNameBox("gabbieeneko@gmail.com");
		
		// 9. refer the method from loginPageObj, login button
		loginPageObj.clickLoginButton();
		
		// 10. call the temporary sleep for (5) seconds, close, and then quit the website
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		
		
	} // end method loginNameTest()
	
} // end class EcommerceTestCases
