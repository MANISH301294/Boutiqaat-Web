package testFiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrandPlp {

	public static void main(String[] args) throws InterruptedException   {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chorme.driver", "C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://www.boutiqaat.com/en-kw/men/");

		//----------------------** NavBar **--------------------------------
	List<WebElement> navBar = 	driver.findElements(By.xpath("//div[@class='collapse navbar-collapse']/ul/li"));
     System.out.println(navBar.size());
     for(WebElement navTab:navBar)
     {
    	 System.out.println(navTab.getText());
     }
     
     driver.findElement(By.xpath("(//a/h1)[3]")).click();
     
     //---------------**Move element to different place**-------------
     driver.findElement(By.xpath("//div[@class='minicart']")).getText();
     Actions a = new Actions(driver);
     a.moveToElement(driver.findElement(By.xpath("//div[@class='minicart']"))).build().perform();
     
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='toolbar-number']")));
     
     //  -------------**Total Brands**---------------------
     
  String[] Brnds = driver.findElement(By.xpath("//span[@class='toolbar-number']")).getText().split(" ");
     String TtlBrnds = Brnds[2];
     System.out.println("Total Brands = "+TtlBrnds);
     
     //-----------------**Get the Alphabet and Select J**--------------
     
  List<WebElement> BrandItem =   driver.findElements(By.xpath("//div[@class='row alplhabet-grid']/a[@class='alphabutton']"));
  for(WebElement Item: BrandItem)
  {
	System.out.println(Item.getText());
	if(Item.getText().equals("J"))
	{
	Item.click();
	}
	
  } 
  
  //------------**Select Brand Jack &Jones **---------------
  
  driver.findElement(By.id("Jack & Jones")).click();
  
  
  //--------------------------------------------------------------------------------------
 //------------------------ **PLP**-----------------------------------------------------
//-----------------------------------------------------------------------------------
  JavascriptExecutor js =  (JavascriptExecutor)driver;
  js.executeScript("window.scrollBy(0,500)");
  Thread.sleep(2000);
  js.executeScript("window.scrollBy(0,2000)");
  Thread.sleep(3000);
  
  // ----------------**Get The PLP size**--------------------------------
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
  Thread.sleep(2000);
  System.out.println("sort = "+dropdown.getFirstSelectedOption().getText());
  
//----------------**Filter By Category**----------------------------------
  //no. of filter 
  js.executeScript("window.scrollBy(0,700)");
  Thread.sleep(3000);
  
 
  String subCat = "Accessories";
  List<WebElement> filters = driver.findElements(By.tagName("dt"));
  for(WebElement filter:filters)
  {
	  
	// System.out.print(filter.getText()+" ");
	  
	  if(filter.getText().equals("Category"))
	  {
		  List<WebElement> catfltr = driver.findElements(By.xpath("//div/div[@style='display: flex;']"));
		  System.out.println("SubCategories are = "+catfltr.size());
		  for(WebElement catsfltrs:catfltr)
		  {
			  System.out.print(catsfltrs.getText()+" "+",");		  
			  
			 if(catsfltrs.getText().contains(subCat))
			  {
				catsfltrs.findElement(By.xpath("//input[@data-facet='true']")).click();
				  
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
		  break;
	  }
	  
	  
	  else if(addToCart.getText().equals("Notify Me"))
	  {
		  Thread.sleep(3000);
		  addToCart.click();
	
		  driver.findElement(By.name("name")).sendKeys("Test");
		 
		  driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("Test107@tester.com");
		 
		  driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("849357358");
		  
		  driver.findElement(By.xpath("(//button[@class='btn btn-primary col-12'])[2]")).click();
		  break;
	  }
	  else if(addToCart.getText().equals("View"))
	  {
		  addToCart.click();
		  break;
	  }
	  break;
 }
//-----------------**Goto Top**--------------------- 
 //driver.findElement(By.id("myBtn")).click();
 //Thread.sleep(2000);
 //driver.findElement(By.xpath("//a[@class='logo']")).click();
  
	}

}
