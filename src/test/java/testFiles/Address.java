package testFiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Address {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.boutiqaat.com/en-kw/men/");
		
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("m.rastogi1994@gmail.com");
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("Tester");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary col-12'][normalize-space()='LOGIN'])[2]"))
				.click();
		Thread.sleep(3000);

		String Kuwait = "KWD";
		String Qatar = "QAR";
		String UAE = "AED";
		String Bahrain = "BHD";
		String SaudiArabia = "SAR";
		String Iraq = "USD";
		String Oman = "OMR";
				
		//**------------------MiniCartItem**------------
		driver.findElement(By.xpath("//div[@class='minicart']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='mincart-text']"))));
		String CartItm = driver.findElement(By.xpath("//p[@class='mincart-text']/strong")).getText();
		System.out.println("No. of items in Mini cart = "+CartItm);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary checkout white']")).click();
		
		//-----------------**CartItem**------------------------
		Thread.sleep(2000);
	    String[] Cart = 	driver.findElement(By.xpath("//div[@class='qty-item']")).getText().split(" ");
	    String[] cartIt = Cart[1].split("");
	    String CartItems = cartIt[1];
	    System.out.println("No.of items in Cart = "+CartItems);
	    Assert.assertEquals(CartItm, CartItems);
	
	  //--------------------**Bag total**------------------------
	 String BagTtl =  driver.findElement(By.xpath("//div[@class='bag-total']")).getText();
	System.out.println(BagTtl);
    
	 //--------------------**Products**-------------
	List<WebElement> prdcts = driver.findElements(By.xpath("//ul"));
	System.out.println(prdcts.size());
	for(WebElement crtPrdct:prdcts)
	{
	System.out.println(crtPrdct.getText());
   // System.out.println(prdcts.get(i).findElement(By.xpath("//div[@class='price-container']")).getText());
	}
	
	//------------Add to Wish list----
	
			List<WebElement> wish =driver.findElements(By.cssSelector(" button span[class='wishlist-link']"));
			
			for(WebElement wishlist:wish)
			{
				wishlist.click();	
			}

		String Currency = driver.findElement(By.xpath("(//tr[@class='grand-total']/td)[3]")).getText();
		// ---------Kuwait----------
		
		
		if (Currency.equalsIgnoreCase(Kuwait)) {
			driver.findElement(By.cssSelector(" div[class='totals'] div button")).click();
			try {
				driver.findElement(By.xpath("//h1")).isDisplayed();
				driver.findElement(By.id("firstname")).sendKeys("Kuwai");
				WebElement area = driver.findElement(By.id("region_area"));
				Select drop = new Select(area);
				drop.selectByVisibleText("Abu Halifa");
				Thread.sleep(1000);
				WebElement block = driver.findElement(By.id("addr_block"));
				Select drpdwn = new Select(block);
				drpdwn.selectByVisibleText("2");
				driver.findElement(By.id("addr_street")).sendKeys("k-7/149");
				driver.findElement(By.id("addr_villa")).sendKeys("145");
				driver.findElement(By.id("telephone")).sendKeys("4647678987");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.cssSelector("strong[class='card-view-header']")).isDisplayed();
				driver.findElement(By.cssSelector("a[ class='editaddresslink']")).click();
				driver.findElement(By.id("firstname")).sendKeys("Kuwait");
				WebElement area = driver.findElement(By.id("region_area"));
				Select drop = new Select(area);
				drop.selectByVisibleText("Abu Halifa");
				Thread.sleep(1000);
				WebElement block = driver.findElement(By.id("addr_block"));
				Select drpdwn = new Select(block);
				drpdwn.selectByVisibleText("2");
				driver.findElement(By.id("addr_street")).sendKeys("k-7/149");
				driver.findElement(By.id("addr_villa")).sendKeys("145");
				driver.findElement(By.id("telephone")).sendKeys("4647678987");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();
			}
		}
		
		//------------Qatar--------

		else if (Currency.equalsIgnoreCase(Qatar)) {
			driver.findElement(By.cssSelector(" div[class='totals'] div button")).click();
			try {
				driver.findElement(By.xpath("//h1")).isDisplayed();
				driver.findElement(By.id("firstname")).sendKeys("Qatar");
				driver.findElement(By.id("address_line_1")).sendKeys("1135,ABCD Nagar");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Doha");
				WebElement Area = driver.findElement(By.id("region_area"));
				Select drpdwn = new Select(Area);
				drpdwn.selectByVisibleText("Fereej Abdul Aziz");
				driver.findElement(By.id("id_number")).sendKeys("79879867676");
				driver.findElement(By.id("telephone")).sendKeys("4647678987");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();
			}

			catch (NoSuchElementException e) {
				driver.findElement(By.cssSelector("strong[class='card-view-header']")).isDisplayed();
				driver.findElement(By.cssSelector("a[ class='editaddresslink']")).click();
				driver.findElement(By.id("firstname")).sendKeys("Qata");
				driver.findElement(By.id("address_line_1")).sendKeys("113,AD Nagar");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Al Khor");
				WebElement Area = driver.findElement(By.id("region_area"));
				Select drpdwn = new Select(Area);
				drpdwn.selectByVisibleText("SMESMA Area");
				driver.findElement(By.id("id_number")).sendKeys("79875667676");
				driver.findElement(By.id("telephone")).sendKeys("4647458987");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();
			}

		}
         //----------------UAE--------------------
		else if (Currency.equalsIgnoreCase(UAE)) {
			driver.findElement(By.cssSelector(" div[class='totals'] div button")).click();
			try {
				driver.findElement(By.xpath("//h1")).isDisplayed();
				driver.findElement(By.id("firstname")).sendKeys("UAE State");
				driver.findElement(By.id("address_line_1")).sendKeys("1123 Saudi");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Abu Dhabi");
				WebElement Area = driver.findElement(By.id("region_area"));
				Select drpdwn = new Select(Area);
				drpdwn.selectByVisibleText("Al Khazna");
				driver.findElement(By.id("id_number")).sendKeys("89234434893");
				driver.findElement(By.id("telephone")).sendKeys("7843233323");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();
			}

			catch (NoSuchElementException e) {
				driver.findElement(By.cssSelector("strong[class='card-view-header']")).isDisplayed();
				driver.findElement(By.cssSelector("a[ class='editaddresslink']")).click();
				driver.findElement(By.id("firstname")).sendKeys("SUAE State a");
				driver.findElement(By.id("address_line_1")).sendKeys("1123 Saudi");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Dubai");
				WebElement Area = driver.findElement(By.id("region_area"));
				Select drpdwn = new Select(Area);
				drpdwn.selectByVisibleText("Al Warqa");
				driver.findElement(By.id("id_number")).sendKeys("89234486893");
				driver.findElement(By.id("telephone")).sendKeys("7843234323");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();

			}

		}
		//-----------------------Bahrain-----

		else if (Currency.equalsIgnoreCase(Bahrain)) {
			driver.findElement(By.cssSelector(" div[class='totals'] div button")).click();
			try {
				driver.findElement(By.xpath("//h1")).isDisplayed();
				driver.findElement(By.id("firstname")).sendKeys("Bahrainian");
				driver.findElement(By.id("address_line_1")).sendKeys("1123 Saudi");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Central Governorate");
				WebElement Area = driver.findElement(By.id("region_area"));
				Select drpdwn = new Select(Area);
				drpdwn.selectByVisibleText("Nasfah");
				driver.findElement(By.id("telephone")).sendKeys("9786755654");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();
			}

			catch (NoSuchElementException e) {
				driver.findElement(By.cssSelector("strong[class='card-view-header']")).isDisplayed();
				driver.findElement(By.cssSelector("a[ class='editaddresslink']")).click();
				driver.findElement(By.id("firstname")).sendKeys("New Bahrain");
				driver.findElement(By.id("address_line_1")).sendKeys("1123 udi");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Capital Governorate");
				WebElement Area = driver.findElement(By.id("region_area"));
				Select drpdwn = new Select(Area);
				drpdwn.selectByVisibleText("Seef");
				driver.findElement(By.id("telephone")).sendKeys("8687687564");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();

			}

		}
              // -------------SaudiArabia---------
		else if (Currency.equalsIgnoreCase(SaudiArabia)) {
			driver.findElement(By.cssSelector(" div[class='totals'] div button")).click();
			try {
				driver.findElement(By.xpath("//h1")).isDisplayed();
				driver.findElement(By.id("firstname")).sendKeys("Saudian");
				driver.findElement(By.id("address_line_1")).sendKeys("1123 Saudi");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Dawadmi");
				WebElement Area = driver.findElement(By.id("region_area"));
				Select drpdwn = new Select(Area);
				drpdwn.selectByVisibleText("Mugheeb");
				driver.findElement(By.id("id_number")).sendKeys("67467467465");
				driver.findElement(By.id("telephone")).sendKeys("9786755654");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();
			}

			catch (NoSuchElementException e) {
				driver.findElement(By.cssSelector("strong[class='card-view-header']")).isDisplayed();
				driver.findElement(By.cssSelector("a[ class='editaddresslink']")).click();
				driver.findElement(By.id("firstname")).sendKeys("Saudi arabian");
				driver.findElement(By.id("address_line_1")).sendKeys("1123 udi");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Jouf");
				WebElement Area = driver.findElement(By.id("region_area"));
				Select drpdwn = new Select(Area);
				drpdwn.selectByVisibleText("Al Jouf");
				driver.findElement(By.id("id_number")).sendKeys("67467467465");
				driver.findElement(By.id("telephone")).sendKeys("8687687564");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();

			}

		}
        // -------------Iraq--------------
		else if (Currency.equalsIgnoreCase(Iraq)) {
			driver.findElement(By.cssSelector(" div[class='totals'] div button")).click();
			try {
				driver.findElement(By.xpath("//h1")).isDisplayed();
				driver.findElement(By.id("firstname")).sendKeys("Iraqian");
				driver.findElement(By.id("address_line_1")).sendKeys("1123 Iraq");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Al Najaf");
				WebElement Area = driver.findElement(By.id("region_area"));
				Select drpdwn = new Select(Area);
				drpdwn.selectByVisibleText("Al Qadisiya");
				driver.findElement(By.id("telephone")).sendKeys("9375893243");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();
			}

			catch (NoSuchElementException e) {
				driver.findElement(By.cssSelector("strong[class='card-view-header']")).isDisplayed();
				driver.findElement(By.cssSelector("a[ class='editaddresslink']")).click();
				driver.findElement(By.id("firstname")).sendKeys("Iraqin");
				driver.findElement(By.id("address_line_1")).sendKeys("1165 Iraq");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Mousl (Nainawa)");
				WebElement Area = driver.findElement(By.id("region_area"));
				Select drpdwn = new Select(Area);
				drpdwn.selectByVisibleText("Al Qayara");
				driver.findElement(By.id("telephone")).sendKeys("9375843243");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();

			}

		}
           //-----------------Oman-------------
		else if (Currency.equalsIgnoreCase(Oman)) {
			driver.findElement(By.cssSelector(" div[class='totals'] div button")).click();
			try {
				driver.findElement(By.xpath("//h1")).isDisplayed();
				driver.findElement(By.id("firstname")).sendKeys("Omanian");
				driver.findElement(By.id("address_line_1")).sendKeys("1123 Oman");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Al Saada");
				driver.findElement(By.id("telephone")).sendKeys("8287923288");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();

			}

			catch (NoSuchElementException e) {
				driver.findElement(By.cssSelector("strong[class='card-view-header']")).isDisplayed();
				driver.findElement(By.cssSelector("a[ class='editaddresslink']")).click();
				driver.findElement(By.id("firstname")).sendKeys("Oman");
				driver.findElement(By.id("address_line_1")).sendKeys("1123 yes");
				WebElement city = driver.findElement(By.id("city"));
				Select drop = new Select(city);
				drop.selectByVisibleText("Al Ashkarah");
				driver.findElement(By.id("telephone")).sendKeys("7986785678");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-addnew")).click();

			}

		}
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(" div[class='totals'] div button"))));
		
		driver.findElement(By.cssSelector(" div[class='totals'] div button")).click();
		
		Thread.sleep(2000);
		
		
		
		
		try {
			driver.findElement(By.xpath("//h5")).isDisplayed();
			System.out.println(driver.findElement(By.xpath("//p/p")).getText());
			driver.findElement(By.cssSelector("button[type='button']")).click();
		  Thread.sleep(1000);
		List<WebElement> PaymentMethod =driver.findElements(By.cssSelector("label[class='radio-inline align-middle label-payment']"));
		for(WebElement method:PaymentMethod)
		{
			System.out.println(method.getText());
			if(method.getText().equals("Cash on delivery"))
			{
				driver.findElement(By.cssSelector("label[class='radio-inline align-middle label-payment'] input")).click();
			}
		}
			
		}
		catch(NoSuchElementException e)
		{
			List<WebElement> PaymentMethod =driver.findElements(By.cssSelector("label[class='radio-inline align-middle label-payment']"));
			for(WebElement method:PaymentMethod)
			{
				System.out.println(method.getText());
				if(method.getText().equals("Cash on delivery"))
				{
					driver.findElement(By.cssSelector("label[class='radio-inline align-middle label-payment'] input")).click();
				}
			}
				
			}
		
		       driver.findElement(By.cssSelector(" div[class='totals'] div button")).click();
		}

	}


