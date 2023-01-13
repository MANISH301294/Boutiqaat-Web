package testFiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.boutiqaat.com/en-kw/men/");
		
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("m.rastogi1994@gmail.com");
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("Tester");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary col-12'][normalize-space()='LOGIN'])[2]")).click();
		Thread.sleep(3000);
		
		
		//**------------------MiniCartItem**------------
		driver.findElement(By.xpath("//div[@class='minicart']")).click();
		WebElement t = driver.findElement(By.xpath("//div[@class='minicart']"));
		String s = t.getCssValue("color");
		String c = Color.fromString(s).asHex();
		System.out.println("color is"+s);
		System.out.println("Hex is"+ c);
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
			//---------Continue to Payment----
		WebElement ContinuePayment = 	driver.findElement(By.cssSelector(" div[class='totals'] div button"));
		ContinuePayment.click();
		
			
			Thread.sleep(2000);
	
	Thread.sleep(2000);
	
	try {
		driver.findElement(By.cssSelector("strong[class='card-view-header']")).isDisplayed();
		driver.findElement(By.xpath("//a[@class='editaddresslink']")).click();
		driver.findElement(By.id("firstname")).sendKeys("Test");
	    WebElement area = driver.findElement(By.id("region_area"));
	    Select drop = new Select(area);
	    drop.selectByVisibleText("Abu Halifa");
	    Thread.sleep(1000);
	    WebElement block = driver.findElement(By.id("addr_block"));
	    Select drpdwn = new Select(block);
	    drpdwn.selectByVisibleText("2");
		
	}
	catch(NoSuchElementException e)
	{
		driver.findElement(By.xpath("//h1")).isDisplayed();
		driver.findElement(By.id("firstname")).sendKeys("Test");
		driver.findElement(By.id("addr_villa")).sendKeys("1234");
		driver.findElement(By.id("addr_flatenumber")).sendKeys("150");
		driver.findElement(By.id("addr_floornumber")).sendKeys("2");
		driver.findElement(By.id("address_line_1")).sendKeys("Block-D");
		//-------------**City**---------------------
	    WebElement city = driver.findElement(By.id("city"));
	    Select dropdown = new Select(city);
	    dropdown.selectByVisibleText("Al Ghazir");
	    Thread.sleep(2000);
	    System.out.println("city = "+dropdown.getFirstSelectedOption().getText());
	    driver.findElement(By.id("addr_postcode")).sendKeys("110074");
	    driver.findElement(By.id("telephone")).sendKeys("5439858934");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@class='btn btn-primary btn-addnew']")).click();
	    driver.findElement(By.xpath("//button[@class='wishlist btn-secondary col-12']")).click();
	    Thread.sleep(2000);
	  System.out.println(driver.findElement(By.xpath("//p/p")).getText());
//	  driver.findElement(By.xpath("//button[@type='button']")).click();
	}    
	}

}
