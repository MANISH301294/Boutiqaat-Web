package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class BrandPage extends AbstractComponent {

	WebDriver driver;

	public BrandPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a/h1)[3]")
	WebElement navBrand;

	@FindBy(xpath = "//div[@class='minicart']")
	WebElement move;

	@FindBy(xpath = "//span[@class='toolbar-number']")
	WebElement TotalBrand;

	@FindBy(xpath = "//div[@class='row alplhabet-grid']/a[@class='alphabutton']")
	List<WebElement> AlphaBrands;
	
	@FindBy(id="Fila")
	WebElement name;
	
	@FindBy(xpath="(//div[@class='container pl-2']/ul/li)[3]")
	WebElement brandName;

	public void Brand() throws InterruptedException {
		navBrand.click();
		// ---------------**Move element to different place**-------------
		Actions a = new Actions(driver);
		a.moveToElement(move).build().perform();
		waitforElementToAppear(TotalBrand);
		// -------------**Total Brands**---------------------
		String[] Brnds = TotalBrand.getText().split(" ");
		String TtlBrnds = Brnds[2];
		System.out.println("Total Brands = " + TtlBrnds);

		// -----------------**Get the Alphabet and Select J**--------------
		for (WebElement Item : AlphaBrands) {
			if (Item.getText().equals("F")) {
				Item.click();	
			}}
		waitforElementToAppear(name);
		WaitforElementDisappear(2000);
		    name.click();
		    waitforElementToAppear(brandName);
	}

}
