package pageObjectModel;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5")
	WebElement FreeShipping;

	@FindBy(xpath = "//p/p")
	WebElement ShippingText;

	@FindBy(css = "button[type='button']")
	WebElement OK;

	@FindBy(css = "label[class='radio-inline align-middle label-payment']")
	List<WebElement> PaymentMethod;

	@FindBy(css = "label[class='radio-inline align-middle label-payment'] input")
	WebElement radio;

	@FindBy(css = " div[class='totals'] div button")
	WebElement chekout;

	@FindBy(xpath="(//div/img[@class='logoHead'])[1]")
	WebElement gateway;
	
	@FindBy(css="#cancel")
	WebElement cancelPayment;
	
	@FindBy(xpath="//h5[normalize-space()='Transaction Details']")
	WebElement ConfirmCancelPayment;
	
	@FindBy(css="a[class='logo']")
	WebElement BoutiHomePage;
	
	public void CheckOut(String PaymentMethods) throws InterruptedException {

		try {
			FreeShipping.isDisplayed();
			System.out.println(ShippingText.getText());
			OK.click();
			WaitforElementDisappear(2000);
			for (WebElement method : PaymentMethod) {
				System.out.println(method.getText());
				if (method.getText().contains(PaymentMethods)) {
					radio.click();
				}
			}

		} catch (NoSuchElementException e) {
			for (WebElement method : PaymentMethod) {
				System.out.println(method.getText());
				if (method.getText().contains(PaymentMethods)) {
					radio.click();
				}
			}

		}

		chekout.click();
		waitforElementToAppear(gateway);
		
		cancelPayment.click();
		waitforElementToAppear(ConfirmCancelPayment);
		BoutiHomePage.click();
		
	}
	
	

}
