package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class OrderHistoryPage extends AbstractComponent {

	WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='links register']")
	WebElement account;
	
	@FindBy(xpath="//h1[normalize-space()='My Dashboard']")
	WebElement DashBoard;
	
	@FindBy(xpath="(//span[normalize-space()='MY ORDERS'])[2]")
	WebElement myOrders;
	
	@FindBy(css="div p.align-self-center")
	WebElement self_center;
	
	@FindBy(css="div.card.card-body.order-history")
	List<WebElement> OrdrHstry;
	
	@FindBy(css="div.col-md-9")
	WebElement OrdrDtls;
	
	@FindBy(xpath="(//div[@class='col-md-3'])[1]")
	WebElement OrderDetals;
	
	@FindBy(css="div.col-md-11.text-center")
	WebElement text_center;
	
	@FindBy(xpath="(//div[@class='row font-weight-bold'])[1]")
	WebElement Grand_Total;
	
	@FindBy(xpath="//div[@class='col-md-6 align-self-center']")
	WebElement item_Details;
	
	@FindBy(xpath="//button[@class='btn w-100 goldenBtn toolTipCont mt-2']")
	WebElement track;
	@FindBy(xpath="//button[@class='btn w-100 goldenBtn toolTipCont mt-2']/span")
	WebElement trackInfo;
	
	@FindBy(xpath="//h5")
	WebElement NoOrder;
	
	
	
	public void AccountPage()
	{
		waitforElementToAppear(account);
		account.click();
		waitforElementToAppear(DashBoard);
		myOrders.click();
	}
	
	
	public void OrderPage()
	{
	
		waitforElementToAppear(self_center);
		System.out.println(self_center.getText());
		
		try {
		for(WebElement OrderDetails:OrdrHstry)
		{
			OrderDetails.getText();
			System.out.println(OrdrDtls.getText());	
		}
		OrderDetals.click();
		waitforElementToAppear(text_center);
		System.out.println(text_center.getText());
		System.out.println(Grand_Total.getText());
		System.out.println(item_Details.getText());
		Actions a = new Actions(driver);
		a.click(track).moveToElement(trackInfo).build().perform();
		System.out.println(trackInfo.getText());
	     }
		
		catch(Exception e)
		{
			System.out.println(NoOrder.getText());
		}
}
	
	public void OrderHistory()
	{
		
		try {
			waitforElementToAppear(text_center);
			System.out.println(text_center.getText());
			System.out.println(Grand_Total.getText());
			System.out.println(item_Details.getText());
			Actions a = new Actions(driver);
			a.click(track).moveToElement(trackInfo).build().perform();
			System.out.println(trackInfo.getText());
		     }
			
			catch(Exception e)
			{
				System.out.println(NoOrder.getText());
			}
			
		
		
	}
}