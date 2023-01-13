package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import abstractComponent.AbstractComponent;

public class AddressPage extends AbstractComponent {

	WebDriver driver;
  
   

	public AddressPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String Kuwait = "KWD";
	String Qatar = "QAR";
	String UAE = "AED";
	String Bahrain = "BHD";
	String SaudiArabia = "SAR";
	String Iraq = "USD";
	String Oman = "OMR";

	@FindBy(xpath = "(//tr[@class='grand-total']/td)[3]")
	WebElement crncy;

	@FindBy(css = " div[class='totals'] div button")
	WebElement Continue;

	@FindBy(xpath = "//h1")
	WebElement AddNew;

	@FindBy(id = "firstname")
	WebElement FirstName;

	@FindBy(id = "region_area")
	WebElement area;

	@FindBy(id = "addr_block")
	WebElement block;

	@FindBy(id = "addr_street")
	WebElement street;

	@FindBy(id = "addr_villa")
	WebElement villa;

	@FindBy(id = "telephone")
	WebElement telephone;

	@FindBy(css = ".btn.btn-primary.btn-addnew")
	WebElement submit;

	@FindBy(css = "strong[class='card-view-header']")
	WebElement ConfirmAddress;

	@FindBy(css = "a[ class='editaddresslink']")
	WebElement AddNewAddress;

	@FindBy(id = "address_line_1")
	WebElement AddressLine;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "id_number")
	WebElement civil_Id;
	 
	public void Add_Address(String Name,String Area,String Block,String Street,String Villa,String Mobile,String Address,String City,String Civil) throws InterruptedException {
		String Currency = crncy.getText();
		
		WaitforImplicitWait(10);
		System.out.println(Currency);
//---------------Kuwait----------------------		
		if (Currency.equalsIgnoreCase(Kuwait)) {
			Continue.click();
			
			WaitforElementDisappear(3000);
			try {
				AddNew.isDisplayed();
				FirstName.sendKeys(Name);
				Select drop = new Select(area);
				drop.selectByVisibleText(Area);
				WaitforElementDisappear(2000);
				Select drpdwn = new Select(block);
				drpdwn.selectByVisibleText(Block);
				street.sendKeys(Street);
				villa.sendKeys(Villa);
				telephone.sendKeys(Mobile);
				WaitforElementDisappear(2000);
				submit.click();
			} catch (NoSuchElementException e) {
				ConfirmAddress.isDisplayed();
				WaitforElementDisappear(1000);
				AddNewAddress.click();
				WaitforElementDisappear(1000);
				FirstName.sendKeys(Name);
				Select drop = new Select(area);
				drop.selectByVisibleText(Area);
				WaitforElementDisappear(2000);
				Select drpdwn = new Select(block);
				drpdwn.selectByVisibleText(Block);
				street.sendKeys(Street);
				villa.sendKeys(Villa);
				telephone.sendKeys(Mobile);
				WaitforElementDisappear(2000);
				submit.click();
			}
		}

		// ------------Qatar--------

		else if (Currency.equalsIgnoreCase(Qatar)) {
			Continue.click();
			WaitforElementDisappear(2000);
			try {
				AddNew.isDisplayed();
				FirstName.sendKeys("Qatar");
				AddressLine.sendKeys("1135,ABCD Nagar");
				Select drop = new Select(city);
				drop.selectByVisibleText("Doha");
				Select drpdwn = new Select(area);
				drpdwn.selectByVisibleText("Fereej Abdul Aziz");
				civil_Id.sendKeys("79879867676");
				telephone.sendKeys("4647678987");
				WaitforElementDisappear(2000);
				submit.click();
			}

			catch (NoSuchElementException e) {
				ConfirmAddress.isDisplayed();
				AddNewAddress.click();
				FirstName.sendKeys("Qata");
				AddressLine.sendKeys("113,AD Nagar");
				Select drop = new Select(city);
				drop.selectByVisibleText("Al Khor");
				Select drpdwn = new Select(area);
				drpdwn.selectByVisibleText("SMESMA Area");
				civil_Id.sendKeys("79875667676");
				telephone.sendKeys("4647458987");
				WaitforElementDisappear(2000);
				submit.click();
			}

		}
		// ----------------UAE--------------------
		else if (Currency.equalsIgnoreCase(UAE)) {
			Continue.click();
			WaitforElementDisappear(2000);
			try {
				AddNew.isDisplayed();
				FirstName.sendKeys("UAE State");
				AddressLine.sendKeys("1123 Saudi");
				Select drop = new Select(city);
				drop.selectByVisibleText("Abu Dhabi");
				Select drpdwn = new Select(area);
				drpdwn.selectByVisibleText("Al Khazna");
				civil_Id.sendKeys("89234434893");
				telephone.sendKeys("7843233323");
				WaitforElementDisappear(2000);
				submit.click();
			}

			catch (NoSuchElementException e) {
				ConfirmAddress.isDisplayed();
				AddNewAddress.click();
				FirstName.sendKeys("SUAE State a");
				AddressLine.sendKeys("1123 Saudi");
				Select drop = new Select(city);
				drop.selectByVisibleText("Dubai");
				Select drpdwn = new Select(area);
				drpdwn.selectByVisibleText("Al Warqa");
				civil_Id.sendKeys("89234486893");
				telephone.sendKeys("7843234323");
				WaitforElementDisappear(2000);
				submit.click();
			}

		}

		// -----------------------Bahrain-----

		else if (Currency.equalsIgnoreCase(Bahrain)) {
			Continue.click();
			WaitforElementDisappear(2000);
			try {
				AddNew.isDisplayed();
				FirstName.sendKeys("Bahrainian");
				AddressLine.sendKeys("1123 Saudi");
				Select drop = new Select(city);
				drop.selectByVisibleText("Central Governorate");
				Select drpdwn = new Select(area);
				drpdwn.selectByVisibleText("Nasfah");
				telephone.sendKeys("9786755654");
				WaitforElementDisappear(2000);
				submit.click();
			}

			catch (NoSuchElementException e) {
				ConfirmAddress.isDisplayed();
				AddNewAddress.click();
				FirstName.sendKeys("New Bahrain");
				AddressLine.sendKeys("1123 udi");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Capital Governorate");
				Select drpdwn = new Select(area);
				drpdwn.selectByVisibleText("Seef");
				telephone.sendKeys("8687687564");
				WaitforElementDisappear(2000);
				submit.click();

			}

		}
		// -------------SaudiArabia---------
		else if (Currency.equalsIgnoreCase(SaudiArabia)) {
			Continue.click();
			WaitforElementDisappear(2000);
			try {
				AddNew.isDisplayed();
				FirstName.sendKeys("Saudian");
				AddressLine.sendKeys("1123 Saudi");
				Select drop = new Select(city);
				drop.selectByVisibleText("Dawadmi");
				Select drpdwn = new Select(area);
				drpdwn.selectByVisibleText("Mugheeb");
				civil_Id.sendKeys("67467467465");
				telephone.sendKeys("9786755654");
				WaitforElementDisappear(2000);
				submit.click();
			}

			catch (NoSuchElementException e) {
				ConfirmAddress.isDisplayed();
				AddNewAddress.click();
				FirstName.sendKeys("Saudi arabian");
				AddressLine.sendKeys("1123 udi");
				Select drop = new Select(city);
				drop.selectByVisibleText("Jouf");
				Select drpdwn = new Select(area);
				drpdwn.selectByVisibleText("Al Jouf");
				civil_Id.sendKeys("67467467465");
				telephone.sendKeys("8687687564");
				WaitforElementDisappear(2000);
				submit.click();

			}

		}
		// -------------Iraq--------------
		else if (Currency.equalsIgnoreCase(Iraq)) {
			Continue.click();
			WaitforElementDisappear(2000);
			try {
				AddNew.isDisplayed();
				FirstName.sendKeys(Name);
				AddressLine.sendKeys(Address);
				Select drop = new Select(city);
				drop.selectByVisibleText(City);
				Select drpdwn = new Select(area);
				drpdwn.selectByVisibleText(Area);
				telephone.sendKeys("9375893243");
				WaitforElementDisappear(2000);
				submit.click();
			}
			catch (NoSuchElementException e) {
				ConfirmAddress.isDisplayed();
				WaitforElementDisappear(1000);
				AddNewAddress.click();
				WaitforElementDisappear(1000);
				FirstName.sendKeys(Name);
				AddressLine.sendKeys(Address);
				Select drop = new Select(city);
				drop.selectByVisibleText(City);
				Select drpdwn = new Select(area);
				drpdwn.selectByVisibleText(Area);
				telephone.sendKeys("9375893243");
				WaitforElementDisappear(2000);
				submit.click();

			}

		}
		// -----------------Oman-------------
		else if (Currency.equalsIgnoreCase(Oman)) {
			Continue.click();
			WaitforElementDisappear(2000);
			try {
				AddNew.isDisplayed();
				FirstName.sendKeys("Omanian");
				AddressLine.sendKeys("1123 Oman");
				Select drop = new Select(city);
				drop.selectByVisibleText("Al Saada");
				telephone.sendKeys("8287923288");
				WaitforElementDisappear(2000);
				submit.click();

			}

			catch (NoSuchElementException e) {
				ConfirmAddress.isDisplayed();
				AddNewAddress.click();
				FirstName.sendKeys("Oman");
				AddressLine.sendKeys("1123 yes");
				Select drop = new Select(city);
				drop.selectByVisibleText("Al Ashkarah");
				telephone.sendKeys("7986785678");
				WaitforElementDisappear(2000);
				submit.click();

			}

		}
		waitforElementToAppear(Continue);
		Continue.click();
		WaitforElementDisappear(2000);

	}
	
}
