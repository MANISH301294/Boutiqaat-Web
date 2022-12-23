package testFiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDPpage {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String size = "XL";
		String wish = "Added to Wishlist";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.boutiqaat.com/en-kw/");
		driver.findElement(By.xpath("//span[normalize-space()='MEN']")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("m.rastogi1994@gmail.com");
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("Tester");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary col-12'][normalize-space()='LOGIN'])[2]")).click();
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1350)");
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//button[@class='action tocart primary'])[5]")).click();
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='col-md-7']/div[@class='product-info']/h1"))));

		System.out.println(
				driver.findElement(By.xpath("//div[@class='col-md-7']/div[@class='product-info']/h1")).getText());

		// ------------------------------**PRICE**------------------------------------	
		
		 try {
			   WebElement rglrPrice =   driver.findElement(By.xpath("//div[@class='product-info-price']/span[@class='regular-price price']"));
			        System.out.println("Regular Price = "+rglrPrice.getText());
			        
	  } catch (NoSuchElementException e) {
	   System.out.println("Special Price = "+driver.findElement(By.xpath("//span[@class='special-price price']")).getText());
	   System.out.println("Regular Price = "+driver.findElement(By.xpath("//div[@class='product-info-price discount']/span[@class='regular-price price']")).getText());
	   System.out.println("Discount = "+driver.findElement(By.xpath("//span[@class='discountpercent tag']")).getText());
			    }

		
		// --------------------------------**Brand Name**------------------------------
		String Brand = driver.findElement(By.xpath("//h2[@class='brand-name-h2']")).getText();
		System.out.println("Brand Name = " + Brand);

		// -------------------------------**Ratings of the product**--------------------
		List<WebElement> ratings = driver.findElements(By.xpath("//span[@style='visibility:hidden']"));
		int rating = ratings.size();
		System.out.println("Ratings of the Product = " + rating);
		Thread.sleep(3000);

		// -------------------------------**Rate the Product**--------------------------
		String first = "Be the first to review";
 		String second = "Reviews";
 	   String review =	driver.findElement(By.xpath("//a[@class='reviewlink']")).getText();
 	             if(review.contains(first))
 	             {
 	    driver.findElement(By.xpath("//a[@class='reviewlink']")).click();
 		Thread.sleep(1000);
 		List<WebElement> rate = driver.findElements(By.xpath("//span[@class='staricon mb-3']/span"));
     	for (int i=0;i<=4;i++)
     	{
     		WebElement rates = rate.get(i);
     	
     	Actions ac = new Actions(driver);
 	    	ac.moveToElement(rates).click(rates).build().perform();
     	}
 		driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Comfort");
 		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Very comfortable");
 		driver.findElement(By.xpath("//button[@type='submit']")).click();
 		String message = driver.findElement(By.cssSelector("div[role='alert']")).getText();
 		System.out.println(message);
 		Thread.sleep(2000);
 	             }
 	             
 	             else if(review.contains(second))
 	             {
 	            	 driver.findElement(By.xpath("//a[@class='reviewlink']")).click();
 	            	 Thread.sleep(1000);	 
 	            	 driver.findElement(By.xpath("//button[normalize-space()='Add Review']")).click();
 	            	List<WebElement> rate = driver.findElements(By.xpath("//span[@class='staricon mb-3']/span"));
 	            	for (int i=0;i<=4;i++)
 	            	{
 	            		WebElement rates = rate.get(i);
 	            	
 	            	Actions ac = new Actions(driver);
 	   	 	    	ac.moveToElement(rates).click(rates).build().perform();
 	            	}	            	
 	            	driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Comfort");
 	         		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Very comfortable");
 	         		driver.findElement(By.xpath("//button[@type='submit']")).click();
 	         		String message = driver.findElement(By.cssSelector("div[role='alert']")).getText();
 	        		System.out.println(message);
 	        		Thread.sleep(2000);	 
 	             }
		// -------------------------------** Select the size**-------------------------
		 List<WebElement> selectors = driver.findElements(By.cssSelector("div[class='product-attributes mb-3 mt-1'] ul li[class='']"));

		for (int i = 0; i < selectors.size(); i++) 
		{
			String shoesize = selectors.get(i).getText();
			System.out.print(shoesize + ",");
			
		
			if (shoesize.equals(shoesize)) 
			{

				selectors.get(i).click();
                
                
			}	
		}
		
		Thread.sleep(2000);
		// ----------------------------increase the size----------------

		driver.findElement(By.id("increase")).click();

		// ---------------------------add to wish list ----------

		String wishlist = driver.findElement(By.cssSelector(".btn.wishlist.btn-secondary")).getText();

		if (wishlist.contains(wish)) {
			System.out.println(wishlist);
		} else {
			driver.findElement(By.cssSelector(".btn.wishlist.btn-secondary")).click();
		}

		// -------------------------------** SKU of the item**------------------
		String SKU = driver.findElement(By.xpath("//td/h1")).getText();
		System.out.println();
		System.out.println("SKU of the item = " + SKU);

		// ----------------------------------** scrolling the image**-----------
		
		 List<WebElement> ImagesNo  =   driver.findElements(By.xpath("//a[@role='button']"));

		for (int i = 0; i < ImagesNo.size(); i++) 
		{
			driver.findElement(By.xpath("//button[@class='image-gallery-right-nav']")).click();
			Thread.sleep(1000);
		}
		for (int i = 0; i < ImagesNo.size(); i++)
		{
			driver.findElement(By.xpath("//button[@class='image-gallery-left-nav']")).click();
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//button[@class='image-gallery-fullscreen-button']")).click();
		Thread.sleep(1000);
		for (int i = 0; i < ImagesNo.size(); i++)
		{
		driver.findElement(By.xpath("//button[@class='image-gallery-right-nav']")).click();
		Thread.sleep(1000);
		}
		for (int i = 0; i < ImagesNo.size(); i++)
		{
		driver.findElement(By.xpath("//button[@class='image-gallery-left-nav']")).click();
		Thread.sleep(1000);
		}
		driver.findElement(By.xpath("//button[@class='image-gallery-fullscreen-button active']")).click();
		
		
		
	//----------------------------------**You may like this**-----------------------
		js.executeScript("window.scrollBy(0,1400)");
	System.out.println(driver.findElement(By.xpath("//h3")).getText());
	
	Thread.sleep(2000);
	
    List<WebElement> prodName=	driver.findElements(By.xpath("//div[@class='product-name']"));
	System.out.println("no. of item"+prodName.size());
	Thread.sleep(2000);
	for(int i=0;i<prodName.size();i++)
	{ 
		String description = prodName.get(i).getText();
		System.out.println(description);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".slick-next")).click();
		}
	driver.findElement(By.xpath("(//a[@class='action towishlist'])[12]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//button[@class='action tocart primary'])[12]")).click();
  
	}
}
