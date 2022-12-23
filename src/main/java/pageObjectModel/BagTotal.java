package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class BagTotal extends AbstractComponent {

	WebDriver driver;
	public BagTotal(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="div[class='bag-total']")
	WebElement Bagttl;
	
	@FindBy(css=" ul")
	List<WebElement> prdcts;
	
	@FindBy(css=" button span[class='wishlist-link']")
	List<WebElement> wish;
	
	@FindBy(css=" div[class='totals'] div button")
	WebElement ContinuePayment;
	
	public void Bag() throws InterruptedException
	{
		 //--------------------**Bag total**------------------------
		waitforElementToAppear(Bagttl);
		System.out.println(Bagttl.getText());
	    
		 //--------------------**Products**-------------
		System.out.println(prdcts.size());
		for(WebElement crtPrdct:prdcts)
		{
		System.out.println(crtPrdct.getText());
		}
		//------------Add to Wish list----
		for(WebElement wishlist:wish)
		{
			wishlist.click();
			WaitforElementDisappear(3000);
		}
		//---------Continue to Payment----
	    // ContinuePayment.click();
	    // WaitforElementDisappear();
	    
		
}

}
