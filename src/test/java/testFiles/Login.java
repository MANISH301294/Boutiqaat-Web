package testFiles;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	
	// ----------------------**Login from Tab Bar**-------------------------------
	//@Test
	public void loginUser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.boutiqaat.com/en-kw/");
		driver.findElement(By.xpath("//span[normalize-space()='WOMEN']")).click();
		
		
		WebElement loginHover = driver.findElement(By.linkText("Log In"));
		Actions hover = new Actions(driver);
		hover.moveToElement(loginHover).build().perform();
		driver.findElement(By.xpath("//div[@class='ddhover']//input[@placeholder='Email']")).sendKeys("rastogimanish1312@gmail.com");
		driver.findElement(By.xpath("//div[@class='ddhover']//input[@placeholder='Password']")).sendKeys("Aarambh@2022");
		driver.findElement(By.xpath("//div[@class='ddhover']//button[@class='btn btn-primary col-12'][normalize-space()='LOGIN']")).click();
		driver.close();
		
		}
	
	// ----------------------**Login from page**-------------------------------
	@Test
	public void LogiNPage() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manish\\Documents\\Grid\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.boutiqaat.com/en-kw/");
		String[] itemsNeeded = {"Mirage","Helen","Zipper"};
		int j = 0;
		driver.findElement(By.xpath("//span[normalize-space()='MEN']")).click();
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("rastogimanish1312@gmail.com");
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("Aarambh@2022");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary col-12'][normalize-space()='LOGIN'])[2]")).click();
		Thread.sleep(3000);
		//-------------------------**Global Search**------------------
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//div[@class='searchCont searchBox position-relative far hint']"));
		a.moveToElement(move).click().keyDown(Keys.LEFT_SHIFT).sendKeys("SHIRT").sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);
		driver.navigate().back();
		// --------------------**wish list--------------
		String wish =  driver.findElement(By.xpath("//div[@class='links'][2]")).getText();
		String Wishlist = wish.substring(10,12);
		System.out.println("WishlistCount="+Wishlist);
		// -------------------**country name -------------
		String country = driver.findElement(By.xpath("//div[@class='flag-select menu-flags']")).getText();
		String Countryname = country.substring(0, 6);
		System.out.println("Country="+Countryname);
		Thread.sleep(4000);
		// -------------------**cart count--------------------------
		WebElement top = driver.findElement(By.xpath("//span[@class='cartCount']"));
	    System.out.println("cart before = "+top.getText());
		 // ------------------**scroll down-------------------------
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1450)");
        
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-name']/h2"));
		
       for(int i=0;i<products.size();i++)
       {
    	 String name =  products.get(i).getText();
    	 System.out.println(name);
    	 		
    	 String[] prodname = products.get(i).getText().split("-");
    	 String[] prodname1 = prodname[0].split(" ");
    	 String formattedName = prodname1[0].trim();
    	 
    	 // format it to get name 
          List<String> itemsNeededList =  Arrays.asList(itemsNeeded);
        
        if(itemsNeededList.contains(formattedName))
        {
        	j++;
        	driver.findElements(By.xpath("//button[@class='action tocart primary']")).get(i).click();
        	
        	if(j==itemsNeeded.length)
        	
        		break;
        }
        Thread.sleep(3000);
		    	 
      }
      Thread.sleep(4000);
      driver.findElement(By.id("myBtn")).click();
		
      System.out.println("cart after = "+top.getText());
		

	}
	
	}
