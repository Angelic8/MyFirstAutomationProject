package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private WebElement element;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	} // end constructor HomePage

	By ads_loginAfter = By.cssSelector("body.shopee-no-scroll:nth-child(2) div:nth-child(3) div:nth-child(1) div.shopee-popup.shopee-modal__transition-enter-done div.shopee-popup__container > div.shopee-popup__close-btn");
	By searchBar_homePage = By.className("shopee-searchbar-input__input");
	By searchButton_homePage = By.cssSelector("div._1Bj1VS.qEcSbS:nth-child(2) div.shopee-top.shopee-top--sticky div.container-wrapper.header-with-search-wrapper div.container.header-with-search div.header-with-search__search-section div.shopee-searchbar > button.btn.btn-solid-primary.btn--s.btn--inline");
	
	
	public void clickLoginAdsButtonAfter() {

		wait = new WebDriverWait(driver, 20);
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ads_loginAfter)).click();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	} // end method clickLoginAdsButton()

	public void inputSearchBar(String text) {

		wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar_homePage));
		element.sendKeys(text);

	} // end method inputSearchBar

	public void clickSearchButton() {
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton_homePage)).sendKeys(Keys.RETURN);
		
	} // end method clickSearchButton()
	
	
	
	
	
} // end method HomePage
