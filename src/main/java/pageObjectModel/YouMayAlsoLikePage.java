package pageObjectModel;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class YouMayAlsoLikePage extends AbstractComponent{
	
	WebDriver driver;
	
	public YouMayAlsoLikePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="h3")
	WebElement Heading;
	
	@FindBy(css="div[class='product-name']")
	List<WebElement> prodName;
	
	@FindBy(css=".slick-next")
	WebElement next;
	
	@FindBy(xpath="(//a[@class='action towishlist'])[12]")
	WebElement wish;
	
	@FindBy(xpath="(//button[@class='action tocart primary'])[12]")
	WebElement add_cart;
	public void YouMayLike() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1400)");
		System.out.println(Heading.getText());
		System.out.println("no. of item"+prodName.size());
		WaitforElementDisappear(2000);
		for(WebElement ItemName:prodName)
		{ 
			String description = ItemName.getText();
			System.out.println(description);
			Thread.sleep(2000);
			next.click();
			}
		wish.click();
		Thread.sleep(1000);
		add_cart.click();
	  
	}

}
