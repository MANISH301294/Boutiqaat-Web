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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPlp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
	//------------------**User Login**---------------------------------------
		
		driver.get("https://www.boutiqaat.com/en-kw/men/");
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("m.rastogi1994@gmail.com");
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("Tester");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary col-12'][normalize-space()='LOGIN'])[2]")).click();
		Thread.sleep(3000);

		
		//-------------------**NavBar**-------------------------
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='links welcome seperator']")));
	WebElement navBar =	driver.findElement(By.xpath("//ul/li[@class='level-2 nav-item ddfull subnav']"));
	Actions a = new Actions(driver);
	a.moveToElement(navBar).build().perform();
	List<WebElement> ScndCtgry = driver.findElements(By.xpath("//ul/li[@class='level-2 nav-item ddfull subnav']/div/ul/li/a"));
	System.out.print("Second level Categories = ");
	for(WebElement scndLevel:ScndCtgry)
	{		
		a.moveToElement(scndLevel, 0, ScndCtgry.size()).build().perform();			
		System.out.println(scndLevel.getText()+",");
	}
	System.out.println();
	System.out.print("Third level of Categories = ");
	List<WebElement> ThrdCtgry = driver.findElements(By.xpath("//li[@class='level-2 nav-item ddfull subnav']/div/ul/li/div/ul/li"));
	System.out.println(ThrdCtgry.size());
	for(WebElement ThrdCtgries:ThrdCtgry)
	{
		Actions ac =new Actions(driver);
		ac.moveToElement(navBar, 0,21).build().perform();
		System.out.print(ThrdCtgries.getText()+",");		
	}
	for(WebElement ctgry:ThrdCtgry)
	{
		if(ctgry.getText().equals("SHORTS"))
		{
			ctgry.click();
		}
	}
	Thread.sleep(3000);
	
	//--------------------------------------------------------------------------------------
	 //------------------------ **PLP**----------------------------------------------------
	 //-----------------------------------------------------------------------------------
	  JavascriptExecutor js =  (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,500)");
	  Thread.sleep(2000);
	  js.executeScript("window.scrollBy(0,2000)");
	  Thread.sleep(3000);
	  List<WebElement> plpItem =   driver.findElements(By.xpath("//div[@class='product-item-details pb-2']"));
	  int noOfItem  =   plpItem.size();
	  System.out.println(noOfItem);
	  Thread.sleep(2000);
	  
	  //----------------**Go to top & Refresh the page**---------------------
	  driver.findElement(By.id("myBtn")).click();
	  driver.navigate().refresh();
	  js.executeScript("window.scrollBy(0,500)");
	  Thread.sleep(2000);
	  
	  //---------------**Sort**-------------------------
	  WebElement sort = driver.findElement(By.id("sorter"));
	  Select dropdown = new Select(sort);
	  dropdown.selectByVisibleText("Price: High to Low");
	  Thread.sleep(3000);
	  System.out.println("sort = "+dropdown.getFirstSelectedOption().getText());
	  
	//----------------** Filter By Category **----------------------------------
	  //no. of filter 
	  js.executeScript("window.scrollBy(0,1000)");
	  Thread.sleep(2000);
	  
	 
	  String subCat = "adidas";
	  List<WebElement> filters = driver.findElements(By.tagName("dt"));
	  for(WebElement filter:filters)
	  {
		  
		 System.out.print(filter.getText()+" ");
		  
		  if(filter.getText().equals("Brand"))
		  {
			  List<WebElement> catfltr = driver.findElements(By.xpath("//div/div[@style='display: flex;']"));
			  System.out.println("SubCategories are = "+catfltr.size());
			  for(WebElement catsfltrs:catfltr)
			  {
				  System.out.print(catsfltrs.getText()+" "+",");		  
				  
				 if(catsfltrs.getText().contains(subCat))
				  {
					driver.findElement(By.xpath("//input[@data-facet='true']")).click();
					  
					  Thread.sleep(3000);
					  break;
				  }
				 break;
				 
				  }
			  break;
			  }
		  break;
		  }
	//----------------------**Product item Block **-------------
	    
	  List<WebElement> item = driver.findElements(By.xpath("//div[@class='product-item-details pb-2']"));

	  for(WebElement Prodinfo:item)
	  {
	  	System.out.println(Prodinfo.getText());
	  }
	  	
	  List<WebElement> addTo = driver.findElements(By.xpath("//div[@class='product-item-actions']/button"));

	   for(WebElement addToCart:addTo)
	   {
	  	  if(addToCart.getText().equals("Buy Now"))
	  	  {
	  		  addToCart.click();
	  		  Thread.sleep(2000);
	  	  }
	  	  
	  	  else if(addToCart.getText().equals("Notify Me"))
	  	  {
	  		  Thread.sleep(3000);
	  		  addToCart.click();
	  	
	  		  driver.findElement(By.name("name")).sendKeys("Test");
	  		 
	  		  driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("Test107@tester.com");
	  		 
	  		  driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("849357358");
	  		  
	  		  driver.findElement(By.xpath("(//button[@class='btn btn-primary col-12'])[2]")).click();
	  	  }
	  	  else if(addToCart.getText().equals("View"))
	  	  {
	  		  addToCart.click();
	  		  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='col-md-7']/div[@class='product-info']/h1"))));
	  		System.out.println(
					driver.findElement(By.xpath("//div[@class='col-md-7']/div[@class='product-info']/h1")).getText());
	  		String size = "XL";
			String wish = "Added to Wishlist";
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
			 List<WebElement> selectors = driver.findElements(By.xpath("//div[@class='product-attributes mb-3 mt-1']/ul/li"));

			for (int i = 0; i < selectors.size(); i++) 
			{
				String shoesize = selectors.get(i).getText();
				System.out.print(shoesize + ",");
				if (shoesize.equals(size)) 
				{

					selectors.get(i).click();

				}
				Thread.sleep(2000);

			}

			// ----------------------------increase the Quantity----------------

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
	  		Thread.sleep(1000);
	  		driver.findElement(By.xpath("//button[@class='btn addtocart btn-secondary']")).click();
			break;
	  	  }
	  	  
	   }  
}}
