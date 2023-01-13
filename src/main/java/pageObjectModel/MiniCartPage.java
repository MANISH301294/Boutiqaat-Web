package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class MiniCartPage extends AbstractComponent {
	
	WebDriver driver;
	public MiniCartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='minicart']")
	WebElement minicart;
	
	@FindBy(xpath="//p[@class='mincart-text']/strong")
	WebElement CartItem;
	
	@FindBy(css=".btn.btn-primary.checkout.white")
	WebElement viewItem;
	
	@FindBy(css="h6[class='product-name']")
	List<WebElement> minicartProd;
	
	@FindBy(css="div[class='qty-item']")
	WebElement CartIttem;
	
	public void MiniCart() throws InterruptedException
	{
		//**------------------MiniCartItem**------------
		//waitforElementToAppear(minicart);
		        WaitforElementDisappear(3000);
				minicart.click();
				waitforElementToAppear(CartItem);
				WaitforElementDisappear(2000);
				System.out.println("No. of items in Mini cart = "+CartItem.getText());
				for(WebElement CartProd:minicartProd)
				{
					Actions a = new Actions(driver);
					a.moveToElement(CartProd).build().perform();
					System.out.println(CartProd.getText());
				}
				viewItem.click();
				waitforElementToAppear(CartIttem);
	

	//-----------------**CartItem**------------------------
		    String[] Cart = 	CartIttem.getText().split(" ");
		    String[] cartIt = Cart[1].split("");
		    String CartItems = cartIt[1];
		    System.out.println("No.of items in Cart = "+CartItems);
		  //  Assert.assertEquals(CartItem, CartItems);
}}
