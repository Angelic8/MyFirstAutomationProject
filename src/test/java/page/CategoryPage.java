package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {

	private WebDriver driver = null;
	private WebDriverWait wait;
	
	By logo_shopeeMall = By.cssSelector("div._1Bj1VS.qEcSbS:nth-child(2) div.home-page:nth-child(2) div.container div.homepage-mall-section:nth-child(6) div.shopee-header-section.shopee-header-section--simple div.shopee-header-section__header div.shopee-header-section__header__title div._3rH8jc > a.DbfcwV._2KY1GO");
	By seeAll_shopeeMall = By.cssSelector("div._1Bj1VS.qEcSbS:nth-child(2) div.home-page:nth-child(2) div.container div.homepage-mall-section:nth-child(6) div.shopee-header-section.shopee-header-section--simple div.shopee-header-section__header a.shopee-header-section__header-link button.shopee-button-no-outline a._42RSr7 > div._2Lx4zQ");
	By ads_shopeeMall = By.cssSelector("body.shopee-no-scroll:nth-child(2) div:nth-child(3) div:nth-child(1) div.shopee-popup.shopee-modal__transition-enter-done div.shopee-popup__container > div.shopee-popup__close-btn");
	By link_shopeeHome = By.cssSelector("div.theme--ofs div._1Bj1VS.hQrkfh:nth-child(2) div.shopee-top.shopee-top--sticky div.navbar-wrapper.container-wrapper.navbar-wrapper--official-shop div.container.navbar div.flex.v-center._1A6Wy3 > a._1UIe83:nth-child(1)");
	
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
	} // end constructor CategoryPage() with parameter driver
	
	public void clickLogoSM() {
	
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2000)", "");
		
		driver.findElement(logo_shopeeMall);
		
	} // end method clickLogoSM()
	
	public void clickSeeAllSMLink() {
		
		wait = new WebDriverWait(driver, 20);	
		wait.until(ExpectedConditions.elementToBeClickable(seeAll_shopeeMall)).click();
				
		
	} // end method clickSeeAllSMLink()
	
	public void clickAdsSM() {
		
		wait = new WebDriverWait(driver, 20);
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ads_shopeeMall)).click();	
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		} // end try-catch block

	} // end method clickAdsSM()
	
	public void clickLinkSH() {
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(link_shopeeHome)).click();
		
	} // end method clickLinkSH()
	
	
} // end class CategoryPage
