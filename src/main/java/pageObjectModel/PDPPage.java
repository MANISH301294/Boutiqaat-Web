package pageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponent.AbstractComponent;

public class PDPPage extends AbstractComponent {
	WebDriver driver;

	public PDPPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='col-md-7']/div[@class='product-info']/h1")
	WebElement ProdName;

	@FindBy(xpath = "//div[@class='product-info-price']/span[@class='regular-price price']")
	WebElement rglrPrice;

	@FindBy(xpath = "//span[@class='special-price price']")
	WebElement spclPrice;

	@FindBy(xpath = "//div[@class='product-info-price discount']/span[@class='regular-price price']")
	WebElement rglrDsctPrice;

	@FindBy(xpath = "//span[@class='discountpercent tag']")
	WebElement discount;

	@FindBy(xpath = "//h2[@class='brand-name-h2']")
	WebElement Brand;

	@FindBy(xpath = "//span[@style='visibility:hidden']")
	List<WebElement> Ratings;

	@FindBy(xpath = "//a[@class='reviewlink']")
	WebElement review;

	@FindBy(xpath = "//span[@class='staricon mb-3']/span")
	List<WebElement> rate;

	@FindBy(xpath = "//input[@name='title']")
	WebElement title;

	@FindBy(xpath = "//textarea[@name='comment']")
	WebElement comment;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	@FindBy(css = "div[role='alert']")
	WebElement alert;

	@FindBy(xpath = "//button[normalize-space()='Add Review']")
	WebElement Addreview;

	@FindBy(css = "div[class='product-attributes mb-3 mt-1'] ul li[class='']")
	List<WebElement> SelectSize;

	@FindBy(id = "increase")
	WebElement quantity;

	@FindBy(css = ".btn.wishlist.btn-secondary")
	WebElement Wish_List;

	@FindBy(xpath = "//td/h1")
	WebElement sku;

	@FindBy(xpath = "//a[@role='button']")
	List<WebElement> ImagesNo;

	@FindBy(xpath = "//button[@class='image-gallery-right-nav']")
	WebElement RightNav;

	@FindBy(xpath = "//button[@class='image-gallery-left-nav']")
	WebElement LeftNav;

	@FindBy(xpath = "//button[@class='image-gallery-fullscreen-button']")
	WebElement fullScreen;

	@FindBy(xpath = "//button[@class='image-gallery-fullscreen-button active']")
	WebElement CloseFullScreen;

	@FindBy(xpath = "//button[@class='btn addtocart btn-secondary']")
	WebElement Buy;

	public void Pdp_Page() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ProdName));
		// product Name
		System.out.println(ProdName.getText());

		// price of the product
		try {
			System.out.println("Regular Price = " + rglrPrice.getText());

		} catch (NoSuchElementException e) {
			System.out.println("Special Price = " + spclPrice.getText());
			System.out.println("Regular Price = " + rglrDsctPrice.getText());
			System.out.println("Discount = " + discount.getText());
		}

		// --------------------------------**Brand Name**------------------------------
		System.out.println("Brand Name = " + Brand.getText());
		// -------------------------------**Ratings of the product**--------------------
		System.out.println("Ratings of the Product = " + Ratings.size());
		WaitforElementDisappear(2000);
	}

	public void Ratings(String Title, String Comment) throws InterruptedException {
		// -------------------------------**Rate the Product**--------------------------

		if (review.getText().contains("Be the first to review")) {
			review.click();
			waitforElementToAppear(title);
			for (WebElement rates : rate) {
				Actions ac = new Actions(driver);
				ac.moveToElement(rates).click(rates).build().perform();
			}
			title.sendKeys(Title);
			comment.sendKeys(Comment);
			submit.click();
			WaitForElementToDisappear(alert);
		}

		else if (review.getText().contains("Reviews")) {
			review.click();
			Thread.sleep(1000);
			Addreview.click();
			for (WebElement rates : rate) {
				Actions ac = new Actions(driver);
				ac.moveToElement(rates).click(rates).build().perform();
			}

			title.sendKeys(Title);
			comment.sendKeys(Comment);
			submit.click();
			WaitForElementToDisappear(alert);
		}
	}

	// Select the size--------------
	public void SizeOfProduct() throws InterruptedException {
		for (WebElement Select : SelectSize) {

			String shoesize = Select.getText();
			System.out.print(shoesize + ",");
			
			if (shoesize.equals(shoesize)) 
			 {
				Select.click();
			}
			WaitforElementDisappear(2000);
		}
		quantity.click();
	}

	// wish list

	public void Wishlist() {
		String wish = "Added to Wishlist";
		if (Wish_List.getText().contains(wish)) {
			System.out.println();
			System.out.print(Wish_List.getText());
		} else {
			Wish_List.click();
		}
		System.out.println();
		System.out.println("SKU of the item = " + sku.getText());
	}

	public void Scrolling() throws InterruptedException {

		for (WebElement i : ImagesNo) {
			RightNav.click();
			//WaitforElementDisappear();
		}
		for (WebElement i : ImagesNo) {
			LeftNav.click();
			//WaitforElementDisappear();
		}

		fullScreen.click();
		WaitforElementDisappear(2000);
		for (WebElement i : ImagesNo) {
			RightNav.click();
			//WaitforElementDisappear();
		}
		for (WebElement i : ImagesNo) {
			LeftNav.click();
			//WaitforElementDisappear();
		}
		CloseFullScreen.click();
		WaitforElementDisappear(2000);
		Buy.click();
	}
}
