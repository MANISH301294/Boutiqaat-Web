package pageObjectModel;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class HomePage extends AbstractComponent {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".logo")
	WebElement Logo;

	@FindBy(xpath = "//ul[@class='navbar-nav']/li")
	List<WebElement> navBar;

	@FindBy(xpath = "//div[@class='searchCont searchBox position-relative far hint']")
	WebElement move;

	@FindBy(xpath = "//div[@class='flag-select menu-flags']")
	WebElement country;

	@FindBy(xpath = "//div[@class='links'][2]")
	WebElement wish;

	@FindBy(xpath = "//span[@class='cartCount']")
	WebElement top;
	
	@FindBy(id = "myBtn")
	WebElement BackToTop;

	// --------------BoutiQaat LOGO------------
	public void Logobouti() throws InterruptedException {
		Logo.click();
		WaitforElementDisappear(3000);
	}

	// ------------ Navigation-------------
	public void Nav() throws InterruptedException {
		WaitforElementDisappear(4000);
		for (WebElement nav : navBar) {
			System.out.println(nav.getText());
			Actions a = new Actions(driver);
			a.moveToElement(nav, 0, navBar.size()).build().perform();
			WaitforElementDisappear(400);

		}
	}

	// -----------Global Search----------------

	public void Global_Search(String SubCategory) throws InterruptedException {
		WaitforElementDisappear(2000);
		Actions a = new Actions(driver);
		a.moveToElement(move).click().keyDown(Keys.LEFT_SHIFT).sendKeys(SubCategory).sendKeys(Keys.ENTER).build()
				.perform();
		WaitforElementDisappear(2000);
		driver.navigate().back();

	}
	// -------------Country Name --------------------
	public void Country_Name() throws InterruptedException {
		String countryName = country.getText();
		String Countryname = countryName.substring(0, 6);
		System.out.println("Country=" + Countryname);
		WaitforElementDisappear(2000);
	}
	// ---------------WishList count --------------
	public void WishList() throws InterruptedException {
		WaitforElementDisappear(2000);
		String wishes = wish.getText();
		String Wishlist = wishes.substring(10, 12);
		System.out.println("WishlistCount=" + Wishlist);
		
	}
	// ------------------Cart size--------------------
	public void cart_Size() {
		System.out.println("cart size = " + top.getText());
	}
	
	// ------------------Back To Top----------------
	public void Back_to_Top() {
		BackToTop.click();
	}

}
