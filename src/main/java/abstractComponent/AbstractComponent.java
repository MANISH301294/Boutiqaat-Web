package abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	 WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
		
	// for Explicit wait Element to Appear
	public void waitforElementToAppear(By FindBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FindBy));		
	}
	
	// for Explicit wait Element to Appear
	public void waitforElementToAppear(WebElement FindBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
		
	// Wait for Element to Disappear 
	public void WaitForElementToDisappear(WebElement ele) 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
//	public void WaitforLoaderDisappear()
//	{
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
//		
//		WebElement fluent = wait.until(new Function<WebDriver, WebElement>()
//				{
//
//					@Override
//					public WebElement apply(WebDriver t) {
//						// TODO Auto-generated method stub
//						return driver.findElement(By.id("loader-bg"));
//					}
//				
//				
//				});
//	}
//	
	public void WaitforElementDisappear(long time) throws InterruptedException
	{
		Thread.sleep(time);
	}
	
	
	
}
