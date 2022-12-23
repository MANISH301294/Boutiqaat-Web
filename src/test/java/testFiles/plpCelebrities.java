package testFiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class plpCelebrities {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.boutiqaat.com/en-kw/men/");

		List<WebElement> navBar = driver.findElements(By.xpath("//ul[@class='navbar-nav']/li"));

		for (WebElement nav : navBar) {

			System.out.println(nav.getText());
			Actions a = new Actions(driver);
			a.moveToElement(nav, 0, navBar.size()).build().perform();
		}

		Thread.sleep(3000);

		// ----------------------**Celebrity page -------------------
		driver.findElement(By.xpath("(//a/h1)[2]")).click();
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//label[@class='desktopSearch']"))).build().perform();
		Thread.sleep(2000);
		String[] celeb = driver.findElement(By.xpath("//span[@class='toolbar-number']")).getText().split(" ");
		System.out.println("No. of celebrities = " + celeb[3]);

		// ---------------------------** no. of alphabet filter ----------------

		List<WebElement> alphas = driver.findElements(By.xpath("//div/button[@type='button']"));
		System.out.println(alphas.size());
		System.out.print("Alphabets are =");
		for (int i = 0; i < alphas.size(); i++) {

			String alpha = alphas.get(i).getText();

			System.out.print(alpha + ",");

		}
		System.out.println();

		// ----------------** no. of celebrities--------------------

		List<WebElement> celebsNo = driver.findElements(By.xpath("//div/ul/li/a/h2"));
		System.out.println("No. of celebrities = " + celebsNo.size());
		for (int i = 0; i < celebsNo.size(); i++) {
			String celebsName = celebsNo.get(i).getText();
			System.out.print(i);
			System.out.println(" = " + celebsName);

		}

		// -----------------**Filter with Alphabet**----------
		driver.findElement(By.xpath("//button[@value='H']")).click();
		Thread.sleep(2000);
		List<WebElement> celebsNoElement = driver.findElements(By.xpath("//h2"));
		System.out.println("No. of celebs whose name start with 'H' = " + celebsNoElement.size());
		Thread.sleep(2000);

		// ----------------------**Search with Name** -------------------
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Yousef Al Mohammed");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		String CeleName = "YOUSEF AL MOHAMMED";
		List<WebElement> SearchList = driver.findElements(By.xpath("//h2"));
		for (WebElement FilterName : SearchList) {
			System.out.println(FilterName.getText());
			if (FilterName.getText().equalsIgnoreCase(CeleName)) {
				FilterName.click();
			}
		}
		Thread.sleep(3000);

		// ------------------- **Confirm the celebrity Name**
		// -----------------------------
		String celebConfrm = driver
				.findElement(By.xpath("//a[@href='/en-kw/men/'][normalize-space()='Yousef Al Mohammed']")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(CeleName, celebConfrm);

		// --------------------------------------------------------------------------------------
		// ------------------------
		// **PLP**-----------------------------------------------------
		// -----------------------------------------------------------------------------------

		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(3000);
		List<WebElement> plpItem = driver.findElements(By.xpath("//div[@class='product-item-details pb-2']"));
		System.out.println(plpItem.size());
		Thread.sleep(2000);

		// ----------------**Go to top & Refresh the page**---------------------
		driver.findElement(By.id("myBtn")).click();
		driver.navigate().refresh();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);

		// ---------------**Sort**-------------------------
		WebElement sort = driver.findElement(By.id("sorter"));
		Select dropdown = new Select(sort);
		dropdown.selectByVisibleText("Price: High to Low");
		Thread.sleep(2000);
		System.out.println("sort = " + dropdown.getFirstSelectedOption().getText());

		// ----------------** Filter By Category **----------------------------------
		// no. of filter
		 js.executeScript("window.scrollBy(0,1000)");
		  Thread.sleep(2000);
		  
		 
		  String subCat = "Accessories";
		  List<WebElement> filters = driver.findElements(By.tagName("dt"));
		  for(WebElement filter:filters)
		  {
			  
			 System.out.print(filter.getText()+" ");
			  
			  if(filter.getText().equals("Category"))
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

		for (WebElement Prodinfo : item) {
			System.out.println(Prodinfo.getText());
		}
		List<WebElement> addTo = driver.findElements(By.xpath("//div[@class='product-item-actions']/button"));

		for (WebElement addToCart : addTo) {
			if (addToCart.getText().equals("Buy Now")) {
				addToCart.click();
				Thread.sleep(2000);
				break;
			} else if (addToCart.getText().equals("Notify Me")) {
				Thread.sleep(3000);
				addToCart.click();

				driver.findElement(By.name("name")).sendKeys("Test");

				driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("Test107@tester.com");

				driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("849357358");

				driver.findElement(By.xpath("(//button[@class='btn btn-primary col-12'])[2]")).click();
				break;
			} else if (addToCart.getText().equals("View")) {
				addToCart.click();
				break;
			}
		}
		;
		

	}

}
