package pageObjectModel;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log In")
	WebElement LoginHover;

	@FindBy(xpath = "//div[@class='ddhover']//input[@placeholder='Email']")
	WebElement email;

	@FindBy(xpath = "//div[@class='ddhover']//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//div[@class='ddhover']//button[@class='btn btn-primary col-12'][normalize-space()='LOGIN']")
	WebElement submit;

	@FindBy(css = "div[role='alert']")
	WebElement alertMessage;

	@FindBy(xpath = "//div[@class='product-name']/h2")
	List<WebElement> products;

	@FindBy(xpath = "//button[@class='action tocart primary']")
	WebElement addCart;

	

	public void LoginUser(String Emails, String Passwords) throws InterruptedException {
		WaitforElementDisappear(3000);

		Actions a = new Actions(driver);
		a.moveToElement(LoginHover).build().perform();
		email.clear();
		WaitforElementDisappear(1000);
		email.sendKeys(Emails);
		password.clear();
		WaitforElementDisappear(1000);
		password.sendKeys(Passwords);
		WaitforElementDisappear(1000);
		submit.click();
		WaitforElementDisappear(1000);

	}

	public void alert_Login_Faiure_Message() throws InterruptedException {

		String message = alertMessage.getText();
		System.out.println(message);
		WaitforElementDisappear(2000);
		Assert.assertEquals(message,
				"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}

	public void alert_Success_Message() throws InterruptedException {

		String message = alertMessage.getText();
		System.out.println(message);
		WaitforElementDisappear(2000);
		Assert.assertEquals(message, "Customer login details has been verified fail.");
	}

	public void ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1450)");
	}

	public void Boutiqaat_Picks() throws InterruptedException {
		String[] itemsNeeded = { "Mirage" };
		int j = 0;
		for (WebElement product : products) {
			String[] prodname = product.getText().split("-");
			String[] prodname1 = prodname[0].split(" ");
			String formattedName = prodname1[0].trim();

			// format it to get name
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				j++;
				addCart.click();

				if (j == itemsNeeded.length)

					break;
			}
			WaitforElementDisappear(2000);

		}
	}

	public void Refresh() throws InterruptedException {
		driver.navigate().refresh();
		WaitforElementDisappear(2000);
	}

	
}