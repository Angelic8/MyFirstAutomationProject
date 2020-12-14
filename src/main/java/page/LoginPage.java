package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	// 1. declare an instance variable, for the driver
	WebDriver driver = null;
	
	// 2. A constructor for the driver to be accessed by the main method, for passing data
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	} // end constructor LoginPage

	// 3. declare the class By, for CSS selector
	By textbox_loginName = By.cssSelector("body.venture-PH.p-vogayer:nth-child(2) div.lzd-playground:nth-child(4) div.lzd-playground-main div.container div.login form:nth-child(1) div.mod-login div.mod-login-col1 div.mod-input.mod-login-input-loginName.mod-input-loginName:nth-child(1) > input:nth-child(2)");
	By button_login = By.cssSelector("body.venture-PH.p-vogayer:nth-child(2) div.lzd-playground:nth-child(4) div.lzd-playground-main div.container div.login form:nth-child(1) div.mod-login div.mod-login-col2 div.mod-login-btn > button.next-btn.next-btn-primary.next-btn-large");
	
	
	// 4. create a method to find element by locator variable; pass the String text, for send keys
	public void setTextInLoginNameBox(String text) {	// the text will be pass on textbox_loginName
		
		driver.findElement(textbox_loginName).sendKeys(text);
		
	} // end method setTextInLoginNameBox
	
	// 5. create a method/function to find element by locator variable; no need to pass an argument
	public void clickLoginButton() {
		
		driver.findElement(button_login).click();
		
	} // end method clickLoginButton
	
} // end class LoginPage
