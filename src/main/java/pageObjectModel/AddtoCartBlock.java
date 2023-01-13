package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class AddtoCartBlock extends AbstractComponent {
	WebDriver driver;
	public AddtoCartBlock(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='product-item-details pb-2']")
	List<WebElement> item;
	
	@FindBy(xpath="//div[@class='product-item-actions']/button")
	List<WebElement> addTo;
	
	@FindBy(name="name")
	WebElement NotifyName;
	
	@FindBy(xpath="(//input[@name='email'])[2]")
	WebElement NotifyEmail; 
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement NotifyPhone;
	
	@FindBy(xpath="(//button[@class='btn btn-primary col-12'])[2]")
	WebElement NotifySubmit;
	
	@FindBy(xpath="(//div[@class='container pl-2']/ul/li)[3]")
	WebElement BrandName;
	

	
	public void ItemInfo(String name,String email,String phone) throws InterruptedException
	{
		for(WebElement Prodinfo:item)
		{
			System.out.println(Prodinfo.getText());
		}
		 for(WebElement addToCart:addTo)
		 {
			  if(addToCart.getText().equals("Buy Now"))
			  {
				  addToCart.click();
				  WaitforElementDisappear(2000);
				  break;
			  }
		 else if(addToCart.getText().equals("Notify Me"))
		  {
			  WaitforElementDisappear(2000);
			  addToCart.click();
		      NotifyName.sendKeys(name);
		      NotifyEmail.sendKeys(email);
			  NotifyPhone.sendKeys(phone);
			  NotifySubmit.click();
			  break;
		  }	
		 else if(addToCart.getText().equals("View"))
		  {  
			 WaitforElementDisappear(2000);
			  addToCart.click();
			 
			  break;
		  }	  
			  
              break;
              
              
	}
		 WaitforElementDisappear(2000);
	}}
