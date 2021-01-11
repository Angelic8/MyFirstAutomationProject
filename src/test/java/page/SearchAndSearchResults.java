package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAndSearchResults {

	private WebDriver driver = null;
	private WebDriverWait wait;
	private WebElement element;
		
	By searchBar_homePage = By.className("shopee-searchbar-input__input");
	By searchButton_homePage = By.cssSelector("div._1Bj1VS.qEcSbS:nth-child(2) div.shopee-top.shopee-top--sticky div.container-wrapper.header-with-search-wrapper div.container.header-with-search div.header-with-search__search-section div.shopee-searchbar > button.btn.btn-solid-primary.btn--s.btn--inline");
	
	public SearchAndSearchResults(WebDriver driver) {
		this.driver = driver;
	} // end constructor SearchAndSearchResults()
	
	public void inputSearchBar(String text) {

		wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar_homePage));
		element.sendKeys(text);

	} // end method inputSearchBar

	public void clickSearchButton() {
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton_homePage)).sendKeys(Keys.RETURN);
		
	} // end method clickSearchButton()
	
} // end class SearchAndSearchResults
