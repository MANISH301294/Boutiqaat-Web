package pageObjectModel;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponent.AbstractComponent;

public class Celebritypage extends AbstractComponent {

	WebDriver driver;

	public Celebritypage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[text()='Celebrities']/parent::a/parent::li")
	WebElement Celebrities;

	@FindBy(xpath = "//label[@class='desktopSearch']")
	WebElement moveTOEle;

	@FindBy(xpath = "//span[@class='toolbar-number']")
	WebElement NoOfCeleb;

	@FindBy(xpath = "//div/button[@type='button']")
	List<WebElement> alphas;

	@FindBy(xpath = "//div/ul/li/a/h2")
	List<WebElement> CelebsNo;

	@FindBy(xpath = "//button[@value='H']")
	WebElement Alpha_H;

	@FindBy(xpath = "//h2")
	List<WebElement> FilterCeleb;

	@FindBy(xpath = "//input[@type='search']")
	WebElement CelebSearch;

	@FindBy(xpath = "//a[@href='/en-kw/men/'][normalize-space()='Yousef Al Mohammed']")
	WebElement ConfirmCeleb;
	
	 @FindBy(xpath="//div[@class='links'][2]")
	  WebElement wish;

	// ----------------------**Celebrity page -------------------
	public void Clebrity() throws InterruptedException {
		Celebrities.click();
		WaitforElementDisappear(3000);
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		String parentId = it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		System.out.println("window change");
		driver.switchTo().window(parentId).close();
		driver.switchTo().window(ChildId);
		WaitforElementDisappear(2000);
		String[] celeb = NoOfCeleb.getText().split(" ");
		System.out.println("No. of celebrities = " + celeb[3]);
	}

	// ---------------------------** no. of alphabet filter ----------------
	public void Alphano() throws InterruptedException {
		System.out.println(alphas.size());
		System.out.print("Alphabets are =");
		for (WebElement alpha : alphas) {
			System.out.print(alpha.getText() + ",");
		}
		System.out.println();

		// ----------------** no. of celebrities--------------------
		System.out.println("No. of celebrities = " + CelebsNo.size());
		for (WebElement CelebName : CelebsNo) {
			System.out.println(" = " + CelebName.getText());
		}
		// -----------------**Filter with Alphabet**----------
		Alpha_H.click();
		WaitforElementDisappear(2000);
		System.out.println("No. of celebs whose name start with 'H' = " + FilterCeleb.size());
		WaitforElementDisappear(3000);
	}
	// ----------------------**Search with Name** -------------------
	public void SearchCeleb(String CelebName) throws InterruptedException {
		CelebSearch.sendKeys(CelebName);
		WaitforElementDisappear(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		for (WebElement FilterName : FilterCeleb) {
			System.out.println(FilterName.getText());
			if (FilterName.getText().equalsIgnoreCase(CelebName)) {
				FilterName.click();
			}
		}
		WaitforElementDisappear(2000);
	System.out.println("Celebrity Name = "+CelebName);
		Assert.assertEquals(CelebName,ConfirmCeleb.getText());
	}

}