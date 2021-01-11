package page;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	// 1. declare an instance variable, for the driver
	private WebDriver driver = null;
	private WebDriverWait wait;
	private WebElement element;
	
	// 3. declare the class By, for CSS selector
	By ads_login = By.cssSelector("body.shopee-no-scroll:nth-child(2) div:nth-child(3) div:nth-child(1) div.shopee-popup.shopee-modal__transition-enter-done div.shopee-popup__container > div.shopee-popup__close-btn");
	By link_login = By.xpath("//a[contains(text(),'Login')]");
	By textbox_loginName = By.cssSelector("div._3evFhm:nth-child(2) div._3h8gZy._1C_iyK div._1t9Dup._7p8xth._1W4V3v div._1B7mke div._1HkukX:nth-child(2) div.FcG1bN > input._56AraZ");
	By textbox_loginPassword = By.xpath("//input[@name='password']");
	By button_login = By.xpath("//button[contains(text(),'Log In')]");
	
	// 2. A constructor for the driver to be accessed by the main method, for passing data
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	} // end constructor LoginPage()

	// 4. method for find element by locator variable; 
	public void clickLoginLink() {
		
		driver.findElement(link_login).sendKeys(Keys.RETURN);
		
	} // end method clickLoginLink 
	
	public void clickLoginAdsButton() {
		
		wait = new WebDriverWait(driver, 20);
		
		try {	
			wait.until(ExpectedConditions.elementToBeClickable(ads_login)).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	} // end method clickLoginAdsButton()
	
	// 5. method for find element by locator variable; pass the String text, for send keys
	public void setTextInLoginNameBox(String text) {	// the text will be pass on textbox_loginName
		
		wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(textbox_loginName));
		element.sendKeys(text);
		
	} // end method setTextInLoginNameBox
	
	// 6. method for find element by locator variable; pass the String text2, for send keys
	public void setTextInLoginPasswordBox(String text2) {
		wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(textbox_loginPassword));
		element.sendKeys(text2);
		
	} // end method setTextInLoginPasswordBox
	
	// 7. method for find element by locator variable; no need to pass an argument
	public void clickLoginButton() {
		wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(button_login));
		element.click();
		
	} // end method clickLoginButton
	
} // end class LoginPage
