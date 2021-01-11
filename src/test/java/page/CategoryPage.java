package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {

	private WebDriver driver = null;
	private WebDriverWait wait;
	private WebElement element;
	
	By logo_shopeeMall = By.cssSelector("div._1Bj1VS.qEcSbS:nth-child(2) div.home-page:nth-child(2) div.container div.homepage-mall-section:nth-child(6) div.shopee-header-section.shopee-header-section--simple div.shopee-header-section__header div.shopee-header-section__header__title div._3rH8jc > a.DbfcwV._2KY1GO");
	By seeAll_shopeeMall = By.cssSelector("div._1Bj1VS.qEcSbS:nth-child(2) div.home-page:nth-child(2) div.container div.homepage-mall-section:nth-child(6) div.shopee-header-section.shopee-header-section--simple div.shopee-header-section__header a.shopee-header-section__header-link button.shopee-button-no-outline a._42RSr7 > div._2Lx4zQ");

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
	} // end constructor CategoryPage() with parameter driver
	
	public void clickLogoSM() {
	
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollBy(0,1000)", "");
		
		element = driver.findElement(logo_shopeeMall);
		
	} // end method clickLogoSM()
	
	public void clickSeeAllSMLink() {
		
		wait = new WebDriverWait(driver, 20);	
		wait.until(ExpectedConditions.elementToBeClickable(seeAll_shopeeMall)).click();
				
		
	} // end method clickSeeAllSMLink()
	
	
} // end class CategoryPage
